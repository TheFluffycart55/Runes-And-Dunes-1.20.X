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
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.SHATTERED_RELIC.get()))
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
                        pOutput.accept(ModItems.SHATTERED_RELIC.get());
                        pOutput.accept(ModItems.SHATTERED_WEAPON.get());
                    }
                    ).build());

    public static final RegistryObject<CreativeModeTab> RESOURCES_TAB = CREATIVE_MODE_TABS.register("resources_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.DUST.get()))
                    .title(Component.translatable("creativetab.resources_tab"))
                    .displayItems((pParameters, pOutput) ->
                            {
                                pOutput.accept(ModItems.DUST.get());
                                pOutput.accept(ModItems.RAW_BONE_MARROW.get());
                                pOutput.accept(ModBlocks.DUST_BLOCK.get());
                                pOutput.accept(ModItems.MEERKAT_SPAWN_EGG.get());
                            }
                    ).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
