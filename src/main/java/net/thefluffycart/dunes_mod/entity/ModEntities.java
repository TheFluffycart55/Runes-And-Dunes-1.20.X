package net.thefluffycart.dunes_mod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.entity.custom.DustProjectileEntity;
import net.thefluffycart.dunes_mod.entity.custom.LeglessEntity;
import net.thefluffycart.dunes_mod.entity.custom.MeerkatEntity;
import net.thefluffycart.dunes_mod.entity.custom.RedPandaEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RunesAndDunesMod.MOD_ID);

    public static final RegistryObject<EntityType<MeerkatEntity>> MEERKAT =
            ENTITY_TYPES.register("meerkat",()-> EntityType.Builder.of(MeerkatEntity::new, MobCategory.CREATURE)
                    .sized(0.5f,1f).build("meerkat"));

    public static final RegistryObject<EntityType<RedPandaEntity>> RED_PANDA =
            ENTITY_TYPES.register("red_panda",()-> EntityType.Builder.of(RedPandaEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,.8f).build("red_panda"));

    //public static final RegistryObject<EntityType<FireflyEntity>> FIREFLY =
           // ENTITY_TYPES.register("firefly",()-> EntityType.Builder.of(FireflyEntity::new, MobCategory.AMBIENT)
                  //  .sized(0.5f,1f).build("firefly"));

    public static final RegistryObject<EntityType<LeglessEntity>> LEGLESS =
            ENTITY_TYPES.register("legless",()-> EntityType.Builder.of(LeglessEntity::new, MobCategory.MONSTER)
                    .sized(0.9f,0.8f).build("legless"));

    public static final RegistryObject<EntityType<DustProjectileEntity>> DUST_PROJECTILE =
            ENTITY_TYPES.register("dust_projectile",
                    ()-> EntityType.Builder.<DustProjectileEntity>of(DustProjectileEntity::new, MobCategory.MISC)
                            .sized(0.4f, 0.4f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("dust_projectile"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
