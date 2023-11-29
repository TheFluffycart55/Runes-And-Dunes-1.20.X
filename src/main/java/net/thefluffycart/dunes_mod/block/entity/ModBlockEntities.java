package net.thefluffycart.dunes_mod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RunesAndDunesMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<SifterEntity>> SIFTER_ENTITY_BE =
            BLOCK_ENTITIES.register("sifter_block_entity", ()->
                    BlockEntityType.Builder.of(SifterEntity::new,
                            ModBlocks.SIFTER.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
