package net.thefluffycart.dunes_mod.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.worldgen.biome.custom.ModOverworldRegion;
import terrablender.api.Regions;

public class ModTerraBlenderAPI {
    public static void registerRegions(){
        Regions.register(new ModOverworldRegion(new ResourceLocation(RunesAndDunesMod.MOD_ID, "overworld"), 5));
    }
}
