// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelpillagerinterceptor<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "pillagerinterceptor"), "main");
	private final ModelPart main;
	private final ModelPart wing;
	private final ModelPart body;
	private final ModelPart gun;
	private final ModelPart pillager;
	private final ModelPart head;
	private final ModelPart blade;

	public Modelpillagerinterceptor(ModelPart root) {
		this.main = root.getChild("main");
		this.wing = this.main.getChild("wing");
		this.body = this.main.getChild("body");
		this.gun = this.main.getChild("gun");
		this.pillager = this.main.getChild("pillager");
		this.head = this.pillager.getChild("head");
		this.blade = this.main.getChild("blade");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(),
				PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition wing = main.addOrReplaceChild("wing",
				CubeListBuilder.create().texOffs(0, 58).mirror()
						.addBox(8.0F, -8.0F, 3.0F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(0, 58).addBox(-16.0F, -8.0F, 3.0F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition body = main.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(32, 1)
						.addBox(-8.0F, -24.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(80, 1)
						.addBox(-6.0F, -16.0F, 8.0F, 12.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(86, 1)
						.addBox(4.0F, -21.0F, 10.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(86, 1)
						.addBox(-4.0F, -21.0F, 10.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(44, 38)
						.addBox(-1.0F, -8.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition gun = main.addOrReplaceChild("gun",
				CubeListBuilder.create().texOffs(44, 34)
						.addBox(-2.0F, -22.0F, -15.0F, 4.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(45, 34)
						.addBox(-2.0F, -30.0F, -13.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition pillager = main.addOrReplaceChild("pillager", CubeListBuilder.create().texOffs(0, 18).addBox(
				-4.0F, -24.0F, -3.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 3.0F));

		PartDefinition cube_r1 = pillager.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(32, 0).mirror()
						.addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.0F, -22.0F, 0.0F, -1.024F, 0.6219F, 0.3408F));

		PartDefinition cube_r2 = pillager.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, -22.0F, 0.0F, -0.9804F, -0.6219F, -0.3408F));

		PartDefinition head = pillager.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(24, 0)
						.addBox(-1.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition blade = main.addOrReplaceChild("blade", CubeListBuilder.create().texOffs(-22, 36).addBox(-11.0F,
				2.0F, -11.0F, 22.0F, 0.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.gun.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.main.xRot = headPitch / (180F / (float) Math.PI);
	}
}