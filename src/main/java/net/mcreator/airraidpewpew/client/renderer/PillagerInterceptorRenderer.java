package net.mcreator.airraidpewpew.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.airraidpewpew.entity.PillagerInterceptorEntity;
import net.mcreator.airraidpewpew.client.model.animations.pillagerinterceptorAnimation;
import net.mcreator.airraidpewpew.client.model.Modelpillagerinterceptor;

public class PillagerInterceptorRenderer extends MobRenderer<PillagerInterceptorEntity, Modelpillagerinterceptor<PillagerInterceptorEntity>> {
	public PillagerInterceptorRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelpillagerinterceptor.LAYER_LOCATION)), 0.8f);
	}

	@Override
	public ResourceLocation getTextureLocation(PillagerInterceptorEntity entity) {
		return new ResourceLocation("airraidpewpew:textures/entities/pillagerinterceptor.png");
	}

	private static final class AnimatedModel extends Modelpillagerinterceptor<PillagerInterceptorEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<PillagerInterceptorEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(PillagerInterceptorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, pillagerinterceptorAnimation.animation_pillagerinterceptor, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(PillagerInterceptorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}