package com.lcm.doctorwho.client.events;

import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageAngelSeen;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Nictogen on 2/19/18
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ATGClientEventHandler {
	
	@SubscribeEvent
	public void AngelsRender(RenderLivingEvent.Post<EntityWeepingAngel> e) {
		EntityLivingBase entity = e.getEntity();
		if (entity instanceof EntityWeepingAngel) {
			EntityWeepingAngel angel = (EntityWeepingAngel) entity;
			if(!angel.isSeen()) {
				ATGNetwork.INSTANCE.sendToServer(new MessageAngelSeen(angel.getEntityId()));
			}
		}
	}
	
}
