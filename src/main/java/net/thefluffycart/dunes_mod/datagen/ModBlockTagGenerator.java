package net.thefluffycart.dunes_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
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

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SCORCHSTONE_RUNE_BLOCK.get(),
                        ModBlocks.VEREDITE_RUNE_BLOCK.get(),
                        ModBlocks.ECLIPSAL_RUNE_BLOCK.get(),
                        ModBlocks.EXCAVATION_LANTERN.get(),
                        ModBlocks.DUST_BRICKS.get(),
                        ModBlocks.CHISELED_DUST_BRICKS.get(),
                        ModBlocks.DUST_BRICK_STAIRS.get(),
                        ModBlocks.DUST_BRICK_SLAB.get(),
                        ModBlocks.DUST_BRICK_WALL.get(),
                        ModBlocks.DUST_BRICK_PRESSURE_PLATE.get(),
                        ModBlocks.DUST_BRICK_BUTTON.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.DUST_BLOCK.get());


        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.MAHOGANY_STAIRS.get(),
                ModBlocks.MAHOGANY_PLANKS.get(),
                ModBlocks.MAHOGANY_SLAB.get(),
                ModBlocks.MAHOGANY_PRESSURE_PLATE.get(),
                ModBlocks.MAHOGANY_BUTTON.get(),
                ModBlocks.MAHOGANY_FENCE.get(),
                ModBlocks.MAHOGANY_FENCE_GATE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SCORCHSTONE_RUNE_BLOCK.get(),
                        ModBlocks.VEREDITE_RUNE_BLOCK.get(),
                        ModBlocks.ECLIPSAL_RUNE_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.EXCAVATION_LANTERN.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAHOGANY_LOG.get())
                .add(ModBlocks.MAHOGANY_WOOD.get())
                .add(ModBlocks.STRIPPED_MAHOGANY_LOG.get())
                .add(ModBlocks.STRIPPED_MAHOGANY_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.MAHOGANY_PLANKS.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.MAHOGANY_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.MAHOGANY_FENCE_GATE.get());
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.MAHOGANY_PLANKS.get());
        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.MAHOGANY_SLAB.get());
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.MAHOGANY_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.MAHOGANY_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.MAHOGANY_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.MAHOGANY_BUTTON.get());
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.MAHOGANY_STAIRS.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.DUST_BRICK_WALL.get());
        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.DUST_BRICK_STAIRS.get());
        this.tag(BlockTags.SLABS)
                .add(ModBlocks.DUST_BRICK_SLAB.get());
        this.tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.DUST_BRICK_PRESSURE_PLATE.get());
        this.tag(BlockTags.BUTTONS)
                .add(ModBlocks.DUST_BRICK_BUTTON.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}