package net.thefluffycart.dunes_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.thefluffycart.dunes_mod.entity.animations.ModAnimationDefinitions;
import net.thefluffycart.dunes_mod.entity.custom.MeerkatEntity;

public class MeerkatModel<T extends MeerkatEntity> extends HierarchicalModel<T> {

	private final ModelPart Meerkat;
	private final ModelPart head;

	public MeerkatModel(ModelPart root) {
		this.Meerkat = root.getChild("meerkat");
		this.head = Meerkat.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition meerkat = partdefinition.addOrReplaceChild("meerkat", CubeListBuilder.create(), PartPose.offset(1.0F, 24.0F, -1.0F));

		PartDefinition head = meerkat.addOrReplaceChild("head", CubeListBuilder.create().texOffs(11, 9).addBox(-2.5F, -4.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(25, 0).addBox(-1.5F, -2.0F, -4.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -12.0F, 1.0F));

		PartDefinition ear_left = head.addOrReplaceChild("ear_left", CubeListBuilder.create().texOffs(12, 0).addBox(0.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -2.0F, 1.0F));

		PartDefinition ear_right = head.addOrReplaceChild("ear_right", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -2.0F, 1.0F));

		PartDefinition body = meerkat.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -5.0F, -1.5F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -7.0F, 0.5F));

		PartDefinition arm_left = meerkat.addOrReplaceChild("arm_left", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 1.0F));

		PartDefinition cube_r1 = arm_left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 20).addBox(0.5F, -2.5F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.5F, -0.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition arm_right = meerkat.addOrReplaceChild("arm_right", CubeListBuilder.create(), PartPose.offset(-2.0F, -10.0F, 1.0F));

		PartDefinition cube_r2 = arm_right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 18).addBox(-0.5F, -2.5F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 1.5F, -0.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition foot_left = meerkat.addOrReplaceChild("foot_left", CubeListBuilder.create().texOffs(5, 24).addBox(0.0F, 0.0F, -1.5F, 1.0F, 4.0F, 2.5F, new CubeDeformation(0.0F))
				.texOffs(16, 0).addBox(-1.0F, 4.0F, -3.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -5.0F, 1.5F));

		PartDefinition foot_right = meerkat.addOrReplaceChild("foot_right", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, 4.0F, -3.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(20, 18).addBox(-1.0F, 0.0F, -1.5F, 1.0F, 4.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -5.0F, 1.5F));

		PartDefinition tail = meerkat.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(-1.0F, -5.5F, 3.0F));

		PartDefinition cube_r3 = tail.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(13, 25).addBox(0.0F, -2.5F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, 1.5F, -0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 36, 36);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.MEERKAT_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationDefinitions.MEERKAT_IDLE, ageInTicks, 1f);
		this.animate(entity.sitAnimationState, ModAnimationDefinitions.MEERKAT_SIT, ageInTicks, 1f);
	}


	private void applyHeadRotation(MeerkatEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float) Math.PI / 180F);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Meerkat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Meerkat;
	}
}