package net.thefluffycart.dunes_mod.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.entity.ModEntities;
import net.thefluffycart.dunes_mod.entity.client.MeerkatModel;
import net.thefluffycart.dunes_mod.entity.custom.MeerkatEntity;
import net.thefluffycart.dunes_mod.entity.layers.ModModelLayers;

@Mod.EventBusSubscriber(modid = RunesAndDunesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ModModelLayers.MEERKAT_LAYER, MeerkatModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.MEERKAT.get(), MeerkatEntity.createAttributes().build());
    }
}
