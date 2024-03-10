package net.thefluffycart.dunes_mod.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RunesAndDunesMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> VALUABLES_TAB = CREATIVE_MODE_TABS.register("valuables_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.SCORCHSTONE_RELIC.get()))
                    .title(Component.translatable("creativetab.valuables_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.SCORCHSTONE_GEM.get());
                        pOutput.accept(ModItems.VEREDITE_GEM.get());
                        pOutput.accept(ModItems.ECLIPSAL_GEM.get());

                        pOutput.accept(ModBlocks.SCORCHSTONE_RUNE_BLOCK.get());
                        pOutput.accept(ModBlocks.VEREDITE_RUNE_BLOCK.get());
                        pOutput.accept(ModBlocks.ECLIPSAL_RUNE_BLOCK.get());

                        pOutput.accept(ModItems.SCORCHSTONE_RUNE.get());
                        pOutput.accept(ModItems.VEREDITE_RUNE.get());
                        pOutput.accept(ModItems.ECLIPSAL_RUNE.get());


                        pOutput.accept(ModItems.SCORCHSTONE_RELIC.get());
                        pOutput.accept(ModItems.VEREDITE_RELIC.get());
                        pOutput.accept(ModItems.ECLIPSAL_RELIC.get());

                        pOutput.accept(ModItems.SANDY_TABLET.get());
                        pOutput.accept(ModItems.SHATTERED_TABLET.get());
                    }
                    ).build());

    public static final RegistryObject<CreativeModeTab> RESOURCES_TAB = CREATIVE_MODE_TABS.register("resources_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.MAHOGANY_PLANKS.get()))
                    .title(Component.translatable("creativetab.resources_tab"))
                    .displayItems((pParameters, pOutput) ->
                            {
                                pOutput.accept(ModItems.DUST.get());

                                pOutput.accept(ModBlocks.DUST_BLOCK.get());
                                pOutput.accept(ModBlocks.DUST_BRICKS.get());
                                pOutput.accept(ModBlocks.CHISELED_DUST_BRICKS.get());
                                pOutput.accept(ModBlocks.DUST_BRICK_STAIRS.get());
                                pOutput.accept(ModBlocks.DUST_BRICK_SLAB.get());
                                pOutput.accept(ModBlocks.DUST_BRICK_WALL.get());
                                pOutput.accept(ModBlocks.DUST_BRICK_BUTTON.get());
                                pOutput.accept(ModBlocks.DUST_BRICK_PRESSURE_PLATE.get());

                                pOutput.accept(ModBlocks.MAHOGANY_PLANKS.get());
                                pOutput.accept(ModBlocks.MAHOGANY_STAIRS.get());
                                pOutput.accept(ModBlocks.MAHOGANY_SLAB.get());
                                pOutput.accept(ModBlocks.MAHOGANY_FENCE.get());
                                pOutput.accept(ModBlocks.MAHOGANY_FENCE_GATE.get());
                                pOutput.accept(ModBlocks.MAHOGANY_DOOR.get());
                                pOutput.accept(ModBlocks.MAHOGANY_TRAPDOOR.get());
                                pOutput.accept(ModBlocks.MAHOGANY_BUTTON.get());
                                pOutput.accept(ModBlocks.MAHOGANY_PRESSURE_PLATE.get());

                                pOutput.accept(ModBlocks.MAHOGANY_LOG.get());
                                pOutput.accept(ModBlocks.MAHOGANY_WOOD.get());
                                pOutput.accept(ModBlocks.STRIPPED_MAHOGANY_LOG.get());
                                pOutput.accept(ModBlocks.STRIPPED_MAHOGANY_WOOD.get());
                                pOutput.accept(ModBlocks.MAHOGANY_SAPLING.get());
                                pOutput.accept(ModBlocks.MAHOGANY_LEAVES.get());

                                pOutput.accept(ModBlocks.EXCAVATION_LANTERN.get());
                                pOutput.accept(ModBlocks.SIFTER.get());

                                pOutput.accept(ModBlocks.WILTFLOWER.get());
                                pOutput.accept(ModItems.PAPYRUS_CULM.get());
                                pOutput.accept(ModItems.PAPYRUS.get());

                                pOutput.accept(ModItems.MEERKAT_SPAWN_EGG.get());
                                pOutput.accept(ModItems.LEGLESS_SPAWN_EGG.get());
                            }
                    ).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
