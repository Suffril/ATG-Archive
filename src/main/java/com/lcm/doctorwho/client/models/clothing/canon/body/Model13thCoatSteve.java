package com.lcm.doctorwho.client.models.clothing.canon.body;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.BodyPartHook;
import com.lcm.doctorwho.utils.ATGUtils;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class Model13thCoatSteve extends ModelBiped {
	
	/**
	 * Model Thirtenth Doctor Jacket
	 *
	 * @Author - Lucy
	 * @Date - - 02/26/2018
	 */
	
	private ResourceLocation TEX = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/models/clothing/13_steve_coat.png");
	
	ModelRenderer CoatBaseLeft;
	ModelRenderer CoatBaseLeft2;
	ModelRenderer CoatBaseRight;
	ModelRenderer CoatBaseRight2;
	ModelRenderer CoatBaseBack;
	ModelRenderer RACoatArmFront;
	ModelRenderer RACoatArmTop;
	ModelRenderer RACoatArmLeft;
	ModelRenderer RACoatArmRight;
	ModelRenderer RACoatArmBack;
	ModelRenderer LACoatArmFront;
	ModelRenderer LACoatArmTop;
	ModelRenderer LACoatArmBack;
	ModelRenderer LACoatArmLeft;
	ModelRenderer LACoatArmRight;
	ModelRenderer Button1;
	ModelRenderer Button2;
	ModelRenderer Button3;
	ModelRenderer Button4;
	ModelRenderer Button5;
	ModelRenderer Button6;
	ModelRenderer LapelRight1;
	ModelRenderer LapelRight2;
	ModelRenderer LapelLeft1;
	ModelRenderer LapelLeft2;
	ModelRenderer ButtonBack1;
	ModelRenderer ButtonBack2;
	
	public Model13thCoatSteve() {
		textureWidth = 64;
		textureHeight = 64;
		ButtonBack2 = new ModelRenderer(this, 52, 39);
		ButtonBack2.setRotationPoint(-2.0F, 8.800000381469728F, 1.7000000476837158F);
		ButtonBack2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		RACoatArmTop = new ModelRenderer(this, 0, 24);
		RACoatArmTop.setRotationPoint(-3.0F, -2.1F, -2.0F);
		RACoatArmTop.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
		ButtonBack1 = new ModelRenderer(this, 52, 36);
		ButtonBack1.setRotationPoint(1.0F, 8.800000381469728F, 1.7000000476837158F);
		ButtonBack1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		CoatBaseLeft = new ModelRenderer(this, 22, 0);
		CoatBaseLeft.setRotationPoint(3.0999999046325684F, -0.40000000149011616F, -2.5F);
		CoatBaseLeft.addBox(0.0F, 0.0F, 0.0F, 1, 15, 5, 0.0F);
		CoatBaseRight = new ModelRenderer(this, 22, 21);
		CoatBaseRight.setRotationPoint(-4.099999904632568F, -0.40000000149011616F, -2.5F);
		CoatBaseRight.addBox(0.0F, 0.0F, 0.0F, 1, 15, 5, 0.0F);
		CoatBaseRight2 = new ModelRenderer(this, 36, 19);
		CoatBaseRight2.setRotationPoint(-3.0999999046325684F, -0.40000000149011616F, -2.5F);
		CoatBaseRight2.addBox(0.0F, 0.0F, 0.0F, 1, 14, 4, 0.0F);
		RACoatArmLeft = new ModelRenderer(this, 0, 42);
		RACoatArmLeft.setRotationPoint(-3.1F, -2.1F, -2.5F);
		RACoatArmLeft.addBox(0.0F, 0.0F, 0.0F, 1, 10, 5, 0.0F);
		LACoatArmFront = new ModelRenderer(this, 47, 0);
		LACoatArmFront.setRotationPoint(-1.0F, -2.1F, -2.5F);
		LACoatArmFront.addBox(0.0F, 0.0F, 0.0F, 4, 10, 1, 0.0F);
		LapelRight1 = new ModelRenderer(this, 47, 24);
		LapelRight1.setRotationPoint(-3.200000047683716F, -0.30000000000000004F, -2.799999952316284F);
		LapelRight1.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
		Button3 = new ModelRenderer(this, 58, 6);
		Button3.setRotationPoint(-4.199999809265137F, 7.200000000000001F, -0.699999988079071F);
		Button3.addBox(0.0F, 0.0F, -2.0F, 1, 1, 1, 0.0F);
		Button6 = new ModelRenderer(this, 58, 15);
		Button6.setRotationPoint(3.200000047683716F, 7.200000000000001F, -0.699999988079071F);
		Button6.addBox(0.0F, 0.0F, -2.0F, 1, 1, 1, 0.0F);
		CoatBaseBack = new ModelRenderer(this, 0, 0);
		CoatBaseBack.setRotationPoint(-4.0F, -0.40000000149011616F, 1.5F);
		CoatBaseBack.addBox(0.0F, 0.0F, 0.0F, 8, 15, 1, 0.0F);
		RACoatArmBack = new ModelRenderer(this, 10, 30);
		RACoatArmBack.setRotationPoint(-3.0F, -2.1F, 1.5F);
		RACoatArmBack.addBox(0.0F, 0.0F, 0.0F, 4, 10, 1, 0.0F);
		CoatBaseLeft2 = new ModelRenderer(this, 36, 0);
		CoatBaseLeft2.setRotationPoint(2.0999999046325684F, -0.40000000149011616F, -2.5F);
		CoatBaseLeft2.addBox(0.0F, 0.0F, 0.0F, 1, 14, 4, 0.0F);
		LACoatArmLeft = new ModelRenderer(this, 27, 42);
		LACoatArmLeft.setRotationPoint(2.1F, -2.1F, -2.5F);
		LACoatArmLeft.addBox(0.0F, 0.0F, 0.0F, 1, 10, 5, 0.0F);
		RACoatArmFront = new ModelRenderer(this, 0, 30);
		RACoatArmFront.setRotationPoint(-3.0F, -2.1F, -2.5F);
		RACoatArmFront.addBox(0.0F, 0.0F, 0.0F, 4, 10, 1, 0.0F);
		LACoatArmRight = new ModelRenderer(this, 41, 42);
		LACoatArmRight.setRotationPoint(-1.1F, -2.1F, -2.5F);
		LACoatArmRight.addBox(0.0F, 0.0F, 0.0F, 1, 10, 5, 0.0F);
		Button2 = new ModelRenderer(this, 58, 3);
		Button2.setRotationPoint(-4.199999809265137F, 9.200000000000001F, -0.699999988079071F);
		Button2.addBox(0.0F, 0.0F, -2.0F, 1, 1, 1, 0.0F);
		LapelRight2 = new ModelRenderer(this, 52, 24);
		LapelRight2.setRotationPoint(-3.9000000953674316F, 0.7000000000000001F, -2.700000047683716F);
		LapelRight2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		Button4 = new ModelRenderer(this, 58, 9);
		Button4.setRotationPoint(3.200000047683716F, 11.200000000000001F, -0.699999988079071F);
		Button4.addBox(0.0F, 0.0F, -2.0F, 1, 1, 1, 0.0F);
		Button1 = new ModelRenderer(this, 58, 0);
		Button1.setRotationPoint(-4.199999809265137F, 11.200000000000001F, -0.699999988079071F);
		Button1.addBox(0.0F, 0.0F, -2.0F, 1, 1, 1, 0.0F);
		RACoatArmRight = new ModelRenderer(this, 14, 42);
		RACoatArmRight.setRotationPoint(0.1F, -2.1F, -2.5F);
		RACoatArmRight.addBox(0.0F, 0.0F, 0.0F, 1, 10, 5, 0.0F);
		LACoatArmTop = new ModelRenderer(this, 0, 18);
		LACoatArmTop.setRotationPoint(-1.0F, -2.1F, -2.0F);
		LACoatArmTop.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
		LapelLeft2 = new ModelRenderer(this, 52, 30);
		LapelLeft2.setRotationPoint(2.9000000953674316F, 0.7000000000000001F, -2.700000047683716F);
		LapelLeft2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		LapelLeft1 = new ModelRenderer(this, 47, 33);
		LapelLeft1.setRotationPoint(2.200000047683716F, -0.30000000000000004F, -2.799999952316284F);
		LapelLeft1.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
		Button5 = new ModelRenderer(this, 58, 12);
		Button5.setRotationPoint(3.200000047683716F, 9.200000000000001F, -0.699999988079071F);
		Button5.addBox(0.0F, 0.0F, -2.0F, 1, 1, 1, 0.0F);
		LACoatArmBack = new ModelRenderer(this, 47, 12);
		LACoatArmBack.setRotationPoint(-1.0F, -2.1F, 1.5F);
		LACoatArmBack.addBox(0.0F, 0.0F, 0.0F, 4, 10, 1, 0.0F);
		
		bipedRightArm.addChild(RACoatArmTop);
		bipedRightArm.addChild(RACoatArmLeft);
		bipedLeftArm.addChild(LACoatArmFront);
		bipedRightArm.addChild(RACoatArmBack);
		bipedLeftArm.addChild(LACoatArmLeft);
		bipedRightArm.addChild(RACoatArmFront);
		bipedLeftArm.addChild(LACoatArmRight);
		bipedRightArm.addChild(RACoatArmRight);
		bipedLeftArm.addChild(LACoatArmTop);
		bipedLeftArm.addChild(LACoatArmBack);
		
		bipedBody = new BodyPartHook(this, 16, 16);
		bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		
		((BodyPartHook) bipedBody).setRender(new BodyPartHook.IPartRenderer() {
			@Override
			public void render(float scale) {
				GlStateManager.pushMatrix();
				ATGUtils.bindTexture(TEX);
				CoatBaseLeft.render(scale);
				CoatBaseLeft2.render(scale);
				CoatBaseRight.render(scale);
				CoatBaseRight2.render(scale);
				CoatBaseBack.render(scale);
				Button1.render(scale);
				Button2.render(scale);
				Button3.render(scale);
				Button4.render(scale);
				Button5.render(scale);
				Button6.render(scale);
				LapelRight1.render(scale);
				LapelRight2.render(scale);
				LapelLeft1.render(scale);
				LapelLeft2.render(scale);
				ButtonBack1.render(scale);
				ButtonBack2.render(scale);
				GlStateManager.popMatrix();
			}
		});
		
	}
	
}
