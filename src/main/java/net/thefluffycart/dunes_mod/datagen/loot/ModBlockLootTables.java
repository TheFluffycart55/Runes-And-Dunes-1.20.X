package net.thefluffycart.dunes_mod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.block.ModBlocks;
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

        this.add(ModBlocks.BONE_MARROW_ORE.get(),
                block -> createOreDrop(ModBlocks.BONE_MARROW_ORE.get(), ModItems.RAW_BONE_MARROW.get()));
        this.add(ModBlocks.DUST_BLOCK.get(),
                block -> createOreDrop(ModBlocks.DUST_BLOCK.get(), ModItems.DUST.get()));
        this.add(ModBlocks.SAND_TOMBED_ARTIFACT.get(),
                block -> createOreDrop(ModBlocks.SAND_TOMBED_ARTIFACT.get(), ModItems.SANDY_ARTIFACT.get()));
        this.add(ModBlocks.DUST_TOMBED_ARTIFACT.get(),
                block -> createOreDrop(ModBlocks.SAND_TOMBED_ARTIFACT.get(), ModItems.DUSTY_ARTIFACT.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
