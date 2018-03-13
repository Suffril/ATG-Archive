package com.lcm.doctorwho.events;

import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ATGEventHandler {
	
	@SubscribeEvent
	public void onLivingJumpEvent(LivingEvent.LivingJumpEvent event) {
		// double addY = 1.38D;
		// event.getEntity().motionY *= addY;
		// event.getEntity().velocityChanged = true;
	}
	
	@SubscribeEvent
	public static void blockBreak(PlayerEvent e) {}
}
