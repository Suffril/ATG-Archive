package com.lcm.doctorwho.client.events;

import com.lcm.doctorwho.client.windows.EntityCamera;
import com.lcm.doctorwho.client.windows.FakeWorld;
import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;
import com.lcm.doctorwho.common.tiles.TileEntityTardis;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageAngelSeen;
import com.lcm.doctorwho.utils.ATGConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Nictogen on 2/19/18
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ATGClientEventHandler
{
	public static int cameraID = -1;
	private static boolean rendering = false;

	@SubscribeEvent
	public static void angelsRender(RenderLivingEvent.Post<EntityWeepingAngel> e)
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
	public static void onRenderTick(TickEvent.RenderTickEvent event)
	{

		if(event.phase != TickEvent.Phase.END) return;
		WorldClient worldClient = Minecraft.getMinecraft().world;
		if (worldClient != null)
		{
			RenderGlobal renderGlobal = Minecraft.getMinecraft().renderGlobal;

			worldClient.loadedTileEntityList.forEach(tileEntity -> {
				if (tileEntity instanceof TileEntityTardis)
				{
					FakeWorld fakeWorld = FakeWorld.getFakeWorld(ATGConfig.tardisDIM);
					Minecraft.getMinecraft().world = fakeWorld;
					Minecraft.getMinecraft().getRenderManager().setWorld(fakeWorld);
					Minecraft.getMinecraft().renderGlobal = fakeWorld.renderGlobal;

					EntityCamera camera = fakeWorld.getCamera(cameraID, new BlockPos(0.5, 1, 0.5));
					cameraID = camera.getEntityId();

					GlStateManager.pushMatrix();
					GlStateManager.pushAttrib();
//					renderGlobal.updateClouds();
//					worldClient.doVoidFogParticles(MathHelper.floor(camera.posX), MathHelper.floor(camera.posY), MathHelper.floor(camera.posZ));
					rendering = true;
					camera.renderWorldToTexture(event.renderTickTime);
					rendering = false;
					GlStateManager.popAttrib();
					GlStateManager.popMatrix();

					GlStateManager.enableBlend();
					GlStateManager.disableTexture2D();
					GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
					GlStateManager.enableTexture2D();
					GlStateManager.disableBlend();

					Minecraft.getMinecraft().world = worldClient;
					Minecraft.getMinecraft().renderGlobal = renderGlobal;
					Minecraft.getMinecraft().getRenderManager().setWorld(worldClient);
				}
			});
		}
	}

	@SubscribeEvent
	public static void onCameraSetup(EntityViewRenderEvent.CameraSetup event){
		if(rendering){
//			event.setPitch(event.getPitch() + 10);
		}
	}
}
