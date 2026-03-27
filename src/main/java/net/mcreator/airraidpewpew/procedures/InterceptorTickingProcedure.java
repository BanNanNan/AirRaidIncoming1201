package net.mcreator.airraidpewpew.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class InterceptorTickingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Entity Localentitytarget = null;
		double NBTOperationDelay = 0;
		double NBTOperationMode = 0;
		NBTOperationDelay = entity.getPersistentData().getDouble("OperationDelay");
		NBTOperationMode = entity.getPersistentData().getDouble("OperationMode");
		Localentitytarget = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
		if (Localentitytarget != null) {
			if (NBTOperationDelay <= 0) {
				entity.getPersistentData().putDouble("OperationDelay", 30);
				entity.getPersistentData().putDouble("OperationMode", (Mth.nextInt(RandomSource.create(), 0, 4)));
			} else {
				entity.getPersistentData().putDouble("OperationDelay", (NBTOperationDelay - 1));
			}
			if (NBTOperationMode == 0) {
				entity.setDeltaMovement(new Vec3((1 * entity.getLookAngle().x * 0.04), (entity.getDeltaMovement().y()), (1 * entity.getLookAngle().z * 0.06)));
			}
			if (NBTOperationMode == 1) {
				entity.setDeltaMovement(new Vec3(((-1) * entity.getLookAngle().z * 0.1), (entity.getDeltaMovement().y()), (1 * entity.getLookAngle().x * 0.11)));
			}
			if (NBTOperationMode == 2) {
				entity.setDeltaMovement(new Vec3((1 * entity.getLookAngle().z * 0.11), (entity.getDeltaMovement().y()), ((-1) * entity.getLookAngle().x * 0.1)));
			}
			if (NBTOperationMode == 3) {
				entity.setDeltaMovement(new Vec3(((-1) * entity.getLookAngle().x * 0.06), (entity.getDeltaMovement().y()), ((-1) * entity.getLookAngle().z * 0.04)));
			}
		}
	}
}