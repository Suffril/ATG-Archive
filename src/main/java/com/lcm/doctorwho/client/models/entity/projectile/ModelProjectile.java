package com.lcm.doctorwho.client.models.entity.projectile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class ModelProjectile extends ModelBase {

	ModelRenderer GOD;
	ModelRenderer WEEN;
	ModelRenderer SATAN;
	ModelRenderer THE;
	ModelRenderer ONE;
	ModelRenderer NESS;

	public ModelProjectile() {
		textureWidth = 32;
		textureHeight = 32;

		GOD = new ModelRenderer(this, 0, 9);
		GOD.addBox(0F, -1F, -3.5F, 0, 2, 7);
		GOD.setRotationPoint(0F, 0F, 0F);
		GOD.setTextureSize(32, 32);
		GOD.mirror = true;
		setRotation(GOD, 0F, 0F, 1.22173F);
		WEEN = new ModelRenderer(this, 0, 0);
		WEEN.addBox(-0.5F, -0.5F, -4F, 1, 1, 8);
		WEEN.setRotationPoint(0F, 0F, 0F);
		WEEN.setTextureSize(32, 32);
		WEEN.mirror = true;
		setRotation(WEEN, 0F, 0F, 0.7853982F);
		SATAN = new ModelRenderer(this, 0, 9);
		SATAN.addBox(0F, -1F, -3.5F, 0, 2, 7);
		SATAN.setRotationPoint(0F, 0F, 0F);
		SATAN.setTextureSize(32, 32);
		SATAN.mirror = true;
		setRotation(SATAN, 0F, 0F, 0F);
		THE = new ModelRenderer(this, 0, 9);
		THE.addBox(0F, -1F, -3.5F, 0, 2, 7);
		THE.setRotationPoint(0F, 0F, 0F);
		THE.setTextureSize(32, 32);
		THE.mirror = true;
		setRotation(THE, 0F, 0F, 2.443461F);
		ONE = new ModelRenderer(this, 0, 9);
		ONE.addBox(0F, -1F, -3.5F, 0, 2, 7);
		ONE.setRotationPoint(0F, 0F, 0F);
		ONE.setTextureSize(32, 32);
		ONE.mirror = true;
		setRotation(ONE, 0F, 0F, 0.6108652F);
		NESS = new ModelRenderer(this, 0, 9);
		NESS.addBox(0F, -1F, -3.5F, 0, 2, 7);
		NESS.setRotationPoint(0F, 0F, 0F);
		NESS.setTextureSize(32, 32);
		NESS.mirror = true;
		setRotation(NESS, 0F, 0F, 1.832596F);
	}

	public void render(Entity entity, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.rotate(entity.world.getWorldTime() * 60, 0, 0, 1);
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
		int bright = 0xF0;
		int brightX = bright % 65536;
		int brightY = bright / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightX, brightY);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		GOD.render(scale);
		WEEN.render(scale);
		SATAN.render(scale);
		THE.render(scale);
		ONE.render(scale);
		NESS.render(scale);
		GlStateManager.disableAlpha();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
