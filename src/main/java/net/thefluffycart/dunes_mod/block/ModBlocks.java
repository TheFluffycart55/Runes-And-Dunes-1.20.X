package net.thefluffycart.dunes_mod.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.custom.PapyrusCropBlock;
import net.thefluffycart.dunes_mod.block.custom.SifterBlock;
import net.thefluffycart.dunes_mod.items.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RunesAndDunesMod.MOD_ID);

    //GEM BLOCKS
    public static final RegistryObject<Block> SCORCHSTONE_BLOCK = registerBlock("scorchstone_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).instrument(NoteBlockInstrument.BELL)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> VEREDITE_BLOCK = registerBlock("veredite_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).instrument(NoteBlockInstrument.BELL)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ECLIPSAL_BLOCK = registerBlock("eclipsal_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).instrument(NoteBlockInstrument.BELL)
                    .requiresCorrectToolForDrops()));

    //RESOURCES
    public static final RegistryObject<Block> DUST_BLOCK = registerBlock("dust_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.GRAVEL).instrument(NoteBlockInstrument.DIDGERIDOO)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WINDSWEPT_SAND = registerBlock("windswept_sand",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));
    public static final RegistryObject<Block> BONE_MARROW_ORE = registerBlock("bone_marrow_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SAND).strength(2.5f).requiresCorrectToolForDrops()
                    , UniformInt.of(2,4)));
    public static final RegistryObject<Block> SAND_TOMBED_ARTIFACT = registerBlock("sand_tombed_artifact",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SAND).strength(2.5f).requiresCorrectToolForDrops()
                    , UniformInt.of(2,4)));
    public static final RegistryObject<Block> DUST_TOMBED_ARTIFACT = registerBlock("dust_tombed_artifact",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SAND).strength(2.5f).requiresCorrectToolForDrops()
                    , UniformInt.of(2,4)));
    public static final RegistryObject<Block> EXCAVATION_LANTERN = registerBlock("excavation_lantern",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)
                    .instrument(NoteBlockInstrument.CHIME).sound(SoundType.CHAIN)));

    //Wood
    public static final RegistryObject<Block> OLIVE_PLANKS = registerBlock("olive_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> OLIVE_STAIRS = registerBlock("olive_stairs",
            ()-> new StairBlock(() -> ModBlocks.OLIVE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BIRCH_STAIRS)));
    public static final RegistryObject<Block> OLIVE_SLAB = registerBlock("olive_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_SLAB)));
    public static final RegistryObject<Block> OLIVE_PRESSURE_PLATE = registerBlock("olive_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.BIRCH_STAIRS).sound(SoundType.METAL), BlockSetType.BIRCH));
    public static final RegistryObject<Block> OLIVE_BUTTON = registerBlock("olive_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE_SLAB).sound(SoundType.METAL), BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> OLIVE_FENCE = registerBlock("olive_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> OLIVE_FENCE_GATE = registerBlock("olive_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> OLIVE_DOOR = registerBlock("olive_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_DOOR), BlockSetType.BIRCH));
    public static final RegistryObject<Block> OLIVE_TRAPDOOR = registerBlock("olive_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR), BlockSetType.BIRCH));

    //CUSTOM
    public static final RegistryObject<Block> SIFTER = registerBlock("sifter",
            ()-> new SifterBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> PAPYRUS_CROP = registerBlock("papyrus_crop",
            ()-> new PapyrusCropBlock(BlockBehaviour.Properties.copy(Blocks.SUGAR_CANE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
