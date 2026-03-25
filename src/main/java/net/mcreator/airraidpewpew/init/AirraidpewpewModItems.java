/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.airraidpewpew.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.airraidpewpew.AirraidpewpewMod;

public class AirraidpewpewModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AirraidpewpewMod.MODID);
	public static final RegistryObject<Item> PILLAGER_INTERCEPTOR_SPAWN_EGG;
	static {
		PILLAGER_INTERCEPTOR_SPAWN_EGG = REGISTRY.register("pillager_interceptor_spawn_egg", () -> new ForgeSpawnEggItem(AirraidpewpewModEntities.PILLAGER_INTERCEPTOR, -14479340, -8364490, new Item.Properties()));
	}
	// Start of user code block custom items
	// End of user code block custom items
}