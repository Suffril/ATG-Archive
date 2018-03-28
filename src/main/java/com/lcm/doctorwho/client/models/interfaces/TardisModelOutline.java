package com.lcm.doctorwho.client.models.interfaces;

import com.lcm.doctorwho.AcrossTheGalaxy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class TardisModelOutline extends ModelBase {

	public ResourceLocation TEX = TextureMap.LOCATION_MISSING_TEXTURE;

	private boolean doorOpen = false;

	public float doorRotation;

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

	/**
	 * Didn't see the need to have the same method used over and over in a load of model classes
	 */
	@SideOnly(Side.CLIENT) public static void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	protected void rotateDoor(float angle) {
		if(doorRotation < angle)
		{
			doorRotation++;
			System.out.println(doorRotation);
		}
	}
}
