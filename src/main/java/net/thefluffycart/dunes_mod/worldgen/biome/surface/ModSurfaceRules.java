package net.thefluffycart.dunes_mod.worldgen.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.worldgen.biome.ModBiomes;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource WINDSWEPT_SAND = makeStateRule(ModBlocks.WINDSWEPT_SAND.get());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, SAND), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.DUNES_BIOME),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, WINDSWEPT_SAND)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE)),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.OASIS_BIOME),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, WINDSWEPT_SAND)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE)),


                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
