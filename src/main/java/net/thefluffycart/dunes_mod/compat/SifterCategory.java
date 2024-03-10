package net.thefluffycart.dunes_mod.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.recipe.SiftingRecipe;

public class SifterCategory implements IRecipeCategory<SiftingRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(RunesAndDunesMod.MOD_ID, "sifting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(RunesAndDunesMod.MOD_ID, "textures/gui/sifter_gui.png");

    public static final RecipeType<SiftingRecipe> SIFTING_TYPE =
            new RecipeType<>(UID, SiftingRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public SifterCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0 , 0, 175, 76);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SIFTER.get()));
    }

    @Override
    public RecipeType<SiftingRecipe> getRecipeType() {
        return SIFTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Sifter");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SiftingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 30).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 30).addItemStack(recipe.getResultItem(null));
    }
}
