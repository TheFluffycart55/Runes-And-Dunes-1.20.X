package net.thefluffycart.dunes_mod.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.block.custom.PapyrusCropBlock;
import net.thefluffycart.dunes_mod.items.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.EXCAVATION_LANTERN.get());

        this.dropSelf(ModBlocks.MAHOGANY_STAIRS.get());
        this.dropSelf(ModBlocks.MAHOGANY_PLANKS.get());
        this.dropSelf(ModBlocks.MAHOGANY_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MAHOGANY_BUTTON.get());
        this.dropSelf(ModBlocks.MAHOGANY_FENCE.get());
        this.dropSelf(ModBlocks.MAHOGANY_FENCE_GATE.get());
        this.dropSelf(ModBlocks.MAHOGANY_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MAHOGANY_LOG.get());
        this.dropSelf(ModBlocks.MAHOGANY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MAHOGANY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MAHOGANY_WOOD.get());
        this.dropSelf(ModBlocks.MAHOGANY_SAPLING.get());

        this.dropSelf(ModBlocks.WILTFLOWER.get());
        this.dropSelf(ModBlocks.SIFTER.get());

        this.dropSelf(ModBlocks.DUST_BRICKS.get());
        this.dropSelf(ModBlocks.CHISELED_DUST_BRICKS.get());
        this.dropSelf(ModBlocks.DUST_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.DUST_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DUST_BRICK_BUTTON.get());
        this.dropSelf(ModBlocks.DUST_BRICK_WALL.get());

        this.add(ModBlocks.MAHOGANY_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.MAHOGANY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.PAPYRUS_CROP.get())
               .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PapyrusCropBlock.AGE, 8));
        this.add(ModBlocks.PAPYRUS_CROP.get(), this.createCropDrops(ModBlocks.PAPYRUS_CROP.get(),
               ModItems.PAPYRUS.get(), ModItems.PAPYRUS_CULM.get(), lootitemcondition$builder2));

        this.add(ModBlocks.POTTED_WILTFLOWER.get(),createPotFlowerItemTable(ModBlocks.POTTED_WILTFLOWER.get()));

        this.add(ModBlocks.MAHOGANY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAHOGANY_SLAB.get()));
        this.add(ModBlocks.DUST_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DUST_BRICK_SLAB.get()));

        this.add(ModBlocks.DUST_BLOCK.get(),
                block -> createOreDrop(ModBlocks.DUST_BLOCK.get(), ModItems.DUST.get()));
        this.add(ModBlocks.SCORCHSTONE_RUNE_BLOCK.get(),
                block -> createOreDrop(ModBlocks.SCORCHSTONE_RUNE_BLOCK.get(), ModItems.SCORCHSTONE_GEM.get()));
        this.add(ModBlocks.VEREDITE_RUNE_BLOCK.get(),
                block -> createOreDrop(ModBlocks.VEREDITE_RUNE_BLOCK.get(), ModItems.VEREDITE_GEM.get()));
        this.add(ModBlocks.ECLIPSAL_RUNE_BLOCK.get(),
                block -> createOreDrop(ModBlocks.ECLIPSAL_RUNE_BLOCK.get(), ModItems.ECLIPSAL_GEM.get()));


        this.add(ModBlocks.DUST_BLOCK.get(),
                block -> createOreDrop(ModBlocks.DUST_BLOCK.get(), ModItems.DUST.get()));
        this.add(ModBlocks.DUST_BLOCK.get(),
                block -> createOreDrop(ModBlocks.DUST_BLOCK.get(), ModItems.DUST.get()));
        this.add(ModBlocks.MAHOGANY_DOOR.get(),
                block -> createDoorTable(ModBlocks.MAHOGANY_DOOR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
