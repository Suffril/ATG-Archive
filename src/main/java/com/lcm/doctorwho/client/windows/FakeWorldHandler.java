package com.lcm.doctorwho.client.windows;

import net.minecraft.client.Minecraft;

/**
 * Created by Nictogen on 3/5/18.
 */
public class FakeWorldHandler
{
	public static FakeWorld fakeWorld;
	public static FakeRenderGlobal renderGlobal;

	public static void createFakeWorld(){
		if(fakeWorld == null){
			fakeWorld = new FakeWorld(-1);
			renderGlobal = new FakeRenderGlobal(Minecraft.getMinecraft());
			renderGlobal.setWorldAndLoadRenderers(FakeWorldHandler.fakeWorld);
		}
	}
}
