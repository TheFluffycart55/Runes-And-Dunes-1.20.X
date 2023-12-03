package net.thefluffycart.dunes_mod.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.RecordItem;
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
    public static final RegistryObject<Item> SHATTERED_RELIC_TEMPLATE= ITEMS.register("shattered_relic_template",
        () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SHATTERED_WEAPON= ITEMS.register("shattered_weapon",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> RELIC_TEMPLATE= ITEMS.register("relic_template",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> WEAPON_TEMPLATE= ITEMS.register("weapon_template",
            () -> new Item(new Item.Properties().stacksTo(64)));

//RESOURCES
    public static final RegistryObject<Item> DUST = ITEMS.register("dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_BONE_MARROW = ITEMS.register("raw_bone_marrow",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BONE_MARROW_INGOT = ITEMS.register("bone_marrow_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUSTY_ARTIFACT = ITEMS.register("dusty_artifact",
            () -> new Item(new Item.Properties().craftRemainder(ModItems.DUST.get())));
    public static final RegistryObject<Item> SANDY_ARTIFACT = ITEMS.register("sandy_artifact",
            () -> new Item(new Item.Properties().craftRemainder(Items.SAND)));
    public static final RegistryObject<Item> MEERKAT_SPAWN_EGG = ITEMS.register("meerkat_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MEERKAT, 0xe0b679, 0x453c30,new Item.Properties()));
    public static final RegistryObject<Item> PAPYRUS = ITEMS.register("papyrus",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PAPYRUS_CULM = ITEMS.register("papyrus_culm",
            () -> new ItemNameBlockItem(ModBlocks.PAPYRUS_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> WHAMMAGEDDON_MUSIC_DISC = ITEMS.register("whammageddon_music_disc",
            () -> new RecordItem(15, ModSounds.WHAMMAGEDDON_MUSIC_DISC,  new Item.Properties().stacksTo(1), 5060));
    public static final RegistryObject<Item> JNANA_AND_VIDYA_MUSIC_DISC = ITEMS.register("jnana_and_vidya_music_disc",
            () -> new RecordItem(3, ModSounds.JNANA_AND_VIDYA_MUSIC_DISC,  new Item.Properties().stacksTo(1), 5060));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
