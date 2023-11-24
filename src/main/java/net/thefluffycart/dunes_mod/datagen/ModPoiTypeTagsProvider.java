package net.thefluffycart.dunes_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider {

    public ModPoiTypeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, future, RunesAndDunesMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new ResourceLocation(RunesAndDunesMod.MOD_ID, "sifter_poi"));
    }
}
