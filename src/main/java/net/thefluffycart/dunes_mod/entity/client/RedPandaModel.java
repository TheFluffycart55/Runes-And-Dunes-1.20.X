package net.thefluffycart.dunes_mod.entity.client;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.thefluffycart.dunes_mod.entity.custom.RedPandaEntity;

public class RedPandaModel<T extends RedPandaEntity> extends HierarchicalModel<T> {

	private final ModelPart RedPanda;
	private final ModelPart head;

	public RedPandaModel(ModelPart root) {
		this.RedPanda = root.getChild("red_panda_root");
		this.head = RedPanda.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition red_panda_root = partdefinition.addOrReplaceChild("red_panda_root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = red_panda_root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -11.0F, -11.5F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(36, 22).addBox(-1.5F, -7.0F, -13.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create().texOffs(29, 24).addBox(2.0F, -13.0F, -10.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 0).addBox(-4.0F, -13.0F, -10.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = red_panda_root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-3.0F, -5.5F, -3.0F, 6.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition legs = red_panda_root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg_l1 = legs.addOrReplaceChild("leg_l1", CubeListBuilder.create().texOffs(25, 14).addBox(0.0F, -5.0F, -4.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, -0.5F));

		PartDefinition leg_l2 = legs.addOrReplaceChild("leg_l2", CubeListBuilder.create().texOffs(0, 31).addBox(1.0F, -5.0F, 2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg_r1 = legs.addOrReplaceChild("leg_r1", CubeListBuilder.create().texOffs(26, 28).addBox(-4.0F, -5.0F, -5.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg_rdr2 = legs.addOrReplaceChild("leg_rdr2", CubeListBuilder.create().texOffs(13, 31).addBox(-4.0F, -5.0F, 2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = red_panda_root.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(25, 0).addBox(-2.0F, -4.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.0F, -1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RedPanda.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return null;
	}
}