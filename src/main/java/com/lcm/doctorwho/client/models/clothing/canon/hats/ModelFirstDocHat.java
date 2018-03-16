package com.lcm.doctorwho.client.models.clothing.canon.hats;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.BodyPartHook;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class ModelFirstDocHat extends ModelBiped {
	private ResourceLocation TEX = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/models/clothing/first_doc_hat.png");

	public ModelFirstDocHat() {
		textureWidth = 64;
		textureHeight = 64;

		ArrayList<ModelRenderer> boxes = new ArrayList<>();

		ModelRenderer base = new ModelRenderer(this, 2, 16);
		base.addBox(0F, 0F, 0F, 9, 2, 9);
		base.setRotationPoint(-4.5F, -14F, -5F);
		ATGUtils.setRotation(base, 0F, 0F, 0F);
		boxes.add(base);

		ModelRenderer hat2 = new ModelRenderer(this, 4, 6);
		hat2.addBox(0F, 0F, 0F, 8, 1, 8);
		hat2.setRotationPoint(-4F, -15F, -4.5F);
		ATGUtils.setRotation(hat2, 0F, 0F, 0F);
		boxes.add(hat2);

		ModelRenderer hat3 = new ModelRenderer(this, 37, 38);
		hat3.addBox(0F, 0F, 0F, 2, 1, 6);
		hat3.setRotationPoint(-3F, -17F, -3.5F);
		ATGUtils.setRotation(hat3, 0F, 0F, 0F);
		boxes.add(hat3);

		ModelRenderer hat4 = new ModelRenderer(this, 37, 30);
		hat4.addBox(0F, 0F, 0F, 2, 1, 6);
		hat4.setRotationPoint(1F, -17F, -3.5F);
		ATGUtils.setRotation(hat4, 0F, 0F, 0F);
		boxes.add(hat4);

		ModelRenderer hat5 = new ModelRenderer(this, 22, 39);
		hat5.addBox(0F, 0F, 0F, 1, 1, 5);
		hat5.setRotationPoint(-2.5F, -17.5F, -3F);
		ATGUtils.setRotation(hat5, 0F, 0F, 0F);
		boxes.add(hat5);

		ModelRenderer hat6 = new ModelRenderer(this, 8, 39);
		hat6.addBox(0F, 0F, 0F, 1, 1, 5);
		hat6.setRotationPoint(1.5F, -17.5F, -3F);
		ATGUtils.setRotation(hat6, 0F, 0F, 0F);
		boxes.add(hat6);

		ModelRenderer hat7 = new ModelRenderer(this, 7, 29);
		hat7.addBox(0F, 0F, 0F, 7, 1, 7);
		hat7.setRotationPoint(-3.5F, -16F, -4F);
		ATGUtils.setRotation(hat7, 0F, 0F, 0F);
		boxes.add(hat7);

		ModelRenderer hat8 = new ModelRenderer(this, 40, 7);
		hat8.addBox(0F, 0F, 0F, 2, 1, 6);
		hat8.setRotationPoint(-1F, -16.5F, -3.5F);
		ATGUtils.setRotation(hat8, 0F, 0F, 0F);
		boxes.add(hat8);

		for (ModelRenderer box : boxes) {
			box.mirror = true;
			box.setTextureSize(64,64);
		}

		this.bipedHeadwear.isHidden = true;

		this.bipedHead = new BodyPartHook(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0);
		this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);

		((BodyPartHook) this.bipedHead).setRender(scale -> {
			GlStateManager.pushMatrix();
			GlStateManager.translate(0, 0.35, 0);
			ATGUtils.bindTexture(TEX);
			for (ModelRenderer box : boxes)
				box.render(scale);
			GlStateManager.popMatrix();
		});

	}
}
