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

    public static final RegistryObject<CreativeModeTab> GEMSTONES_TAB = CREATIVE_MODE_TABS.register("gemstones_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.SCORCHSTONE_GEM.get()))
                    .title(Component.translatable("creativetab.gems_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.SCORCHSTONE_GEM.get());
                        pOutput.accept(ModItems.VEREDITE_GEM.get());
                        pOutput.accept(ModItems.ECLIPSAL_GEM.get());
                        pOutput.accept(ModBlocks.SCORCHSTONE_BLOCK.get());
                        pOutput.accept(ModBlocks.VEREDITE_BLOCK.get());
                    }
                    ).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
