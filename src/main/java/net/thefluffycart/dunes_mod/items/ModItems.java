package net.thefluffycart.dunes_mod.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.entity.ModEntities;
import net.thefluffycart.dunes_mod.items.custom.EclipsalRelicItem;
import net.thefluffycart.dunes_mod.items.custom.ScorchstoneRelicItem;
import net.thefluffycart.dunes_mod.items.custom.VerediteRelicItem;

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

//SHATTERED BLUEPRINTS
    public static final RegistryObject<Item> SHATTERED_RELIC= ITEMS.register("shattered_relic",
        () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SHATTERED_WEAPON= ITEMS.register("shattered_weapon",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RELIC_TEMPLATE= ITEMS.register("relic_template",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WEAPON_TEMPLATE= ITEMS.register("weapon_template",
            () -> new Item(new Item.Properties().stacksTo(1)));

//RESOURCES
    public static final RegistryObject<Item> DUST = ITEMS.register("dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_BONE_MARROW = ITEMS.register("raw_bone_marrow",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BONE_MARROW_INGOT = ITEMS.register("bone_marrow_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUSTY_ARTIFACT = ITEMS.register("dusty_artifact",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SANDY_ARTIFACT = ITEMS.register("sandy_artifact",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEERKAT_SPAWN_EGG = ITEMS.register("meerkat_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MEERKAT, 0xe0b679, 0x453c30,new Item.Properties()));

//RELICS
    public static final RegistryObject<Item> SCORCHSTONE_RELIC= ITEMS.register("scorchstone_relic",
            () -> new ScorchstoneRelicItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VEREDITE_RELIC= ITEMS.register("veredite_relic",
            () -> new VerediteRelicItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ECLIPSAL_RELIC= ITEMS.register("eclipsal_relic",
            () -> new EclipsalRelicItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
