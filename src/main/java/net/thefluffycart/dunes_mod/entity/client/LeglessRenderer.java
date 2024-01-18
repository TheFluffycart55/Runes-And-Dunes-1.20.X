package net.thefluffycart.dunes_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.entity.custom.LeglessEntity;
import net.thefluffycart.dunes_mod.entity.custom.LeglessEntity;
import net.thefluffycart.dunes_mod.entity.layers.ModModelLayers;

public class LeglessRenderer extends MobRenderer<LeglessEntity, LeglessModel<LeglessEntity>> {

    private static final ResourceLocation LEGLESS_LOCATION =
            new ResourceLocation(RunesAndDunesMod.MOD_ID, "textures/entity/legless.png");

    public LeglessRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LeglessModel<>(pContext.bakeLayer(ModModelLayers.LEGLESS_LAYER)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(LeglessEntity pEntity) {
        return LEGLESS_LOCATION;
    }

    @Override
    public void render(LeglessEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.75f, 0.75f, 0.75f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
