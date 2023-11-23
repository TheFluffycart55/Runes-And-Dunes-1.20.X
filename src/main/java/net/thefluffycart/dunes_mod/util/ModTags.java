package net.thefluffycart.dunes_mod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;

public class ModTags {
    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(RunesAndDunesMod.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> NEEDS_BONE_MARROW = tag("needs_bone_marrow");



    private static TagKey<Block> tag(String name){
        return BlockTags.create(new ResourceLocation(RunesAndDunesMod.MOD_ID));
    }

    private static TagKey<Block> forgeTag(String name){
        return BlockTags.create(new ResourceLocation("forge", name));
    }
    }
}