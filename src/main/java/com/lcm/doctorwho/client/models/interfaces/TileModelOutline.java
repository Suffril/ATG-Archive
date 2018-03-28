package com.lcm.doctorwho.client.models.interfaces;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class TileModelOutline extends ModelBase {

	public ResourceLocation TEX = TextureMap.LOCATION_MISSING_TEXTURE;

	public void render(float scale)
	{

	}

	public ResourceLocation getTexture()
	{
		return TEX;
	}

	/**
	 * Didn't see the need to have the same method used over and over in a load of model classes
	 */
	@SideOnly(Side.CLIENT) public static void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}


}
