package net.thefluffycart.dunes_mod.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.recipe.SiftingRecipe;
import net.thefluffycart.dunes_mod.screen.SifterScreen;

import java.util.List;

@JeiPlugin
public class JEIDunesModPlugin implements IModPlugin {


    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(RunesAndDunesMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SifterCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<SiftingRecipe> siftingRecipes = recipeManager.getAllRecipesFor(SiftingRecipe.Type.INSTANCE);
        registration.addRecipes(SifterCategory.SIFTING_TYPE, siftingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(SifterScreen.class, 62, 27, 52, 22,
                SifterCategory.SIFTING_TYPE);
    }
}
