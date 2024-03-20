package net.thefluffycart.dunes_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.entity.custom.DustProjectileEntity;
import net.thefluffycart.dunes_mod.entity.layers.ModModelLayers;

public class DustProjectileRenderer extends EntityRenderer<DustProjectileEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(RunesAndDunesMod.MOD_ID, "textures/entity/dust_projectile.png");
    protected DustProjectileModel model;

    public DustProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new DustProjectileModel(pContext.bakeLayer(ModModelLayers.DUST_PROJECTILE_LAYER));
        this.shadowRadius = 0.5f;
    }

    public void render(DustProjectileEntity entity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, entity.yRotO, entity.getYRot()) + 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, entity.xRotO, entity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(entity)), false, false);

        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        pPoseStack.popPose();
        super.render(entity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(DustProjectileEntity pEntity) {
        return TEXTURE;
    }
}
