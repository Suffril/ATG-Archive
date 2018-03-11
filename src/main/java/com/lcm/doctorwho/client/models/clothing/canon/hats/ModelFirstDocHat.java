package com.lcm.doctorwho.client.models.clothing.canon.hats;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.BodyPartHook;
import com.lcm.doctorwho.utils.ATGUtils;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ModelFirstDocHat extends ModelBiped {

	/**
	 * Model First Doctor hats
	 *
	 * @Author - Lucy
	 * @Date - 02/19/2018
	 */

	private ResourceLocation TEX = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/models/clothing/first_doc_hat.png");

	ModelRenderer Base;
	ModelRenderer Hat2;
	ModelRenderer Hat3;
	ModelRenderer Hat4;
	ModelRenderer Hat5;
	ModelRenderer Hat6;
	ModelRenderer Hat7;
	ModelRenderer Hat8;

	public ModelFirstDocHat() {
		textureWidth = 64;
		textureHeight = 64;

		Base = new ModelRenderer(this, 2, 16);
		Base.addBox(0F, 0F, 0F, 9, 2, 9);
		Base.setRotationPoint(-4.5F, -14F, -5F);
		Base.setTextureSize(64, 64);
		Base.mirror = true;
		ATGUtils.setRotation(Base, 0F, 0F, 0F);
		Hat2 = new ModelRenderer(this, 4, 6);
		Hat2.addBox(0F, 0F, 0F, 8, 1, 8);
		Hat2.setRotationPoint(-4F, -15F, -4.5F);
		Hat2.setTextureSize(64, 64);
		Hat2.mirror = true;
		ATGUtils.setRotation(Hat2, 0F, 0F, 0F);
		Hat3 = new ModelRenderer(this, 37, 38);
		Hat3.addBox(0F, 0F, 0F, 2, 1, 6);
		Hat3.setRotationPoint(-3F, -17F, -3.5F);
		Hat3.setTextureSize(64, 64);
		Hat3.mirror = true;
		ATGUtils.setRotation(Hat3, 0F, 0F, 0F);
		Hat4 = new ModelRenderer(this, 37, 30);
		Hat4.addBox(0F, 0F, 0F, 2, 1, 6);
		Hat4.setRotationPoint(1F, -17F, -3.5F);
		Hat4.setTextureSize(64, 64);
		Hat4.mirror = true;
		ATGUtils.setRotation(Hat4, 0F, 0F, 0F);
		Hat5 = new ModelRenderer(this, 22, 39);
		Hat5.addBox(0F, 0F, 0F, 1, 1, 5);
		Hat5.setRotationPoint(-2.5F, -17.5F, -3F);
		Hat5.setTextureSize(64, 64);
		Hat5.mirror = true;
		ATGUtils.setRotation(Hat5, 0F, 0F, 0F);
		Hat6 = new ModelRenderer(this, 8, 39);
		Hat6.addBox(0F, 0F, 0F, 1, 1, 5);
		Hat6.setRotationPoint(1.5F, -17.5F, -3F);
		Hat6.setTextureSize(64, 64);
		Hat6.mirror = true;
		ATGUtils.setRotation(Hat6, 0F, 0F, 0F);
		Hat7 = new ModelRenderer(this, 7, 29);
		Hat7.addBox(0F, 0F, 0F, 7, 1, 7);
		Hat7.setRotationPoint(-3.5F, -16F, -4F);
		Hat7.setTextureSize(64, 64);
		Hat7.mirror = true;
		ATGUtils.setRotation(Hat7, 0F, 0F, 0F);
		Hat8 = new ModelRenderer(this, 40, 7);
		Hat8.addBox(0F, 0F, 0F, 2, 1, 6);
		Hat8.setRotationPoint(-1F, -16.5F, -3.5F);
		Hat8.setTextureSize(64, 64);
		Hat8.mirror = true;
		ATGUtils.setRotation(Hat8, 0F, 0F, 0F);

		this.bipedHeadwear.isHidden = true;

		this.bipedHead = new BodyPartHook(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0);
		this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);

		((BodyPartHook) this.bipedHead).setRender(new BodyPartHook.IPartRenderer() {
			@Override
			public void render(float scale) {
				GlStateManager.pushMatrix();
				GlStateManager.translate(0, 0.35, 0);
				ATGUtils.bindTexture(TEX);
				Base.render(scale);
				Hat2.render(scale);
				Hat3.render(scale);
				Hat4.render(scale);
				Hat5.render(scale);
				Hat6.render(scale);
				Hat7.render(scale);
				Hat8.render(scale);
				GlStateManager.popMatrix();
			}
		});

	}
}
