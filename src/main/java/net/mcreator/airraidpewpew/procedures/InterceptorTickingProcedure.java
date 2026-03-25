package net.mcreator.airraidpewpew.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.airraidpewpew.AirraidpewpewMod;

public class InterceptorTickingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) != null) {
			if (entity.getPersistentData().getDouble("OperationDelay") <= 0) {
				entity.getPersistentData().putBoolean("CanOperate", true);
				if (entity instanceof Mob _entity)
					_entity.getNavigation().stop();
				entity.getPersistentData().putDouble("OperationDelay", 40);
				entity.getPersistentData().putDouble("OperationMode", (Mth.nextInt(RandomSource.create(), 0, 3)));
				AirraidpewpewMod.LOGGER.info("Reset OperationMode, Generate Random number");
			}
			if (entity.getPersistentData().getDouble("OperationMode") == 0) {
				if (entity.getPersistentData().getDouble("OperationDelay") >= 40) {
					entity.getPersistentData().putBoolean("CanOperate", false);
					AirraidpewpewMod.LOGGER.info("Set Mode 0");
				}
				entity.getPersistentData().putDouble("OperationDelay", (entity.getPersistentData().getDouble("OperationDelay") - 1));
			}
			if (entity.getPersistentData().getDouble("OperationMode") == 1) {
				if (entity.getPersistentData().getDouble("OperationDelay") >= 40) {
					entity.getPersistentData().putBoolean("CanOperate", false);
					AirraidpewpewMod.LOGGER.info("Set Mode 1");
				}
				entity.setDeltaMovement(new Vec3(((-1) * entity.getLookAngle().z * 0.15), (entity.getDeltaMovement().y()), (1 * entity.getLookAngle().x * 0.15)));
				entity.getPersistentData().putDouble("OperationDelay", (entity.getPersistentData().getDouble("OperationDelay") - 1));
			}
			if (entity.getPersistentData().getDouble("OperationMode") == 2) {
				if (entity.getPersistentData().getDouble("OperationDelay") >= 40) {
					entity.getPersistentData().putBoolean("CanOperate", false);
					AirraidpewpewMod.LOGGER.info("Set Mode 2");
				}
				entity.setDeltaMovement(new Vec3((1 * entity.getLookAngle().z * 0.15), (entity.getDeltaMovement().y()), ((-1) * entity.getLookAngle().x * 0.15)));
				entity.getPersistentData().putDouble("OperationDelay", (entity.getPersistentData().getDouble("OperationDelay") - 1));
			}
			if (entity.getPersistentData().getDouble("OperationMode") == 3) {
				if (entity.getPersistentData().getDouble("OperationDelay") >= 40) {
					entity.getPersistentData().putBoolean("CanOperate", false);
					AirraidpewpewMod.LOGGER.info("Set Mode 3");
				}
				entity.setDeltaMovement(new Vec3(((-1) * entity.getLookAngle().x * 0.2), (entity.getDeltaMovement().y()), ((-1) * entity.getLookAngle().z * 0.2)));
				entity.getPersistentData().putDouble("OperationDelay", (entity.getPersistentData().getDouble("OperationDelay") - 1));
			}
		}
	}
}