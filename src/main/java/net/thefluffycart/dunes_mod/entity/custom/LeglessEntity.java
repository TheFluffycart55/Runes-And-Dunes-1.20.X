package net.thefluffycart.dunes_mod.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.thefluffycart.dunes_mod.entity.ModEntities;
import net.thefluffycart.dunes_mod.entity.ai.LeglessAttackGoal;
import net.thefluffycart.dunes_mod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class LeglessEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(LeglessEntity.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public LeglessEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new LeglessAttackGoal(this, 1.15f, true));
        this.goalSelector.addGoal(3, new FleeSunGoal(this, 1.5f));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this,1d));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 4f));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, 20, true, true, (Predicate<LivingEntity>)null));

    }

    public static AttributeSupplier.Builder createAttributes ()
    {
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH,20D)
                .add(Attributes.MOVEMENT_SPEED, .15D)
                .add(Attributes.FOLLOW_RANGE, 30D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.65f)
                .add(Attributes.ATTACK_DAMAGE, 1f);
    }

    @Nullable
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0)
        {
            attackAnimationTimeout = 15;
            attackAnimationState.start(this.tickCount);

        }
        else
        {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking())
        {
            attackAnimationState.stop();
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

    public void setAttacking(boolean attacking)
    {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    /*SOUNDS*/

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.LEGLESS_MOAN.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.LEGLESS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.LEGLESS_DEATH.get();
    }
}