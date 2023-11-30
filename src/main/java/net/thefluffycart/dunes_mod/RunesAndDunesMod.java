package net.thefluffycart.dunes_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.SurfaceRules;
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
import net.thefluffycart.dunes_mod.block.entity.ModBlockEntities;
import net.thefluffycart.dunes_mod.entity.ModEntities;
import net.thefluffycart.dunes_mod.entity.client.MeerkatRenderer;
import net.thefluffycart.dunes_mod.items.ModCreativeModeTabs;
import net.thefluffycart.dunes_mod.items.ModItems;
import net.thefluffycart.dunes_mod.loot.ModLootModifiers;
import net.thefluffycart.dunes_mod.recipe.ModRecipes;
import net.thefluffycart.dunes_mod.screen.ModMenuTypes;
import net.thefluffycart.dunes_mod.screen.SifterScreen;
import net.thefluffycart.dunes_mod.sound.ModSounds;
import net.thefluffycart.dunes_mod.villager.ModVillagers;
import net.thefluffycart.dunes_mod.worldgen.biome.ModTerraBlenderAPI;
import net.thefluffycart.dunes_mod.worldgen.biome.surface.ModSurfaceRules;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

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

        ModVillagers.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        ModTerraBlenderAPI.registerRegions();

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(()-> {
            ComposterBlock.COMPOSTABLES.put(ModItems.PAPYRUS.get(), 0.4f);
            ComposterBlock.COMPOSTABLES.put(ModItems.PAPYRUS_CULM.get(), 0.15f);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.WILTFLOWER.getId(), ModBlocks.POTTED_WILTFLOWER);

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());        });

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
            event.accept(ModBlocks.MAHOGANY_PLANKS);
            event.accept(ModBlocks.MAHOGANY_STAIRS);
            event.accept(ModBlocks.MAHOGANY_SLAB);
            event.accept(ModBlocks.MAHOGANY_FENCE);
            event.accept(ModBlocks.MAHOGANY_FENCE_GATE);
            event.accept(ModBlocks.MAHOGANY_DOOR);
            event.accept(ModBlocks.MAHOGANY_TRAPDOOR);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            event.accept(ModBlocks.DUST_BLOCK);
            event.accept(ModBlocks.WINDSWEPT_SAND);
            event.accept(ModBlocks.BONE_MARROW_ORE);
        }

        if(event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS)
        {
            event.accept(ModBlocks.MAHOGANY_PRESSURE_PLATE);
            event.accept(ModBlocks.MAHOGANY_BUTTON);
            event.accept(ModBlocks.MAHOGANY_DOOR);
            event.accept(ModBlocks.MAHOGANY_TRAPDOOR);
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

            MenuScreens.register(ModMenuTypes.SIFTER_MENU.get(), SifterScreen::new);
        }
    }
}
