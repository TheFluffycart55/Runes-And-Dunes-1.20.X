package net.thefluffycart.dunes_mod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.items.ModItems;
import net.thefluffycart.dunes_mod.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = RunesAndDunesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            if (event.getType() == ModVillagers.HISTORIAN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.DUST.get(), 8);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 4), stack, 8, 2, 0.04f
                ));

                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 10),
                        new ItemStack(Items.BRUSH, 1), 3, 2, 0.08f
                ));

                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.BONE, 12),
                        new ItemStack(Items.EMERALD, 3), 8, 1, 0.02f
                ));

                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.GOLD_INGOT, 4),
                        new ItemStack(Items.EMERALD, 2), 5, 3, 0.05f
                ));

                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 6),
                        new ItemStack(Items.WRITABLE_BOOK, 1), 8, 8, 0.04f
                ));

                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 10),
                        new ItemStack(Items.MAP, 1), 5, 4, 0.04f
                ));

                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 6),
                        new ItemStack(ModBlocks.SIFTER.get(), 1), 5, 2, 0.06f
                ));

                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.SNIFFER_EGG, 1),
                        new ItemStack(Items.EMERALD, 8), 5, 2, 0.04f
                ));

                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.SUSPICIOUS_SAND, 10),
                        new ItemStack(Items.EMERALD, 6), 5, 2, 0.04f
                ));
            }
        }
}