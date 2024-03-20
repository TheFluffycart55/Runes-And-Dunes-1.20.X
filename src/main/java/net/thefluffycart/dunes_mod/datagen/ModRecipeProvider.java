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
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.datagen.custom.SiftingRecipeBuilder;
import net.thefluffycart.dunes_mod.items.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{

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
                .save(pWriter, "dust_block_from_dust");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DUST_BLOCK.get(), 2)
                .pattern("SN")
                .pattern("NS")
                .define('N', Items.SAND)
                .define('S', Items.STRING)
                .unlockedBy("has_sand", inventoryTrigger(ItemPredicate.Builder.item().of(Items.SAND).build()))
                .save(pWriter, "dust_block_from_sand_and_string");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.POCKET_DUST.get(), 1)
                .define('D', ModItems.DUST.get())
                .define('B', Items.BUNDLE)
                .pattern("DDD")
                .pattern("DBD")
                .pattern("DDD")
                .unlockedBy("has_bundle", inventoryTrigger(ItemPredicate.Builder.item().of(Items.BUNDLE).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.DUST.get(), 4)
                        .requires(ModBlocks.DUST_BLOCK.get())
                        .unlockedBy("has_dust_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SIFTER.get())
                .define('P', ItemTags.PLANKS)
                .define('C', Items.COPPER_INGOT)
                .define('S', Items.STRING)
                .define('B', Items.BRUSH)
                .pattern("SSS")
                .pattern("CBC")
                .pattern("PPP")
                .unlockedBy("has_copper", inventoryTrigger(ItemPredicate.Builder.item().of(Items.COPPER_INGOT).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PAPER)
                .define('P', ModItems.PAPYRUS.get())
                .pattern("   ")
                .pattern("PPP")
                .pattern("   ")
                .unlockedBy("has_papyrus", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.PAPYRUS.get()).build()))
                .save(pWriter, "paper_from_papyrus");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BUNDLE)
                .define('S', Items.STRING)
                .define('R', Items.RABBIT_HIDE)
                .pattern("SRS")
                .pattern("R R")
                .pattern("RRR")
                .unlockedBy("has_rabbit_hide", inventoryTrigger(ItemPredicate.Builder.item().of(Items.RABBIT_HIDE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SCORCHSTONE_RUNE.get())
                .define('S', ModItems.SCORCHSTONE_GEM.get())
                .define('T', ModItems.SHATTERED_TABLET.get())
                .define('M', Items.MUD_BRICKS)
                .pattern("MSM")
                .pattern("MTM")
                .pattern("MMM")
                .unlockedBy("has_scorchstone_gem", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.SCORCHSTONE_GEM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VEREDITE_RUNE.get())
                .define('S', ModItems.VEREDITE_GEM.get())
                .define('T', ModItems.SHATTERED_TABLET.get())
                .define('M', Items.MUD_BRICKS)
                .pattern("MSM")
                .pattern("MTM")
                .pattern("MMM")
                .unlockedBy("has_veredite_gem", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.VEREDITE_GEM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECLIPSAL_RUNE.get())
                .define('S', ModItems.ECLIPSAL_GEM.get())
                .define('T', ModItems.SHATTERED_TABLET.get())
                .define('M', Items.MUD_BRICKS)
                .pattern("MSM")
                .pattern("MTM")
                .pattern("MMM")
                .unlockedBy("has_eclipsal_gem", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.ECLIPSAL_GEM.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS.get(), 4)
                .requires(ModBlocks.MAHOGANY_LOG.get())
                .unlockedBy("has_mahogany_log", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.MAHOGANY_LOG.get()).build()))
                .save(pWriter, "mahogany_planks_from_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS.get(), 4)
                .requires(ModBlocks.MAHOGANY_WOOD.get())
                .unlockedBy("has_mahogany_wood", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.MAHOGANY_WOOD.get()).build()))
                .save(pWriter, "mahogany_planks_from_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_MAHOGANY_LOG.get())
                .unlockedBy("has_stripped_mahogany_log", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.STRIPPED_MAHOGANY_LOG.get()).build()))
                .save(pWriter, "mahogany_planks_from_stripped_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_MAHOGANY_WOOD.get())
                .unlockedBy("has_stripped_mahogany_wood", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.STRIPPED_MAHOGANY_WOOD.get()).build()))
                .save(pWriter, "mahogany_planks_from_stripped_wood");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_WOOD.get(), 3)
                .define('M', ModBlocks.MAHOGANY_LOG.get())
                .pattern("MM ")
                .pattern("MM ")
                .pattern("   ")
                .unlockedBy("has_mahogany_log", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.MAHOGANY_LOG.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_MAHOGANY_WOOD.get(), 3)
                .define('M', ModBlocks.STRIPPED_MAHOGANY_LOG.get())
                .pattern("MM ")
                .pattern("MM ")
                .pattern("   ")
                .unlockedBy("has_stripped_mahogany_log", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.STRIPPED_MAHOGANY_LOG.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_SLAB.get(), 6)
                .define('M', ModBlocks.MAHOGANY_PLANKS.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("MMM")
                .unlockedBy("has_mahogany_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.MAHOGANY_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_STAIRS.get(), 4)
                .define('M', ModBlocks.MAHOGANY_PLANKS.get())
                .pattern("M  ")
                .pattern("MM ")
                .pattern("MMM")
                .unlockedBy("has_mahogany_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.MAHOGANY_PLANKS.get()).build()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_FENCE.get(), 3)
                .define('M', ModBlocks.MAHOGANY_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("MSM")
                .pattern("MSM")
                .pattern("   ")
                .unlockedBy("has_mahogany_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.MAHOGANY_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_FENCE_GATE.get())
                .define('M', ModBlocks.MAHOGANY_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("SMS")
                .pattern("SMS")
                .pattern("   ")
                .unlockedBy("has_mahogany_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.MAHOGANY_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_TRAPDOOR.get(), 3)
                .define('M', ModBlocks.MAHOGANY_PLANKS.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("   ")
                .unlockedBy("has_mahogany_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.MAHOGANY_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_DOOR.get(), 3)
                .define('M', ModBlocks.MAHOGANY_PLANKS.get())
                .pattern("MM ")
                .pattern("MM ")
                .pattern("MM ")
                .unlockedBy("has_mahogany_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.MAHOGANY_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PRESSURE_PLATE.get())
                .define('M', ModBlocks.MAHOGANY_PLANKS.get())
                .pattern("   ")
                .pattern("MM ")
                .pattern("   ")
                .unlockedBy("has_mahogany_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.MAHOGANY_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_BUTTON.get())
                .define('M', ModBlocks.MAHOGANY_PLANKS.get())
                .pattern("   ")
                .pattern(" M ")
                .pattern("   ")
                .unlockedBy("has_mahogany_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.MAHOGANY_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUST_BRICKS.get(), 4)
                .define('D', ModBlocks.DUST_BLOCK.get())
                .pattern("DD ")
                .pattern("DD ")
                .pattern("   ")
                .unlockedBy("has_dust_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter, "dust_bricks_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DUST_BRICKS.get())
                .define('D', ModBlocks.DUST_BRICK_SLAB.get())
                .pattern(" D ")
                .pattern(" D ")
                .pattern("   ")
                .unlockedBy("has_dust_brick", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter, "chiseled_dust_bricks_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUST_BRICK_SLAB.get(), 6)
                .define('D', ModBlocks.DUST_BRICKS.get())
                .pattern("   ")
                .pattern("DDD")
                .pattern("   ")
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter, "dust_slabs_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUST_BRICK_STAIRS.get(), 4)
                .define('D', ModBlocks.DUST_BRICKS.get())
                .pattern("D  ")
                .pattern("DD ")
                .pattern("DDD")
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter, "dust_stairs_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUST_BRICK_WALL.get(), 6)
                .define('D', ModBlocks.DUST_BRICKS.get())
                .pattern("   ")
                .pattern("DDD")
                .pattern("DDD")
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter, "dust_walls_from_crafting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DUST_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DUST_BRICKS.get())
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter, "chiseled_dust_bricks_from_cutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DUST_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUST_BRICK_STAIRS.get())
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter, "dust_brick_stairs_from_cutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DUST_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUST_BRICK_WALL.get())
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter, "dust_brick_walls_from_cutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DUST_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUST_BRICK_SLAB.get(), 2)
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter, "dust_brick_slabs_from_cutting");

        new SiftingRecipeBuilder(ModBlocks.DUST_BLOCK.get(), Blocks.SAND, 2)
                .unlockedBy("has_dust_block", has(ModBlocks.DUST_BLOCK.get())).save(pWriter);
        new SiftingRecipeBuilder(ModItems.SANDY_TABLET.get(), ModItems.SHATTERED_TABLET.get(), 1)
                .unlockedBy("has_sandy_tablet", has(ModItems.SANDY_TABLET.get())).save(pWriter);
        new SiftingRecipeBuilder(Blocks.GRAVEL, Items.FLINT, 2)
                .unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(pWriter);
        new SiftingRecipeBuilder(Blocks.SOUL_SAND, Items.GOLD_NUGGET, 2)
                .unlockedBy("has_soul_sand", has(Blocks.SOUL_SAND)).save(pWriter);
        new SiftingRecipeBuilder(Blocks.SOUL_SOIL, Items.QUARTZ, 4)
                .unlockedBy("has_soul_soil", has(Blocks.SOUL_SOIL)).save(pWriter);
    }

}
