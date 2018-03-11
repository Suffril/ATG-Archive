package com.lcm.doctorwho.client.models.clothing.canon.hats;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.BodyPartHook;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ModelFez extends ModelBiped {
	/**
	 * Model Fez
	 * 
	 * @Author - Lucy
	 * @Date - 02/25/2018
	 */
	
	private ResourceLocation TEX = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/models/clothing/fez.png");
	
	ModelRenderer FezSubBase;
	ModelRenderer FezSubTassleBase;
	ModelRenderer FezSubTassle1;
	ModelRenderer FezSubTassle2;
	
	public ModelFez() {
		textureWidth = 64;
		textureHeight = 32;
		
		FezSubBase = new ModelRenderer(this, 0, 4);
		FezSubBase.addBox(0F, 0F, 0F, 4, 3, 4);
		FezSubBase.setRotationPoint(-1F, 21F, -2F);
		FezSubBase.setTextureSize(64, 32);
		FezSubBase.mirror = true;
		setRotation(FezSubBase, 0F, 0F, 0F);
		FezSubTassleBase = new ModelRenderer(this, 0, 1);
		FezSubTassleBase.addBox(0F, 0F, 0F, 1, 1, 1);
		FezSubTassleBase.setRotationPoint(0.5F, 20.5F, -0.4333333F);
		FezSubTassleBase.setTextureSize(64, 32);
		FezSubTassleBase.mirror = true;
		setRotation(FezSubTassleBase, 0F, 0F, 0F);
		FezSubTassle1 = new ModelRenderer(this, 5, 2);
		FezSubTassle1.addBox(0F, 0F, 0F, 2, 0, 1);
		FezSubTassle1.setRotationPoint(1.5F, 20.9F, -0.4333333F);
		FezSubTassle1.setTextureSize(64, 32);
		FezSubTassle1.mirror = true;
		setRotation(FezSubTassle1, 0F, 0F, 0F);
		FezSubTassle2 = new ModelRenderer(this, 12, 1);
		FezSubTassle2.addBox(0F, 0F, 0F, 1, 2, 0);
		FezSubTassle2.setRotationPoint(3.5F, 20.9F, -0.4333333F);
		FezSubTassle2.setTextureSize(64, 32);
		FezSubTassle2.mirror = true;
		setRotation(FezSubTassle2, 0F, -1.570796F, 0F);
		
		this.bipedHeadwear.isHidden = true;
		
		this.bipedHead = new BodyPartHook(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0);
		this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		
		((BodyPartHook) this.bipedHead).setRender(new BodyPartHook.IPartRenderer() {
			@Override
			public void render(float scale) {
				GlStateManager.pushMatrix();
				Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(TEX);
				GlStateManager.translate(0F, -2F, 0F);
				FezSubBase.render(scale);
				FezSubTassleBase.render(scale);
				FezSubTassle1.render(scale);
				FezSubTassle2.render(scale);
				GlStateManager.popMatrix();
			}
		});
		
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
}
