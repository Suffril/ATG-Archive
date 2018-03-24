package com.lcm.doctorwho.client.models.interfaces;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

public abstract class TileModelOutline extends ModelBase {

	public ResourceLocation TEX = TextureMap.LOCATION_MISSING_TEXTURE;

	public void render(float scale)
	{

	}

	public ResourceLocation getTexture()
	{
		return TEX;
	}
}
