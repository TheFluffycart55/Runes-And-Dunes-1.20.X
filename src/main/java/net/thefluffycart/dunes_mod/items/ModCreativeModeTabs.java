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

    public static final RegistryObject<CreativeModeTab> ARTIFACTS_TAB = CREATIVE_MODE_TABS.register("artifacts_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.SCORCHSTONE_GEM.get()))
                    .title(Component.translatable("creativetab.artifacts_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.SCORCHSTONE_GEM.get());
                        pOutput.accept(ModItems.VEREDITE_GEM.get());
                        pOutput.accept(ModItems.ECLIPSAL_GEM.get());
                        pOutput.accept(ModBlocks.SCORCHSTONE_BLOCK.get());
                        pOutput.accept(ModBlocks.VEREDITE_BLOCK.get());
                        pOutput.accept(ModBlocks.ECLIPSAL_BLOCK.get());
                        pOutput.accept(ModItems.SCORCHSTONE_RELIC.get());
                        pOutput.accept(ModItems.VEREDITE_RELIC.get());
                        pOutput.accept(ModItems.ECLIPSAL_RELIC.get());
                        pOutput.accept(ModItems.SHATTERED_RELIC_TEMPLATE.get());
                        pOutput.accept(ModItems.SHATTERED_WEAPON.get());
                        pOutput.accept(ModItems.RELIC_TEMPLATE.get());
                        pOutput.accept(ModItems.WEAPON_TEMPLATE.get());
                    }
                    ).build());

    public static final RegistryObject<CreativeModeTab> EXCAVATION_TAB = CREATIVE_MODE_TABS.register("excavation_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.DUSTY_ARTIFACT.get()))
                    .title(Component.translatable("creativetab.excavation_tab"))
                    .displayItems((pParameters, pOutput) ->
                            {
                                pOutput.accept(ModItems.DUST.get());
                                pOutput.accept(ModItems.RAW_BONE_MARROW.get());
                                pOutput.accept(ModItems.BONE_MARROW_INGOT.get());
                                pOutput.accept(ModBlocks.DUST_BLOCK.get());
                                pOutput.accept(ModBlocks.WINDSWEPT_SAND.get());
                                pOutput.accept(ModBlocks.BONE_MARROW_ORE.get());
                                pOutput.accept(ModBlocks.DUST_TOMBED_ARTIFACT.get());
                                pOutput.accept(ModBlocks.SAND_TOMBED_ARTIFACT.get());
                                pOutput.accept(ModItems.DUSTY_ARTIFACT.get());
                                pOutput.accept(ModItems.SANDY_ARTIFACT.get());
                                pOutput.accept(ModItems.MEERKAT_SPAWN_EGG.get());
                                pOutput.accept(ModBlocks.EXCAVATION_LANTERN.get());
                                pOutput.accept(ModItems.PAPYRUS_CULM.get());
                                pOutput.accept(ModItems.PAPYRUS.get());
                            }
                    ).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
