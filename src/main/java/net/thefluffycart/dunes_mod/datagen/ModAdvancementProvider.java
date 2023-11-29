package net.thefluffycart.dunes_mod.datagen;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.items.ModItems;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    //public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
    //   Advancement artifactFound = Advancement.Builder.advancement()
    //   .display(new DisplayInfo(new ItemStack(ModItems.DUSTY_ARTIFACT.get()),
    //     Component.literal("Professional Grave Robber"), Component.literal("When is it Archaeology, instead of Grave Robbing"),
    //       new ResourceLocation(RunesAndDunesMod.MOD_ID, "textures/item/dusty_artifact.png"), FrameType.TASK,
    //       true, true, false))
    //  .addCriterion("has_artifact", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DUSTY_ARTIFACT.get(), ModItems.SANDY_ARTIFACT.get()))
    //   .save(saver, new ResourceLocation(RunesAndDunesMod.MOD_ID, "artifact_get"), existingFileHelper);

    // Advancement gemstoneGet = Advancement.Builder.advancement()
    //     .display(new DisplayInfo(new ItemStack(ModItems.DUSTY_ARTIFACT.get()),
    //            Component.literal("I'm So Shiny!"), Component.literal("Keep these gems away from crabs"),
    //             null, FrameType.TASK,
    //            true, true, false))
    //  .parent(artifactFound)
    // .addCriterion("has_gem", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SCORCHSTONE_GEM.get(), ModItems.VEREDITE_GEM.get(), ModItems.ECLIPSAL_GEM.get()))
    //      .save(saver, new ResourceLocation(RunesAndDunesMod.MOD_ID, "gem_get"), existingFileHelper);
    //}

    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.DUSTY_ARTIFACT.get()),
                        Component.literal("Grave Robber"), Component.literal("When is it truly Archaeology, instead of Grave Robbing?"),
                        new ResourceLocation(RunesAndDunesMod.MOD_ID, "textures/block/windswept_sand.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_artifacts", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DUSTY_ARTIFACT.get(), ModItems.SANDY_ARTIFACT.get()))
                .save(saver, new ResourceLocation(RunesAndDunesMod.MOD_ID, "mccourse"), existingFileHelper);


        Advancement metalDetector = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.ECLIPSAL_GEM.get()),
                        Component.literal("Metal Detector"), Component.literal("Batteries not included! (Actually doesn't need batteries)"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_metal_detector", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ECLIPSAL_GEM.get()))
                .save(saver, new ResourceLocation(RunesAndDunesMod.MOD_ID, "metal_detector"), existingFileHelper);
    }
}
