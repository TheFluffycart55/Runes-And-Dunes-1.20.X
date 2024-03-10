package net.thefluffycart.dunes_mod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.block.ModBlocks;
import net.thefluffycart.dunes_mod.block.entity.SifterEntity;
import net.thefluffycart.dunes_mod.screen.renderer.FluidTankRenderer;
import net.thefluffycart.dunes_mod.util.MouseUtil;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SifterScreen extends AbstractContainerScreen<SifterMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(RunesAndDunesMod.MOD_ID,"textures/gui/sifter_gui.png");
    private FluidTankRenderer fluidRenderer;

    public SifterScreen(SifterMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelX = 75;

        assignFluidRenderer();
    }

    private void assignFluidRenderer() {
        fluidRenderer = new FluidTankRenderer(12000, true, 12, 47);
    }

    @Override
    protected void renderLabels(GuiGraphics GuiGraphics, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) /2;
        int y = (height - imageHeight) /2;

        renderFluidTooltipArea(GuiGraphics, pMouseX, pMouseY, x, y, menu.blockEntity.getFluid(), 12, 9, fluidRenderer);
    }

    private void renderFluidTooltipArea(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y,
                                        FluidStack stack, int offsetX, int offsetY, FluidTankRenderer renderer) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, offsetX, offsetY, renderer)) {
            guiGraphics.renderTooltip(this.font, renderer.getTooltip(stack, TooltipFlag.Default.NORMAL),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) /2;
        int y = (height - imageHeight) /2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
        fluidRenderer.render(guiGraphics, x + 12, y + 9, menu.blockEntity.getFluid());
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 62, y + 34, 17, 167, menu.getScaledProgress(), 9);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidTankRenderer renderer) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }
}
