package com.lcm.doctorwho.client;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.windows.Window;
import com.lcm.doctorwho.common.entities.EntityCamera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Nictogen on 2/19/18
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ATGClientEventHandler
{

	public static Window window;

	public static boolean rendering = false;

	@SubscribeEvent
	public static void onRenderDisplay(RenderWorldLastEvent event){
		if(window == null){
			window = new Window(new EntityCamera(1500, 500, 500));
			Minecraft.getMinecraft().world.spawnEntity(window.viewEntity);
		} else if(!rendering){
			rendering = true;
//			window.renderWorldToTexture(event.getPartialTicks());
			rendering = false;
		}
	}

	@SubscribeEvent
	public static void onRenderGui(RenderGameOverlayEvent event)
	{
		if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE)
			return;
		if(window != null)
		{
			if(window.image != null)
			{
				Tessellator tessellator = Tessellator.getInstance();
				BufferBuilder bufferBuilder = tessellator.getBuffer();

				DynamicTexture texture = new DynamicTexture(window.image);
				GlStateManager.bindTexture(texture.getGlTextureId());

				bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
				bufferBuilder.pos(20.0, 120.0, 20.0D).tex(0, 1).color(255, 255, 255, 255).endVertex();
				bufferBuilder.pos(120.0, 120.0, 20.0D).tex(1, 1).color(255, 255, 255, 255).endVertex();
				bufferBuilder.pos(120.0, 20.0, 20.0D).tex(1, 0).color(255, 255, 255, 255).endVertex();
				bufferBuilder.pos(20.0, 20.0, 20.0D).tex(0, 0).color(255, 255, 255, 255).endVertex();
				tessellator.draw();
			}
		}
	}

	@SubscribeEvent
	public static void registerObjects(RegistryEvent.Register<EntityEntry> event) throws Exception
	{
		EntityEntryBuilder.create().entity(EntityCamera.class).factory(world -> new EntityCamera(0, 0, 0)).id(new ResourceLocation(AcrossTheGalaxy.MODID, "camera"), 0).name("camera").build();
	}


}
