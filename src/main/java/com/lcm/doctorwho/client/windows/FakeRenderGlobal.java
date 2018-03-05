package com.lcm.doctorwho.client.windows;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;

/**
 * Created by Nictogen on 3/5/18.
 */
public class FakeRenderGlobal extends RenderGlobal
{
	public FakeRenderGlobal(Minecraft mcIn)
	{
		super(mcIn);
	}

	@Override public void renderSky(float partialTicks, int pass)
	{

	}
}
