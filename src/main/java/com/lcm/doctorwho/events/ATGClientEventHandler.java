package com.lcm.doctorwho.events;

import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageAngelSeen;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Nictogen on 2/19/18
 */
//@Mod.EventBusSubscriber(Side.CLIENT) //*physical* client XXX detected some weird behavior, registering manually for now
public class ATGClientEventHandler {
	
	@SubscribeEvent
	public void angelRender(RenderLivingEvent.Post<EntityWeepingAngel> e) {
		EntityLivingBase entity = e.getEntity();
		if (entity instanceof EntityWeepingAngel) {
			EntityWeepingAngel angel = (EntityWeepingAngel) entity;
			if(!angel.isSeen()) {
				ATGNetwork.INSTANCE.sendToServer(new MessageAngelSeen(angel.getEntityId()));
			}
		}
	}
	
}
