package net.thefluffycart.dunes_mod.items;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.entity.ModEntities;
import net.thefluffycart.dunes_mod.items.custom.EclipsalRelicItem;
import net.thefluffycart.dunes_mod.items.custom.ScorchstoneRelicItem;
import net.thefluffycart.dunes_mod.items.custom.VerediteRelicItem;
import net.thefluffycart.dunes_mod.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RunesAndDunesMod.MOD_ID);
//GEMS
    public static final RegistryObject<Item> SCORCHSTONE_GEM= ITEMS.register("scorchstone_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VEREDITE_GEM = ITEMS.register("veredite_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ECLIPSAL_GEM = ITEMS.register("eclipsal_gem",
            () -> new Item(new Item.Properties()));

//RELICS
    public static final RegistryObject<Item> SCORCHSTONE_RELIC= ITEMS.register("scorchstone_relic",
            () -> new ScorchstoneRelicItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VEREDITE_RELIC= ITEMS.register("veredite_relic",
            () -> new VerediteRelicItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ECLIPSAL_RELIC= ITEMS.register("eclipsal_relic",
            () -> new EclipsalRelicItem(new Item.Properties().stacksTo(1)));

//SHATTERED BLUEPRINTS
    public static final RegistryObject<Item> SHATTERED_TABLET= ITEMS.register("shattered_tablet",
        () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SCORCHSTONE_RUNE= ITEMS.register("scorchstone_rune",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> VEREDITE_RUNE= ITEMS.register("veredite_rune",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> ECLIPSAL_RUNE= ITEMS.register("eclipsal_rune",
            () -> new Item(new Item.Properties().stacksTo(16)));

//RESOURCES
    public static final RegistryObject<Item> DUST = ITEMS.register("dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SANDY_TABLET = ITEMS.register("sandy_tablet",
            () -> new Item(new Item.Properties().craftRemainder(Items.SAND)));
    public static final RegistryObject<Item> MEERKAT_SPAWN_EGG = ITEMS.register("meerkat_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MEERKAT, 0x9c8a6e, 0xebbc73,new Item.Properties()));
    public static final RegistryObject<Item> LEGLESS_SPAWN_EGG = ITEMS.register("legless_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.LEGLESS, 0x47453d, 0xffd000,new Item.Properties()));
    public static final RegistryObject<Item> RED_PANDA_SPAWN_EGG = ITEMS.register("red_panda_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RED_PANDA, 0xd47400, 0x2b1c05,new Item.Properties()));
    public static final RegistryObject<Item> PAPYRUS = ITEMS.register("papyrus",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PAPYRUS_CULM = ITEMS.register("papyrus_culm",
            () -> new ItemNameBlockItem(ModBlocks.PAPYRUS_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
