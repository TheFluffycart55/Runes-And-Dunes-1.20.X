package net.thefluffycart.dunes_mod.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RunesAndDunesMod.MOD_ID);

    public static final RegistryObject<Item> SCORCHSTONE_GEM= ITEMS.register("scorchstone_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VEREDITE_GEM = ITEMS.register("veredite_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ECLIPSAL_GEM = ITEMS.register("eclipsal_gem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DUST = ITEMS.register("dust",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
