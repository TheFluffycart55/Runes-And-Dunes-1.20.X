package net.thefluffycart.dunes_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.entity.ModEntities;
import net.thefluffycart.dunes_mod.entity.client.MeerkatRenderer;
import net.thefluffycart.dunes_mod.items.ModCreativeModeTabs;
import net.thefluffycart.dunes_mod.items.ModItems;
import net.thefluffycart.dunes_mod.sound.ModSounds;
import org.slf4j.Logger;

@Mod(RunesAndDunesMod.MOD_ID)
public class RunesAndDunesMod
{
    public static final String MOD_ID = "dunes_mod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RunesAndDunesMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.SCORCHSTONE_GEM);
            event.accept(ModItems.VEREDITE_GEM);
            event.accept(ModItems.ECLIPSAL_GEM);
            event.accept(ModItems.DUST);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(ModBlocks.SCORCHSTONE_BLOCK);
            event.accept(ModBlocks.VEREDITE_BLOCK);
            event.accept(ModBlocks.ECLIPSAL_BLOCK);
            event.accept(ModBlocks.OLIVE_PLANKS);
            event.accept(ModBlocks.OLIVE_STAIRS);
            event.accept(ModBlocks.OLIVE_SLAB);
            event.accept(ModBlocks.OLIVE_FENCE);
            event.accept(ModBlocks.OLIVE_FENCE_GATE);
            event.accept(ModBlocks.OLIVE_DOOR);
            event.accept(ModBlocks.OLIVE_TRAPDOOR);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            event.accept(ModBlocks.DUST_BLOCK);
            event.accept(ModBlocks.WINDSWEPT_SAND);
            event.accept(ModBlocks.BONE_MARROW_ORE);
        }

        if(event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS)
        {
            event.accept(ModBlocks.OLIVE_PRESSURE_PLATE);
            event.accept(ModBlocks.OLIVE_BUTTON);
            event.accept(ModBlocks.OLIVE_DOOR);
            event.accept(ModBlocks.OLIVE_TRAPDOOR);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.MEERKAT.get(), MeerkatRenderer::new);
        }
    }
}
