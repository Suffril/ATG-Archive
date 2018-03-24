package com.lcm.doctorwho.client.models.interfaces;

import com.lcm.doctorwho.AcrossTheGalaxy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

public abstract class TardisModelOutline extends ModelBase {

	public ResourceLocation TEX = TextureMap.LOCATION_MISSING_TEXTURE;

	private boolean doorOpen = false;

	public void renderRightDoor(float scale) {}

	public void renderLeftDoor(float scale) {}

	public void renderShell(float scale) {}

	public void renderLamp(float scale) {}

	public void renderText(float scale) {}

	public void other(float scale) {}

	public void renderAll(float scale) {}

	public boolean isDoorOpen() {
		return doorOpen;
	}

	public void setDoorOpen(boolean open) {
		doorOpen = open;
	}

	public ResourceLocation getTexture() {
		return TEX;
	}

	public String getExteriorName()
	{
		return "Sheriff's gay";
	}
}
