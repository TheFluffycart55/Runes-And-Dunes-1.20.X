package net.thefluffycart.dunes_mod.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.items.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    private static final List<ItemLike> BONE_MARROW_SMELTABLES = List.of(ModItems.RAW_BONE_MARROW.get(),
            ModBlocks.BONE_MARROW_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DUST_BLOCK.get())
                .pattern("XX")
                .pattern("XX")
                .define('X', ModItems.DUST.get())
                .unlockedBy("has_dust", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.DUST.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SIFTER.get())
                .define('X', ItemTags.WOODEN_SLABS)
                .define('T', Items.STICK)
                .define('S', Items.STRING)
                .define('B', Items.BRUSH)
                .pattern("XSX")
                .pattern("XBX")
                .pattern("T T")
                .unlockedBy("has_copper", inventoryTrigger(ItemPredicate.Builder.item().of(Items.COPPER_INGOT).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RELIC_TEMPLATE.get())
                .define('R', ModItems.SHATTERED_RELIC_TEMPLATE.get())
                .define('S', Items.SAND)
                .define('C', Items.COPPER_INGOT)
                .pattern("CRC")
                .pattern("CSC")
                .pattern("CCC")
                .unlockedBy("has_brush", inventoryTrigger(ItemPredicate.Builder.item().of(Items.BRUSH).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.SCORCHSTONE_GEM.get(), RecipeCategory.MISC, ModBlocks.SCORCHSTONE_BLOCK.get());

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.VEREDITE_GEM.get(), RecipeCategory.MISC, ModBlocks.VEREDITE_BLOCK.get());

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.ECLIPSAL_GEM.get(), RecipeCategory.MISC, ModBlocks.ECLIPSAL_BLOCK.get());

        oreSmelting(pWriter, BONE_MARROW_SMELTABLES, RecipeCategory.MISC, ModItems.BONE_MARROW_INGOT.get(), 0.15f, 200, "bone_marrow");
        oreBlasting(pWriter, BONE_MARROW_SMELTABLES, RecipeCategory.MISC, ModItems.BONE_MARROW_INGOT.get(), 0.15f, 100, "bone_marrow");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SCORCHSTONE_GEM.get(), 9)
                .requires(ModBlocks.SCORCHSTONE_BLOCK.get())
                .unlockedBy("has_scorchstone", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.SCORCHSTONE_GEM.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VEREDITE_GEM.get(), 9)
                .requires(ModBlocks.VEREDITE_BLOCK.get())
                .unlockedBy("has_veredite", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.VEREDITE_GEM.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ECLIPSAL_GEM.get(), 9)
                .requires(ModBlocks.ECLIPSAL_BLOCK.get())
                .unlockedBy("has_eclipsal", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.ECLIPSAL_GEM.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SHATTERED_RELIC_TEMPLATE.get(), 1)
                .requires(ModItems.DUSTY_ARTIFACT.get())
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_dusty_artifact", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.DUSTY_ARTIFACT.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SHATTERED_RELIC_TEMPLATE.get(), 1)
                .requires(ModItems.SANDY_ARTIFACT.get())
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_sandy_artifact", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.DUSTY_ARTIFACT.get()).build()))
                .save(pWriter);
    }
}
