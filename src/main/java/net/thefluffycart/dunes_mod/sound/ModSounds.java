package net.thefluffycart.dunes_mod.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RunesAndDunesMod.MOD_ID);

    public static final RegistryObject<SoundEvent> MEERKAT_IDLE = registerSoundEvents("meerkat_idle");

    public static final RegistryObject<SoundEvent> MEERKAT_HURT = registerSoundEvents("meerkat_hurt");

    public static final RegistryObject<SoundEvent> LEGLESS_MOAN = registerSoundEvents("legless_moan");

    public static final RegistryObject<SoundEvent> LEGLESS_HURT = registerSoundEvents("legless_hurt");

    public static final RegistryObject<SoundEvent> LEGLESS_DEATH = registerSoundEvents("legless_death");

    public static final RegistryObject<SoundEvent> DUST_THROW = registerSoundEvents("dust_throw");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name)
    {
        ResourceLocation id = new ResourceLocation(RunesAndDunesMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
