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
        blockWithItem(ModBlocks.MAHOGANY_PLANKS);
        blockWithItem(ModBlocks.DUST_BRICKS);

        stairsBlock((StairBlock) ModBlocks.MAHOGANY_STAIRS.get(), blockTexture(ModBlocks.MAHOGANY_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.MAHOGANY_SLAB.get()), blockTexture(ModBlocks.MAHOGANY_PLANKS.get()), blockTexture(ModBlocks.MAHOGANY_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.MAHOGANY_BUTTON.get(), blockTexture(ModBlocks.MAHOGANY_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.MAHOGANY_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MAHOGANY_PLANKS.get()));

        stairsBlock((StairBlock) ModBlocks.DUST_BRICK_STAIRS.get(), blockTexture(ModBlocks.DUST_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.DUST_BRICK_SLAB.get()), blockTexture(ModBlocks.DUST_BRICKS.get()), blockTexture(ModBlocks.DUST_BRICKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.DUST_BRICK_BUTTON.get(), blockTexture(ModBlocks.DUST_BRICKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.DUST_BRICK_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DUST_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.DUST_BRICK_WALL.get(), blockTexture(ModBlocks.DUST_BRICKS.get()));

        fenceBlock((FenceBlock) ModBlocks.MAHOGANY_FENCE.get(), blockTexture(ModBlocks.MAHOGANY_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.MAHOGANY_FENCE_GATE.get(), blockTexture(ModBlocks.MAHOGANY_PLANKS.get()));

        doorBlockWithRenderType((DoorBlock)ModBlocks.MAHOGANY_DOOR.get(), modLoc("block/mahogany_door_bottom"), modLoc("block/mahogany_door_top"), "cutout");

        trapdoorBlockWithRenderType((TrapDoorBlock)ModBlocks.MAHOGANY_TRAPDOOR.get(), modLoc("block/mahogany_trapdoor"), true, "cutout");

        blockItem(ModBlocks.MAHOGANY_STAIRS);
        blockItem(ModBlocks.MAHOGANY_SLAB);
        blockItem(ModBlocks.MAHOGANY_PRESSURE_PLATE);
        blockItem(ModBlocks.MAHOGANY_FENCE_GATE);
        blockItem(ModBlocks.MAHOGANY_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.MAHOGANY_LOG);
        blockItem(ModBlocks.MAHOGANY_WOOD);
        blockItem(ModBlocks.STRIPPED_MAHOGANY_LOG);
        blockItem(ModBlocks.STRIPPED_MAHOGANY_WOOD);
        blockItem(ModBlocks.MAHOGANY_FENCE_GATE);

        blockItem(ModBlocks.DUST_BRICK_STAIRS);
        blockItem(ModBlocks.DUST_BRICK_SLAB);
        blockItem(ModBlocks.DUST_BRICK_PRESSURE_PLATE);

        saplingBlock(ModBlocks.MAHOGANY_SAPLING);

        leavesBlock(ModBlocks.MAHOGANY_LEAVES);

        horizontalBlock(ModBlocks.SIFTER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/sifter")));

        logBlock(((RotatedPillarBlock) ModBlocks.MAHOGANY_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.MAHOGANY_WOOD.get()), blockTexture(ModBlocks.MAHOGANY_LOG.get()),  blockTexture(ModBlocks.MAHOGANY_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAHOGANY_LOG.get(), new ResourceLocation(RunesAndDunesMod.MOD_ID, "block/stripped_mahogany_log"),
                new ResourceLocation(RunesAndDunesMod.MOD_ID, "block/stripped_mahogany_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAHOGANY_WOOD.get(), new ResourceLocation(RunesAndDunesMod.MOD_ID, "block/stripped_mahogany_log"),
                new ResourceLocation(RunesAndDunesMod.MOD_ID, "block/stripped_mahogany_log"));
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

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
