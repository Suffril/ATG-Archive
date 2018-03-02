package com.lcm.doctorwho.events;

import com.lcm.doctorwho.client.models.entity.ModelWeepingAngel;
import com.lcm.doctorwho.client.render.entity.RenderEntityBase;
import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageAngelSeen;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Nictogen on 2/19/18
 */
@Mod.EventBusSubscriber(Side.CLIENT) //*physicaly* client
public class ATGClientEventHandler { // NO_UCD (unused code)
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityWeepingAngel.class, new RenderEntityBase<>(new ModelWeepingAngel(), "weeping_angel", 1.0F));
		MinecraftForge.EVENT_BUS.register(new ATGClientEventHandler());
	}
	
	@SubscribeEvent
	public void renderAngels(RenderLivingEvent.Post<EntityWeepingAngel> e) {
		EntityLivingBase entity = e.getEntity();
		if (entity instanceof EntityWeepingAngel) {
			EntityWeepingAngel angel = (EntityWeepingAngel) entity;
			if(!angel.isSeen()) ATGNetwork.INSTANCE.sendToServer(new MessageAngelSeen(angel.getEntityId()));
		}
	}
	
}
