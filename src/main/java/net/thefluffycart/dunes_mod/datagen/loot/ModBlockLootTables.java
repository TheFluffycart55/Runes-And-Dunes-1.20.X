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
        this.dropSelf(ModBlocks.SCORCHSTONE_BLOCK.get());
        this.dropSelf(ModBlocks.VEREDITE_BLOCK.get());
        this.dropSelf(ModBlocks.ECLIPSAL_BLOCK.get());
        this.dropSelf(ModBlocks.EXCAVATION_LANTERN.get());
        this.dropSelf(ModBlocks.WINDSWEPT_SAND.get());
        this.dropSelf(ModBlocks.OLIVE_STAIRS.get());
        this.dropSelf(ModBlocks.OLIVE_PLANKS.get());
        this.dropSelf(ModBlocks.OLIVE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.OLIVE_BUTTON.get());
        this.dropSelf(ModBlocks.OLIVE_FENCE.get());
        this.dropSelf(ModBlocks.OLIVE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.OLIVE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.SIFTER.get());


        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.PAPYRUS_CROP.get())
               .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PapyrusCropBlock.AGE, 8));
        this.add(ModBlocks.PAPYRUS_CROP.get(), this.createCropDrops(ModBlocks.PAPYRUS_CROP.get(),
               ModItems.PAPYRUS.get(), ModItems.PAPYRUS_CULM.get(), lootitemcondition$builder2));


        this.add(ModBlocks.OLIVE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OLIVE_SLAB.get()));

        this.add(ModBlocks.BONE_MARROW_ORE.get(),
                block -> createOreDrop(ModBlocks.BONE_MARROW_ORE.get(), ModItems.RAW_BONE_MARROW.get()));
        this.add(ModBlocks.DUST_BLOCK.get(),
                block -> createOreDrop(ModBlocks.DUST_BLOCK.get(), ModItems.DUST.get()));
        this.add(ModBlocks.SAND_TOMBED_ARTIFACT.get(),
                block -> createOreDrop(ModBlocks.SAND_TOMBED_ARTIFACT.get(), ModItems.SANDY_ARTIFACT.get()));
        this.add(ModBlocks.DUST_TOMBED_ARTIFACT.get(),
                block -> createOreDrop(ModBlocks.SAND_TOMBED_ARTIFACT.get(), ModItems.DUSTY_ARTIFACT.get()));
        this.add(ModBlocks.OLIVE_DOOR.get(),
                block -> createDoorTable(ModBlocks.OLIVE_DOOR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
