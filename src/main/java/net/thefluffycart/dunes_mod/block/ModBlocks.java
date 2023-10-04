package net.thefluffycart.dunes_mod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.items.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RunesAndDunesMod.MOD_ID);
    //Gem blocks, fuck you
    public static final RegistryObject<Block> SCORCHSTONE_BLOCK = registerBlock("scorchstone_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).instrument(NoteBlockInstrument.BELL)));
    public static final RegistryObject<Block> VEREDITE_BLOCK = registerBlock("veredite_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).instrument(NoteBlockInstrument.BELL)));

    public static final RegistryObject<Block> DUST_BLOCK = registerBlock("dust_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.GRAVEL).instrument(NoteBlockInstrument.DIDGERIDOO)));
    public static final RegistryObject<Block> WINDSWEPT_SAND = registerBlock("windswept_sand",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> BONE_MARROW_ORE = registerBlock("bone_marrow_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));
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
