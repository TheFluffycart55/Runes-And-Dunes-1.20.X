package net.thefluffycart.dunes_mod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.custom.GravityBlock;
import net.thefluffycart.dunes_mod.block.custom.ModFlammableRotatedPillarBlock;
import net.thefluffycart.dunes_mod.block.custom.PapyrusCropBlock;
import net.thefluffycart.dunes_mod.block.custom.SifterBlock;
import net.thefluffycart.dunes_mod.items.ModItems;
import net.thefluffycart.dunes_mod.worldgen.tree.MahoganyTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RunesAndDunesMod.MOD_ID);

    //GEM BLOCKS
    public static final RegistryObject<Block> SCORCHSTONE_RUNE_BLOCK = registerBlock("scorchstone_rune_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).instrument(NoteBlockInstrument.BELL)
                    .requiresCorrectToolForDrops().lightLevel(state -> 5)));
    public static final RegistryObject<Block> VEREDITE_RUNE_BLOCK = registerBlock("veredite_rune_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).instrument(NoteBlockInstrument.BELL)
                    .requiresCorrectToolForDrops().lightLevel(state -> 5)));
    public static final RegistryObject<Block> ECLIPSAL_RUNE_BLOCK = registerBlock("eclipsal_rune_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).instrument(NoteBlockInstrument.BELL)
                    .requiresCorrectToolForDrops().lightLevel(state -> 5)));

    //RESOURCES
    public static final RegistryObject<Block> DUST_BLOCK = registerBlock("dust_block",
            () -> new GravityBlock(BlockBehaviour.Properties.copy(Blocks.SAND)));
    public static final RegistryObject<Block> EXCAVATION_LANTERN = registerBlock("excavation_lantern",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)
                    .instrument(NoteBlockInstrument.CHIME).sound(SoundType.CHAIN).lightLevel(state -> 12)));
    public static final RegistryObject<Block> DUST_BRICKS = registerBlock("dust_bricks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHISELED_DUST_BRICKS = registerBlock("chiseled_dust_bricks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops()));

    //Wood
    public static final RegistryObject<Block> MAHOGANY_LOG = registerBlock("mahogany_log",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> MAHOGANY_WOOD = registerBlock("mahogany_wood",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MAHOGANY_LOG = registerBlock("stripped_mahogany_log",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MAHOGANY_WOOD = registerBlock("stripped_mahogany_wood",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> MAHOGANY_PLANKS = registerBlock("mahogany_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> MAHOGANY_LEAVES = registerBlock("mahogany_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> MAHOGANY_SAPLING = registerBlock("mahogany_sapling",
            ()-> new SaplingBlock(new MahoganyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.DARK_OAK_SAPLING)));

    public static final RegistryObject<Block> MAHOGANY_STAIRS = registerBlock("mahogany_stairs",
            ()-> new StairBlock(() -> ModBlocks.MAHOGANY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BIRCH_STAIRS)));
    public static final RegistryObject<Block> MAHOGANY_SLAB = registerBlock("mahogany_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_SLAB)));
    public static final RegistryObject<Block> MAHOGANY_PRESSURE_PLATE = registerBlock("mahogany_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.BIRCH_STAIRS).sound(SoundType.METAL), BlockSetType.BIRCH));
    public static final RegistryObject<Block> MAHOGANY_BUTTON = registerBlock("mahogany_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE_SLAB).sound(SoundType.METAL), BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> MAHOGANY_FENCE = registerBlock("mahogany_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> MAHOGANY_FENCE_GATE = registerBlock("mahogany_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> MAHOGANY_DOOR = registerBlock("mahogany_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_DOOR), BlockSetType.BIRCH));
    public static final RegistryObject<Block> MAHOGANY_TRAPDOOR = registerBlock("mahogany_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR), BlockSetType.BIRCH));

    public static final RegistryObject<Block> WILTFLOWER = registerBlock("wiltflower",
            () -> new FlowerBlock(()->MobEffects.DIG_SLOWDOWN, 4, BlockBehaviour.Properties.copy(Blocks.SUNFLOWER)));
    public static final RegistryObject<Block> POTTED_WILTFLOWER = BLOCKS.register("potted_wiltflower",
            () -> new FlowerPotBlock((()->(FlowerPotBlock) Blocks.FLOWER_POT), WILTFLOWER, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)));

    //CUSTOM
    public static final RegistryObject<Block> SIFTER = registerBlock("sifter",
            ()-> new SifterBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> PAPYRUS_CROP = registerBlock("papyrus_crop",
            ()-> new PapyrusCropBlock(BlockBehaviour.Properties.copy(Blocks.SMALL_DRIPLEAF)));


    //DUST BRICK SET
    public static final RegistryObject<Block> DUST_BRICK_STAIRS = registerBlock("dust_brick_stairs",
            ()-> new StairBlock(() -> ModBlocks.DUST_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DUST_BRICK_SLAB = registerBlock("dust_brick_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DUST_BRICK_PRESSURE_PLATE = registerBlock("dust_brick_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE).requiresCorrectToolForDrops().sound(SoundType.STONE), BlockSetType.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> DUST_BRICK_BUTTON = registerBlock("dust_brick_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BUTTON).requiresCorrectToolForDrops().sound(SoundType.STONE), BlockSetType.POLISHED_BLACKSTONE, 10, true));
    public static final RegistryObject<Block> DUST_BRICK_WALL = registerBlock("dust_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICK_WALL).requiresCorrectToolForDrops()));


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
