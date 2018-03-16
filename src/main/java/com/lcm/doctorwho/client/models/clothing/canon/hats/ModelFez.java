package com.lcm.doctorwho.client.models.clothing.canon.hats;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.BodyPartHook;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ModelFez extends ModelBiped {

	private ResourceLocation TEX = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/models/clothing/fez.png");

	public ModelFez() {
		textureWidth = 64;
		textureHeight = 32;

		ModelRenderer fezSubBase = new ModelRenderer(this, 0, 4);
		fezSubBase.addBox(0F, 0F, 0F, 4, 3, 4);
		fezSubBase.setRotationPoint(-1F, 21F, -2F);
		fezSubBase.setTextureSize(64, 32);
		fezSubBase.mirror = true;
		ATGUtils.setRotation(fezSubBase, 0F, 0F, 0F);

		ModelRenderer fezSubTassleBase = new ModelRenderer(this, 0, 1);
		fezSubTassleBase.addBox(0F, 0F, 0F, 1, 1, 1);
		fezSubTassleBase.setRotationPoint(0.5F, 20.5F, -0.4333333F);
		fezSubTassleBase.setTextureSize(64, 32);
		fezSubTassleBase.mirror = true;
		ATGUtils.setRotation(fezSubTassleBase, 0F, 0F, 0F);

		ModelRenderer fezSubTassle1 = new ModelRenderer(this, 5, 2);
		fezSubTassle1.addBox(0F, 0F, 0F, 2, 0, 1);
		fezSubTassle1.setRotationPoint(1.5F, 20.9F, -0.4333333F);
		fezSubTassle1.setTextureSize(64, 32);
		fezSubTassle1.mirror = true;
		ATGUtils.setRotation(fezSubTassle1, 0F, 0F, 0F);

		ModelRenderer fezSubTassle2 = new ModelRenderer(this, 12, 1);
		fezSubTassle2.addBox(0F, 0F, 0F, 1, 2, 0);
		fezSubTassle2.setRotationPoint(3.5F, 20.9F, -0.4333333F);
		fezSubTassle2.setTextureSize(64, 32);
		fezSubTassle2.mirror = true;
		ATGUtils.setRotation(fezSubTassle2, 0F, -1.570796F, 0F);

		this.bipedHeadwear.isHidden = true;

		this.bipedHead = new BodyPartHook(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0);
		this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);

		((BodyPartHook) this.bipedHead).setRender(scale -> {
			GlStateManager.pushMatrix();
			Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(TEX);
			GlStateManager.translate(0F, -2F, 0F);
			fezSubBase.render(scale);
			fezSubTassleBase.render(scale);
			fezSubTassle1.render(scale);
			fezSubTassle2.render(scale);
			GlStateManager.popMatrix();
		});

	}



}
