package net.thefluffycart.dunes_mod.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.items.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RunesAndDunesMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.DUST);
        simpleItem(ModItems.DUSTY_ARTIFACT);
        simpleItem(ModItems.SANDY_ARTIFACT);
        simpleItem(ModItems.BONE_MARROW_INGOT);
        simpleItem(ModItems.RAW_BONE_MARROW);
        simpleItem(ModItems.SCORCHSTONE_GEM);
        simpleItem(ModItems.SCORCHSTONE_RELIC);
        simpleItem(ModItems.VEREDITE_GEM);
        simpleItem(ModItems.VEREDITE_RELIC);
        simpleItem(ModItems.ECLIPSAL_GEM);
        simpleItem(ModItems.ECLIPSAL_RELIC);
        simpleItem(ModItems.RELIC_TEMPLATE);
        simpleItem(ModItems.WEAPON_TEMPLATE);
        simpleItem(ModItems.SHATTERED_RELIC_TEMPLATE);
        simpleItem(ModItems.SHATTERED_WEAPON);
        simpleItem(ModItems.PAPYRUS);
        simpleItem(ModItems.PAPYRUS_CULM);
        withExistingParent(ModItems.MEERKAT_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        buttonItem(ModBlocks.OLIVE_BUTTON, ModBlocks.OLIVE_PLANKS);
        fenceItem(ModBlocks.OLIVE_FENCE, ModBlocks.OLIVE_PLANKS);

        buttonItem(ModBlocks.DUST_BRICK_BUTTON, ModBlocks.DUST_BRICKS);
        wallItem(ModBlocks.DUST_BRICK_WALL, ModBlocks.DUST_BRICKS);

        simpleBlockItem(ModBlocks.OLIVE_DOOR);
        simpleBlockItem(ModBlocks.WILTFLOWER);
        complexBlock(ModBlocks.CHISELED_DUST_BRICKS.get());

        complexBlock(ModBlocks.SIFTER.get());
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RunesAndDunesMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(RunesAndDunesMod.MOD_ID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(RunesAndDunesMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(RunesAndDunesMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RunesAndDunesMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(RunesAndDunesMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}