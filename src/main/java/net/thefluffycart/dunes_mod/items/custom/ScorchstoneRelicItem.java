package net.thefluffycart.dunes_mod.items.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ScorchstoneRelicItem extends Item
{
    public ScorchstoneRelicItem(Item.Properties pProperties) {super(pProperties);}

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        if (!pLevel.isClientSide) {
            ItemStack itemstack = pPlayer.getItemInHand(pHand);
            pLevel.playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.TOTEM_USE, SoundSource.PLAYERS, 0.5F, 1F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
            System.out.println("Totem Right Clicked!");
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 2));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 2));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 500, 2));



            if (pPlayer instanceof Player) {
                ((Player)pPlayer).getCooldowns().addCooldown(this, 900);
            }
        }
        if (!pPlayer.getAbilities().instabuild) {
            pPlayer.awardStat(Stats.ITEM_USED.get(this));
            ItemStack itemstack = pPlayer.getItemInHand(pHand);
            itemstack.shrink(1);
            return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
        }
        return super.use(pLevel, pPlayer, pHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.dunes_mod.scorchstone_relic.tooltip.shift"));

        }

        else {
            pTooltipComponents.add(Component.translatable("tooltip.dunes_mod.scorchstone_relic.tooltip"));
        }
    }

}
