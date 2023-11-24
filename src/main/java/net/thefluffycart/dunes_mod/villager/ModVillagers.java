package net.thefluffycart.dunes_mod.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;

public class ModVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, RunesAndDunesMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, RunesAndDunesMod.MOD_ID);

    public static final RegistryObject<PoiType> SIFTER_POI = POI_TYPES.register("sifter_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.SIFTER.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> HISTORIAN =
            VILLAGER_PROFESSIONS.register("historian", () -> new VillagerProfession("historian",
                    x -> x.get() == SIFTER_POI.get(), x -> x.get() == SIFTER_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_SHEPHERD));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}