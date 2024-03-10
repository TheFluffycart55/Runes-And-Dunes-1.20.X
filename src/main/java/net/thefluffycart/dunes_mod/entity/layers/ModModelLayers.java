package net.thefluffycart.dunes_mod.entity.layers;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;

public class ModModelLayers {
    public static final ModelLayerLocation MEERKAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(RunesAndDunesMod.MOD_ID, "meerkat_layer"), "meerkat_layer");

    public static final ModelLayerLocation RED_PANDA_LAYER = new ModelLayerLocation(
            new ResourceLocation(RunesAndDunesMod.MOD_ID, "red_panda_layer"), "red_panda_layer");

    public static final ModelLayerLocation LEGLESS_LAYER = new ModelLayerLocation(
            new ResourceLocation(RunesAndDunesMod.MOD_ID, "legless_layer"), "legless_layer");

}
