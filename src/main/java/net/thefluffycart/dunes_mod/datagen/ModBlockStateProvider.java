package net.thefluffycart.dunes_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.block.custom.PapyrusCropBlock;

import java.util.function.Function;

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
        blockWithItem(ModBlocks.WINDSWEPT_SAND);
        blockWithItem(ModBlocks.EXCAVATION_LANTERN);
        blockWithItem(ModBlocks.OLIVE_PLANKS);
        blockWithItem(ModBlocks.DUST_BRICKS);

        stairsBlock((StairBlock) ModBlocks.OLIVE_STAIRS.get(), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.OLIVE_SLAB.get()), blockTexture(ModBlocks.OLIVE_PLANKS.get()), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.OLIVE_BUTTON.get(), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.OLIVE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.OLIVE_PLANKS.get()));

        stairsBlock((StairBlock) ModBlocks.DUST_BRICK_STAIRS.get(), blockTexture(ModBlocks.DUST_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.DUST_BRICK_SLAB.get()), blockTexture(ModBlocks.DUST_BRICKS.get()), blockTexture(ModBlocks.DUST_BRICKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.DUST_BRICK_BUTTON.get(), blockTexture(ModBlocks.DUST_BRICKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.DUST_BRICK_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DUST_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.DUST_BRICK_WALL.get(), blockTexture(ModBlocks.DUST_BRICKS.get()));

        fenceBlock((FenceBlock) ModBlocks.OLIVE_FENCE.get(), blockTexture(ModBlocks.OLIVE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.OLIVE_FENCE_GATE.get(), blockTexture(ModBlocks.OLIVE_PLANKS.get()));

        doorBlockWithRenderType((DoorBlock)ModBlocks.OLIVE_DOOR.get(), modLoc("block/olive_door_bottom"), modLoc("block/olive_door_top"), "cutout");

        trapdoorBlockWithRenderType((TrapDoorBlock)ModBlocks.OLIVE_TRAPDOOR.get(), modLoc("block/olive_trapdoor"), true, "cutout");

        blockItem(ModBlocks.OLIVE_STAIRS);
        blockItem(ModBlocks.OLIVE_SLAB);
        blockItem(ModBlocks.OLIVE_PRESSURE_PLATE);
        blockItem(ModBlocks.OLIVE_FENCE_GATE);
        blockItem(ModBlocks.OLIVE_TRAPDOOR, "_bottom");

        blockItem(ModBlocks.DUST_BRICK_STAIRS);
        blockItem(ModBlocks.DUST_BRICK_SLAB);
        blockItem(ModBlocks.DUST_BRICK_PRESSURE_PLATE);
        blockItem(ModBlocks.OLIVE_FENCE_GATE);

        horizontalBlock(ModBlocks.SIFTER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/sifter")));

        simpleBlock(ModBlocks.WILTFLOWER.get(),
                models().cross(blockTexture(ModBlocks.WILTFLOWER.get()).getPath(), blockTexture(ModBlocks.WILTFLOWER.get())).renderType("cutout"));

        makePapyrusCrop(((PapyrusCropBlock) ModBlocks.PAPYRUS_CROP.get()), "papyrus_stage", "papyrus_stage");
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("dunes_mod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("dunes_mod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    public void makePapyrusCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> papyrusStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] papyrusStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((PapyrusCropBlock) block).getAgeProperty()),
                new ResourceLocation(RunesAndDunesMod.MOD_ID, "block/" + textureName + state.getValue(((PapyrusCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
