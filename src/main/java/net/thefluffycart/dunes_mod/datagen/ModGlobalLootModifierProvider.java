package net.thefluffycart.dunes_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.LootTableIdCondition.Builder;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.items.ModItems;
import net.thefluffycart.dunes_mod.loot.AddItemModifier;
import net.thefluffycart.dunes_mod.loot.AddSnifferLootModifier;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, RunesAndDunesMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("seeds_from_sniffing", new AddSnifferLootModifier(new LootItemCondition[] {
                new Builder(new ResourceLocation("gameplay/sniffer_digging")).build(),
                LootItemRandomChanceCondition.randomChance(.50f).build() },
                ModItems.PAPYRUS_CULM.get()));

        add("scorchstone_gem_from_desert_pyramid", new AddItemModifier(new LootItemCondition[] {
                new Builder(new ResourceLocation("chests/desert_pyramid")).build(),
                LootItemRandomChanceCondition.randomChance(0.20f).build() },
                ModItems.SCORCHSTONE_GEM.get()));

        add("veredite_gem_from_jungle_temple", new AddItemModifier(new LootItemCondition[] {
                new Builder(new ResourceLocation("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.30f).build()  },
                ModItems.VEREDITE_GEM.get()));

        add("eclipsal_gem_from_end_city", new AddItemModifier(new LootItemCondition[] {
                new Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build() },
                ModItems.ECLIPSAL_GEM.get()));

    }
}