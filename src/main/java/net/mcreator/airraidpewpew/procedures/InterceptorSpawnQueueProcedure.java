package net.mcreator.airraidpewpew.procedures;

import net.minecraft.world.entity.Entity;

public class InterceptorSpawnQueueProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("OperationMode", 0);
		entity.getPersistentData().putDouble("OperationDelay", 40);
		entity.getPersistentData().putBoolean("CanOperate", true);
	}
}