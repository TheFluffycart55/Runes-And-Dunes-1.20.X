package net.thefluffycart.dunes_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.thefluffycart.dunes_mod.RunesAndDunesMod;
import net.thefluffycart.dunes_mod.entity.custom.RedPandaEntity;
import net.thefluffycart.dunes_mod.entity.layers.ModModelLayers;

public class RedPandaRenderer extends MobRenderer<RedPandaEntity, RedPandaModel<RedPandaEntity>> {

    private static final ResourceLocation RED_PANDA_LOCATION =
            new ResourceLocation(RunesAndDunesMod.MOD_ID, "textures/entity/red_panda.png");

    public RedPandaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RedPandaModel<>(pContext.bakeLayer(ModModelLayers.RED_PANDA_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(RedPandaEntity pEntity) {
        return RED_PANDA_LOCATION;
    }

    @Override
    public void render(RedPandaEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.75f, 0.75f, 0.75f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
