/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.airraidpewpew.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.airraidpewpew.client.model.Modelpillagerinterceptor;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AirraidpewpewModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelpillagerinterceptor.LAYER_LOCATION, Modelpillagerinterceptor::createBodyLayer);
	}
}