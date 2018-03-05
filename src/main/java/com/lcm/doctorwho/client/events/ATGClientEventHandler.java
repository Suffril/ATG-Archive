package com.lcm.doctorwho.client.events;

import com.lcm.doctorwho.client.windows.EntityWindow;
import com.lcm.doctorwho.client.windows.FakeWorldHandler;
import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageAngelSeen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

/**
 * Created by Nictogen on 2/19/18
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ATGClientEventHandler
{

	public static Boolean reRendering = false;

	@SubscribeEvent
	public static void AngelsRender(RenderLivingEvent.Post<EntityWeepingAngel> e)
	{
		EntityLivingBase entity = e.getEntity();
		if (entity instanceof EntityWeepingAngel)
		{
			EntityWeepingAngel angel = (EntityWeepingAngel) entity;
			if (!angel.isSeen())
			{
				ATGNetwork.INSTANCE.sendToServer(new MessageAngelSeen(angel.getEntityId()));
			}
		}
	}

	@SubscribeEvent
	public static void renderWorldLast(RenderWorldLastEvent event)
	{
		if (reRendering)
			return;

		if (FakeWorldHandler.fakeWorld != null)
			Minecraft.getMinecraft().world.loadedEntityList.stream().filter(entity -> entity instanceof EntityWindow && ((EntityWindow) entity).rendering)
					.forEach(entity -> {
						((EntityWindow) entity).rendering = false;
						reRendering = true;
						GlStateManager.pushMatrix();

						WorldClient worldClient = Minecraft.getMinecraft().world;
						RenderGlobal renderGlobal = Minecraft.getMinecraft().renderGlobal;

						Minecraft.getMinecraft().world = FakeWorldHandler.fakeWorld;
						Minecraft.getMinecraft().getRenderManager().setWorld(FakeWorldHandler.fakeWorld);
						Minecraft.getMinecraft().renderGlobal = FakeWorldHandler.renderGlobal;
						((EntityWindow) entity).renderWorldToTexture(event.getPartialTicks());

						Minecraft.getMinecraft().world = worldClient;
						Minecraft.getMinecraft().renderGlobal = renderGlobal;
						Minecraft.getMinecraft().getRenderManager().setWorld(worldClient);

						GlStateManager.popMatrix();
						GlStateManager.bindTexture(new DynamicTexture(((EntityWindow) entity).image).getGlTextureId());
						reRendering = false;

						GlStateManager.pushMatrix();
						EntityPlayer player = Minecraft.getMinecraft().player;
						GlStateManager.translate(-player.posX, -player.posY, -player.posZ);
						GlStateManager.translate(entity.posX, entity.posY, entity.posZ);
						Tessellator tessellator = Tessellator.getInstance();
						GlStateManager.enableTexture2D();
						BufferBuilder bufferBuilder = tessellator.getBuffer();
						bufferBuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
						bufferBuilder.pos(0, 0, -1).tex(0, 1).endVertex();
						bufferBuilder.pos(0, 0, 1).tex(1, 1).endVertex();
						bufferBuilder.pos(0, 5, 1).tex(1, 0).endVertex();
						bufferBuilder.pos(0, 5, -1).tex(0, 0).endVertex();
						tessellator.draw();
						GlStateManager.popMatrix();
					});

	}

}
