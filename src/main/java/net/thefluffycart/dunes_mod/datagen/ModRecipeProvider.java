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
import net.thefluffycart.dunes_mod.datagen.custom.SiftingRecipeBuilder;
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
                .save(pWriter, "dust_block_from_dust");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DUST_BLOCK.get())
                .pattern("SN")
                .pattern("NS")
                .define('N', Items.SAND)
                .define('S', Items.STRING)
                .unlockedBy("has_sand", inventoryTrigger(ItemPredicate.Builder.item().of(Items.SAND).build()))
                .save(pWriter, "dust_block_from_sand_and_string");

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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PAPER)
                .define('P', ModItems.PAPYRUS.get())
                .pattern("   ")
                .pattern("PPP")
                .pattern("   ")
                .unlockedBy("has_papyrus", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.PAPYRUS.get()).build()))
                .save(pWriter, "paper_from_papyrus");

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
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DUST_BRICKS.get())
                .define('D', ModBlocks.DUST_BRICK_SLAB.get())
                .pattern(" D ")
                .pattern(" D ")
                .pattern("   ")
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUST_BRICK_SLAB.get(), 6)
                .define('D', ModBlocks.DUST_BRICKS.get())
                .pattern("   ")
                .pattern("DDD")
                .pattern("   ")
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUST_BRICK_STAIRS.get(), 4)
                .define('D', ModBlocks.DUST_BRICKS.get())
                .pattern("D  ")
                .pattern("DD ")
                .pattern("DDD")
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUST_BRICK_WALL.get(), 6)
                .define('D', ModBlocks.DUST_BRICKS.get())
                .pattern("   ")
                .pattern("DDD")
                .pattern("DDD")
                .unlockedBy("has_dust_bricks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.WHAMMAGEDDON_MUSIC_DISC.get())
                .define('V', ModItems.VEREDITE_GEM.get())
                .define('O', Blocks.OBSIDIAN)
                .pattern("OOO")
                .pattern("OVO")
                .pattern("OOO")
                .unlockedBy("has_veredite_gem", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DUST_BRICKS.get()).build()))
                .save(pWriter);

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

        //new SiftingRecipeBuilder(Blocks.ACACIA_SAPLING, ModBlocks.MAHOGANY_SAPLING.get(), 1)
                //.unlockedBy("has_acacia_sapling", has(Blocks.ACACIA_SAPLING)).save(pWriter);

        new SiftingRecipeBuilder(Blocks.DIRT, ModItems.PAPYRUS_CULM.get(), 2)
                .unlockedBy("has_dirt", has(Blocks.DIRT)).save(pWriter);

        new SiftingRecipeBuilder(ModBlocks.DUST_BLOCK.get(), Blocks.SAND, 2)
                .unlockedBy("has_dusty_artifact", has(ModBlocks.DUST_BLOCK.get())).save(pWriter);
    }


}
