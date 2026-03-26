package net.mcreator.airraidpewpew.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.commands.arguments.EntityAnchorArgument;

public class InterceptorTickingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) != null) {
			if (entity.getPersistentData().getDouble("OperationDelay") <= 0) {
				entity.getPersistentData().putDouble("OperationDelay", 35);
				entity.getPersistentData().putDouble("OperationMode", (Mth.nextInt(RandomSource.create(), 0, 3)));
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			}
			if (entity.getPersistentData().getDouble("OperationMode") == 0) {
				entity.setDeltaMovement(new Vec3((1 * entity.getLookAngle().x * 0.04), (entity.getDeltaMovement().y()), (1 * entity.getLookAngle().z * 0.06)));
				entity.getPersistentData().putDouble("OperationDelay", (entity.getPersistentData().getDouble("OperationDelay") - 1));
			}
			if (entity.getPersistentData().getDouble("OperationMode") == 1) {
				entity.setDeltaMovement(new Vec3(((-1) * entity.getLookAngle().z * 0.1), (entity.getDeltaMovement().y()), (1 * entity.getLookAngle().x * 0.11)));
				entity.getPersistentData().putDouble("OperationDelay", (entity.getPersistentData().getDouble("OperationDelay") - 1));
			}
			if (entity.getPersistentData().getDouble("OperationMode") == 2) {
				entity.setDeltaMovement(new Vec3((1 * entity.getLookAngle().z * 0.11), (entity.getDeltaMovement().y()), ((-1) * entity.getLookAngle().x * 0.1)));
				entity.getPersistentData().putDouble("OperationDelay", (entity.getPersistentData().getDouble("OperationDelay") - 1));
			}
			if (entity.getPersistentData().getDouble("OperationMode") == 3) {
				entity.setDeltaMovement(new Vec3(((-1) * entity.getLookAngle().x * 0.06), (entity.getDeltaMovement().y()), ((-1) * entity.getLookAngle().z * 0.04)));
			}
			entity.getPersistentData().putDouble("OperationDelay", (entity.getPersistentData().getDouble("OperationDelay") - 1));
		}
	}
}