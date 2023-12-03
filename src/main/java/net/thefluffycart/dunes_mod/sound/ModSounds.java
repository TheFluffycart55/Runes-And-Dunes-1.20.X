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

    public static final RegistryObject<SoundEvent> JNANA_AND_VIDYA_MUSIC_DISC = registerSoundEvents("jnana_and_vidya_music_disc");

    public static final RegistryObject<SoundEvent> WHAMMAGEDDON_MUSIC_DISC = registerSoundEvents("whammageddon_music_disc");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name)
    {
        ResourceLocation id = new ResourceLocation(RunesAndDunesMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
