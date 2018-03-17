package com.lcm.doctorwho.client.render.entity;

import com.lcm.doctorwho.client.render.RenderMobsInit;
import com.lcm.doctorwho.common.entity.hostile.EntityCybermen;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCybermen extends RenderLiving<EntityCybermen> {

	public RenderCybermen(RenderManager manager, ModelBase modelbaseIn) {
		super(manager, modelbaseIn, 1.0F);
	}

	@Override protected void renderModel(EntityCybermen entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		super.renderModel(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
		ModelBiped model = RenderMobsInit.CYBERS.get(entity.getType());
		model.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
	}

	@Nullable @Override protected ResourceLocation getEntityTexture(EntityCybermen entity) {
		return null;
	}
}
