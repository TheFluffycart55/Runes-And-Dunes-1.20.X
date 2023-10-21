package net.thefluffycart.dunes_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RunesAndDunesMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DUST_BLOCK);
        blockWithItem(ModBlocks.SCORCHSTONE_BLOCK);
        blockWithItem(ModBlocks.VEREDITE_BLOCK);
        blockWithItem(ModBlocks.ECLIPSAL_BLOCK);
        blockWithItem(ModBlocks.BONE_MARROW_ORE);
        blockWithItem(ModBlocks.DUST_TOMBED_ARTIFACT);
        blockWithItem(ModBlocks.SAND_TOMBED_ARTIFACT);
        blockWithItem(ModBlocks.WINDSWEPT_SAND);
        blockWithItem(ModBlocks.EXCAVATION_LANTERN);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
