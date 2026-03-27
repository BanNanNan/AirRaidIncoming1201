package net.mcreator.airraidpewpew.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class InterceptorTickingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity Localentitytarget = null;
		double NBTOperationDelay = 0;
		double NBTOperationMode = 0;
		NBTOperationDelay = entity.getPersistentData().getDouble("OperationDelay");
		NBTOperationMode = entity.getPersistentData().getDouble("OperationMode");
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) != null) {
			if (NBTOperationDelay == 0) {
				Localentitytarget = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
				entity.getPersistentData().putDouble("OperationDelay", 40);
				entity.getPersistentData().putDouble("OperationMode", (Mth.nextInt(RandomSource.create(), 0, 4)));
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = initArrowProjectile(createArrowWeaponItemStack(new Arrow(projectileLevel, 0, 0, 0), 1, (byte) 0), entity, 3, false, false, false, AbstractArrow.Pickup.DISALLOWED);
					_entityToSpawn.setPos(x, (1.3 + y), z);
					_entityToSpawn.shoot((Localentitytarget.getX() - x), ((y - Localentitytarget.getY()) * (-0.6)), (Localentitytarget.getZ() - z), (float) ((entity.position()).distanceTo((Localentitytarget.position())) * 0.16), 1);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.crossbow.shoot")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				entity.getPersistentData().putDouble("OperationDelay", (NBTOperationDelay - 1));
			}
			if (NBTOperationMode == 1) {
				entity.setDeltaMovement(new Vec3((1 * entity.getLookAngle().x * 0.04), (entity.getDeltaMovement().y()), (1 * entity.getLookAngle().z * 0.06)));
			} else if (NBTOperationMode == 2) {
				entity.setDeltaMovement(new Vec3(((-1) * entity.getLookAngle().z * 0.1), (entity.getDeltaMovement().y()), (1 * entity.getLookAngle().x * 0.11)));
			} else if (NBTOperationMode == 3) {
				entity.setDeltaMovement(new Vec3((1 * entity.getLookAngle().z * 0.11), (entity.getDeltaMovement().y()), ((-1) * entity.getLookAngle().x * 0.1)));
			} else if (NBTOperationMode == 4) {
				entity.setDeltaMovement(new Vec3(((-1) * entity.getLookAngle().x * 0.06), (entity.getDeltaMovement().y()), ((-1) * entity.getLookAngle().z * 0.04)));
			}
		} else {
			entity.getPersistentData().putDouble("OperationDelay", 0);
		}
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.setSecondsOnFire(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}

	private static AbstractArrow createArrowWeaponItemStack(AbstractArrow entityToSpawn, int knockback, byte piercing) {
		if (knockback > 0)
			entityToSpawn.setKnockback(knockback);
		if (piercing > 0)
			entityToSpawn.setPierceLevel(piercing);
		return entityToSpawn;
	}
}