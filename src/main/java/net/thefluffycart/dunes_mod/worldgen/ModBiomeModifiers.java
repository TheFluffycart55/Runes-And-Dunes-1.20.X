package net.thefluffycart.dunes_mod.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.entity.ModEntities;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> SPAWN_MEERKAT = registerKey("spawn_meerkat");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_MEERKAT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_DESERT),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MEERKAT.get(), 100, 3, 5))));
    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(RunesAndDunesMod.MOD_ID, name));
    }
}
