package net.thefluffycart.dunes_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.entity.custom.MeerkatEntity;
import net.thefluffycart.dunes_mod.entity.layers.ModModelLayers;

public class MeerkatRenderer extends MobRenderer<MeerkatEntity, MeerkatModel<MeerkatEntity>> {

    private static final ResourceLocation MEERKAT_LOCATION =
            new ResourceLocation(RunesAndDunesMod.MOD_ID, "textures/entity/meerkat.png");

    public MeerkatRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MeerkatModel<>(pContext.bakeLayer(ModModelLayers.MEERKAT_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(MeerkatEntity pEntity) {
        return MEERKAT_LOCATION;
    }

    @Override
    public void render(MeerkatEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.75f, 0.75f, 0.75f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
