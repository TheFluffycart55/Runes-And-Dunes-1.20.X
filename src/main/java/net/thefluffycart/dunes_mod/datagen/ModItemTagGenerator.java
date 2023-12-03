package net.thefluffycart.dunes_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.items.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, RunesAndDunesMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAHOGANY_LOG.get().asItem())
                .add(ModBlocks.MAHOGANY_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAHOGANY_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAHOGANY_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.MAHOGANY_PLANKS.get().asItem());

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.JNANA_AND_VIDYA_MUSIC_DISC.get())
                .add(ModItems.WHAMMAGEDDON_MUSIC_DISC.get());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
