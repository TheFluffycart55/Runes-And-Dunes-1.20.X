package net.thefluffycart.dunes_mod.event;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.entity.ModEntities;
//import net.thefluffycart.dunes_mod.entity.client.LeglessModel;
import net.thefluffycart.dunes_mod.entity.client.DustProjectileModel;
import net.thefluffycart.dunes_mod.entity.client.LeglessModel;
import net.thefluffycart.dunes_mod.entity.client.MeerkatModel;
//import net.thefluffycart.dunes_mod.entity.custom.LeglessEntity;
import net.thefluffycart.dunes_mod.entity.client.RedPandaModel;
import net.thefluffycart.dunes_mod.entity.custom.LeglessEntity;
import net.thefluffycart.dunes_mod.entity.custom.MeerkatEntity;
import net.thefluffycart.dunes_mod.entity.custom.RedPandaEntity;
import net.thefluffycart.dunes_mod.entity.layers.ModModelLayers;

@Mod.EventBusSubscriber(modid = RunesAndDunesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ModModelLayers.MEERKAT_LAYER, MeerkatModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LEGLESS_LAYER, LeglessModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RED_PANDA_LAYER, RedPandaModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DUST_PROJECTILE_LAYER, DustProjectileModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.MEERKAT.get(), MeerkatEntity.createAttributes().build());
        event.put(ModEntities.LEGLESS.get(), LeglessEntity.createAttributes().build());
        event.put(ModEntities.RED_PANDA.get(), RedPandaEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.MEERKAT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE_WG,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
