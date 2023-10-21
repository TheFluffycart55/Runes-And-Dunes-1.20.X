package net.thefluffycart.dunes_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;


public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RunesAndDunesMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(Tags.Blocks.ORES)
                .add(ModBlocks.BONE_MARROW_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SCORCHSTONE_BLOCK.get(),
                        ModBlocks.VEREDITE_BLOCK.get(),
                        ModBlocks.ECLIPSAL_BLOCK.get(),
                        ModBlocks.EXCAVATION_LANTERN.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.DUST_BLOCK.get(),
                ModBlocks.BONE_MARROW_ORE.get(),
                ModBlocks.WINDSWEPT_SAND.get(),
                ModBlocks.DUST_TOMBED_ARTIFACT.get(),
                ModBlocks.SAND_TOMBED_ARTIFACT.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DUST_TOMBED_ARTIFACT.get(),
                        ModBlocks.SAND_TOMBED_ARTIFACT.get(),
                        ModBlocks.SCORCHSTONE_BLOCK.get(),
                        ModBlocks.VEREDITE_BLOCK.get(),
                        ModBlocks.ECLIPSAL_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.EXCAVATION_LANTERN.get(),
                        ModBlocks.BONE_MARROW_ORE.get(),
                        ModBlocks.WINDSWEPT_SAND.get(),
                        ModBlocks.DUST_BLOCK.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}