package com.lcm.doctorwho.client.render.entity;

import com.lcm.doctorwho.client.windows.EntityWindow;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

/**
 * Created by Nictogen on 3/1/18.
 */
public class RenderWindow extends Render<EntityWindow>
{
	public RenderWindow(RenderManager renderManager)
	{
		super(renderManager);
	}

	@Override public void doRender(EntityWindow entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		entity.rendering = true;
	}

	@Nullable @Override protected ResourceLocation getEntityTexture(EntityWindow entity)
	{
		return null;
	}
}
