package net.thefluffycart.dunes_mod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import net.thefluffycart.dunes_mod.entity.ModEntities;
import net.thefluffycart.dunes_mod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class MeerkatEntity extends TamableAnimal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState sitAnimationState = new AnimationState();
    private int sitAnimationTimeout = 0;

    public MeerkatEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.2d, 24, 3f, false));
        this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.1d));

        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1d, Ingredient.of(Items.COD), true));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this,1d));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 4f));

    }

    public static AttributeSupplier.Builder createAttributes ()
    {
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH,15D)
                .add(Attributes.MOVEMENT_SPEED, .20D)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.MEERKAT.get().create(pLevel);
    }
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isInSittingPose()) {
            sitAnimationState.startIfStopped(this.tickCount);
        }
        else{
            sitAnimationState.stop();
        }
    }

    protected void updateWalkAnimation(float v) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.walkAnimation.update(f, 0.15F);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    /*SOUNDS*/

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.MEERKAT_IDLE.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.MEERKAT_HURT.get();
    }

    /*BREEDING*/

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.COD);
    }

    /*TAMING*/

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {

        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item item = itemstack.getItem();

        Item itemForTaming = Items.COD;

        if(item == itemForTaming && !isTame()) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            }
            else{
                if(!pPlayer.getAbilities().instabuild){
                    itemstack.shrink(1);
                }

                if(!ForgeEventFactory.onAnimalTame(this, pPlayer))
                {
                    if(!this.level().isClientSide) {
                        super.tame(pPlayer);
                        this.navigation.recomputePath();
                        this.setTarget(null);
                        this.level().broadcastEntityEvent(this, (byte)7);
                        setOrderedToSit(true);
                        this.setInSittingPose(true);
                    }
                }


                return InteractionResult.SUCCESS;
            }

        }
        //SIT TOGGLE
        if(isTame() && pHand == InteractionHand.MAIN_HAND)
        {
            setOrderedToSit(!isOrderedToSit());
            setInSittingPose(!isOrderedToSit());
            return InteractionResult.SUCCESS;
        }

        return super.mobInteract(pPlayer, pHand);
    }

}