package com.lcm.doctorwho.client.render.entity;

import com.lcm.doctorwho.AcrossTheGalaxy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderEntityBase<T extends EntityLiving> extends RenderLiving<T> {
	private String textureName;

	public RenderEntityBase(RenderManager manager, ModelBase model, String texName, float shadowSize) {
		super(manager, model, shadowSize);
		textureName = texName;
	}

	@Override protected ResourceLocation getEntityTexture(T entity) {
		return new ResourceLocation(AcrossTheGalaxy.MODID, "textures/entity/" + textureName + ".png");
	}

}
