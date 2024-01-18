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
                ItemStack stack = new ItemStack(ModItems.DUST.get(), 6);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3), stack, 6, 1, 0.02f
                ));

                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.SAND, 16),
                        new ItemStack(Items.EMERALD, 2), 6, 1, 0.02f
                ));

                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.FEATHER, 8),
                        new ItemStack(Items.EMERALD, 1), 5, 4, 0.02f
                ));

                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.BONE, 12),
                        new ItemStack(Items.EMERALD, 3), 5, 4, 0.02f
                ));

                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 2),
                        new ItemStack(Items.QUARTZ, 6), 8, 8, 0.04f
                ));

                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 4),
                        new ItemStack(ModBlocks.SIFTER.get(), 1), 4, 12, 0.06f
                ));

                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 6),
                        new ItemStack(Items.WRITABLE_BOOK, 1), 6, 8, 0.04f
                ));

                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3),
                        new ItemStack(Items.BRUSH, 1), 8, 12, 0.06f
                ));

                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.GOLD_INGOT, 8),
                        new ItemStack(Items.EMERALD, 3), 8, 12, 0.06f
                ));

                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 6),
                        new ItemStack(Items.SKELETON_SKULL, 1), 6, 20, 0.08f
                ));

                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(ModItems.SANDY_TABLET.get(), 1),
                        new ItemStack(Items.EMERALD, 10), 6, 20, 0.08f
                ));

                trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.SNIFFER_EGG, 1),
                        new ItemStack(Items.EMERALD, 16), 6, 20, 0.08f
                ));

                trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 4),
                        new ItemStack(Items.BONE_BLOCK, 3), 6, 12, 0.06f
                ));
            }
        }
}