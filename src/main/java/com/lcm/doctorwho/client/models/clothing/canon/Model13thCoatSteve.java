package com.lcm.doctorwho.client.models.clothing.canon;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.BodyPartHook;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class Model13thCoatSteve extends ModelBiped
{

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

    public Model13thCoatSteve()
    {
        textureWidth = 64;
        textureHeight = 64;

        CoatBaseLeft = new ModelRenderer(this, 22, 0);
        CoatBaseLeft.addBox(0F, 0F, 0F, 1, 15, 5);
        CoatBaseLeft.setRotationPoint(3.1F, -0.1F, -2.5F);
        CoatBaseLeft.setTextureSize(64, 64);
        CoatBaseLeft.mirror = true;
        setRotation(CoatBaseLeft, 0F, 0F, 0F);
        CoatBaseLeft2 = new ModelRenderer(this, 36, 0);
        CoatBaseLeft2.addBox(0F, 0F, 0F, 1, 14, 4);
        CoatBaseLeft2.setRotationPoint(2.1F, -0.1F, -2.5F);
        CoatBaseLeft2.setTextureSize(64, 64);
        CoatBaseLeft2.mirror = true;
        setRotation(CoatBaseLeft2, 0F, 0F, 0F);
        CoatBaseRight = new ModelRenderer(this, 22, 21);
        CoatBaseRight.addBox(0F, 0F, 0F, 1, 15, 5);
        CoatBaseRight.setRotationPoint(-4.1F, -0.1F, -2.5F);
        CoatBaseRight.setTextureSize(64, 64);
        CoatBaseRight.mirror = true;
        setRotation(CoatBaseRight, 0F, 0F, 0F);
        CoatBaseRight2 = new ModelRenderer(this, 36, 19);
        CoatBaseRight2.addBox(0F, 0F, 0F, 1, 14, 4);
        CoatBaseRight2.setRotationPoint(-3.1F, -0.1F, -2.5F);
        CoatBaseRight2.setTextureSize(64, 64);
        CoatBaseRight2.mirror = true;
        setRotation(CoatBaseRight2, 0F, 0F, 0F);
        CoatBaseBack = new ModelRenderer(this, 0, 0);
        CoatBaseBack.addBox(0F, 0F, 0F, 8, 15, 1);
        CoatBaseBack.setRotationPoint(-4F, -0.1F, 1.5F);
        CoatBaseBack.setTextureSize(64, 64);
        CoatBaseBack.mirror = true;
        setRotation(CoatBaseBack, 0F, 0F, 0F);
        RACoatArmFront = new ModelRenderer(this, 0, 30);
        RACoatArmFront.addBox(0F, 0F, 0F, 4, 10, 1);
        RACoatArmFront.setRotationPoint(-8F, 0.3F, -2.5F);
        RACoatArmFront.setTextureSize(64, 64);
        RACoatArmFront.mirror = true;
        setRotation(RACoatArmFront, 0F, 0F, 0F);
        RACoatArmTop = new ModelRenderer(this, 0, 24);
        RACoatArmTop.addBox(0F, 0F, 0F, 4, 1, 4);
        RACoatArmTop.setRotationPoint(-8F, 0.3F, -2F);
        RACoatArmTop.setTextureSize(64, 64);
        RACoatArmTop.mirror = true;
        setRotation(RACoatArmTop, 0F, 0F, 0F);
        RACoatArmLeft = new ModelRenderer(this, 0, 42);
        RACoatArmLeft.addBox(0F, 0F, 0F, 1, 10, 5);
        RACoatArmLeft.setRotationPoint(-8.1F, 0.3F, -2.5F);
        RACoatArmLeft.setTextureSize(64, 64);
        RACoatArmLeft.mirror = true;
        setRotation(RACoatArmLeft, 0F, 0F, 0F);
        RACoatArmRight = new ModelRenderer(this, 14, 42);
        RACoatArmRight.addBox(0F, 0F, 0F, 1, 10, 5);
        RACoatArmRight.setRotationPoint(-5F, 0.3F, -2.5F);
        RACoatArmRight.setTextureSize(64, 64);
        RACoatArmRight.mirror = true;
        setRotation(RACoatArmRight, 0F, 0F, 0F);
        RACoatArmBack = new ModelRenderer(this, 10, 30);
        RACoatArmBack.addBox(0F, 0F, 0F, 4, 10, 1);
        RACoatArmBack.setRotationPoint(-8F, 0.3F, 1.5F);
        RACoatArmBack.setTextureSize(64, 64);
        RACoatArmBack.mirror = true;
        setRotation(RACoatArmBack, 0F, 0F, 0F);
        LACoatArmFront = new ModelRenderer(this, 47, 0);
        LACoatArmFront.addBox(0F, 0F, 0F, 4, 10, 1);
        LACoatArmFront.setRotationPoint(4F, 0.1F, -2.5F);
        LACoatArmFront.setTextureSize(64, 64);
        LACoatArmFront.mirror = true;
        setRotation(LACoatArmFront, 0F, 0F, 0F);
        LACoatArmTop = new ModelRenderer(this, 0, 18);
        LACoatArmTop.addBox(0F, 0F, 0F, 4, 1, 4);
        LACoatArmTop.setRotationPoint(4F, 0.1F, -2F);
        LACoatArmTop.setTextureSize(64, 64);
        LACoatArmTop.mirror = true;
        setRotation(LACoatArmTop, 0F, 0F, 0F);
        LACoatArmBack = new ModelRenderer(this, 47, 12);
        LACoatArmBack.addBox(0F, 0F, 0F, 4, 10, 1);
        LACoatArmBack.setRotationPoint(4F, 0.1F, 1.5F);
        LACoatArmBack.setTextureSize(64, 64);
        LACoatArmBack.mirror = true;
        setRotation(LACoatArmBack, 0F, 0F, 0F);
        LACoatArmLeft = new ModelRenderer(this, 27, 42);
        LACoatArmLeft.addBox(0F, 0F, 0F, 1, 10, 5);
        LACoatArmLeft.setRotationPoint(7.1F, 0.1F, -2.5F);
        LACoatArmLeft.setTextureSize(64, 64);
        LACoatArmLeft.mirror = true;
        setRotation(LACoatArmLeft, 0F, 0F, 0F);
        LACoatArmRight = new ModelRenderer(this, 41, 42);
        LACoatArmRight.addBox(0F, 0F, 0F, 1, 10, 5);
        LACoatArmRight.setRotationPoint(4F, 0.1F, -2.5F);
        LACoatArmRight.setTextureSize(64, 64);
        LACoatArmRight.mirror = true;
        setRotation(LACoatArmRight, 0F, 0F, 0F);
        Button1 = new ModelRenderer(this, 58, 0);
        Button1.addBox(0F, 0F, -2F, 1, 1, 1);
        Button1.setRotationPoint(-4.2F, 11.5F, -0.7F);
        Button1.setTextureSize(64, 64);
        Button1.mirror = true;
        setRotation(Button1, 0F, 0F, 0F);
        Button2 = new ModelRenderer(this, 58, 3);
        Button2.addBox(0F, 0F, -2F, 1, 1, 1);
        Button2.setRotationPoint(-4.2F, 9.5F, -0.7F);
        Button2.setTextureSize(64, 64);
        Button2.mirror = true;
        setRotation(Button2, 0F, 0F, 0F);
        Button3 = new ModelRenderer(this, 58, 6);
        Button3.addBox(0F, 0F, -2F, 1, 1, 1);
        Button3.setRotationPoint(-4.2F, 7.5F, -0.7F);
        Button3.setTextureSize(64, 64);
        Button3.mirror = true;
        setRotation(Button3, 0F, 0F, 0F);
        Button4 = new ModelRenderer(this, 58, 9);
        Button4.addBox(0F, 0F, -2F, 1, 1, 1);
        Button4.setRotationPoint(3.2F, 11.5F, -0.7F);
        Button4.setTextureSize(64, 64);
        Button4.mirror = true;
        setRotation(Button4, 0F, 0F, 0F);
        Button5 = new ModelRenderer(this, 58, 12);
        Button5.addBox(0F, 0F, -2F, 1, 1, 1);
        Button5.setRotationPoint(3.2F, 9.5F, -0.7F);
        Button5.setTextureSize(64, 64);
        Button5.mirror = true;
        setRotation(Button5, 0F, 0F, 0F);
        Button6 = new ModelRenderer(this, 58, 15);
        Button6.addBox(0F, 0F, -2F, 1, 1, 1);
        Button6.setRotationPoint(3.2F, 7.5F, -0.7F);
        Button6.setTextureSize(64, 64);
        Button6.mirror = true;
        setRotation(Button6, 0F, 0F, 0F);
        LapelRight1 = new ModelRenderer(this, 47, 24);
        LapelRight1.addBox(0F, 0F, 0F, 1, 7, 1);
        LapelRight1.setRotationPoint(-3.2F, 0F, -2.8F);
        LapelRight1.setTextureSize(64, 64);
        LapelRight1.mirror = true;
        setRotation(LapelRight1, 0F, 0F, 0F);
        LapelRight2 = new ModelRenderer(this, 52, 24);
        LapelRight2.addBox(0F, 0F, 0F, 1, 4, 1);
        LapelRight2.setRotationPoint(-3.9F, 1F, -2.7F);
        LapelRight2.setTextureSize(64, 64);
        LapelRight2.mirror = true;
        setRotation(LapelRight2, 0F, 0F, 0F);
        LapelLeft1 = new ModelRenderer(this, 47, 33);
        LapelLeft1.addBox(0F, 0F, 0F, 1, 7, 1);
        LapelLeft1.setRotationPoint(2.2F, 0F, -2.8F);
        LapelLeft1.setTextureSize(64, 64);
        LapelLeft1.mirror = true;
        setRotation(LapelLeft1, 0F, 0F, 0F);
        LapelLeft2 = new ModelRenderer(this, 52, 30);
        LapelLeft2.addBox(0F, 0F, 0F, 1, 4, 1);
        LapelLeft2.setRotationPoint(2.9F, 1F, -2.7F);
        LapelLeft2.setTextureSize(64, 64);
        LapelLeft2.mirror = true;
        setRotation(LapelLeft2, 0F, 0F, 0F);
        ButtonBack1 = new ModelRenderer(this, 52, 36);
        ButtonBack1.addBox(0F, 0F, 0F, 1, 1, 1);
        ButtonBack1.setRotationPoint(1F, 9.1F, 1.7F);
        ButtonBack1.setTextureSize(64, 64);
        ButtonBack1.mirror = true;
        setRotation(ButtonBack1, 0F, 0F, 0F);
        ButtonBack2 = new ModelRenderer(this, 52, 39);
        ButtonBack2.addBox(0F, 0F, 0F, 1, 1, 1);
        ButtonBack2.setRotationPoint(-2F, 9.1F, 1.7F);
        ButtonBack2.setTextureSize(64, 64);
        ButtonBack2.mirror = true;
        setRotation(ButtonBack2, 0F, 0F, 0F);

        this.bipedBody = new BodyPartHook(this, 16, 16);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0);
        this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.bipedRightArm = new BodyPartHook(this, 40, 16);
        this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0);
        this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);

        this.bipedLeftArm = new BodyPartHook(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0);

        ((BodyPartHook)this.bipedBody).setRender(new BodyPartHook.IPartRenderer() {
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

        ((BodyPartHook)this.bipedLeftArm).setRender(new BodyPartHook.IPartRenderer() {
            @Override
            public void render(float scale) {
                GlStateManager.pushMatrix();
               GlStateManager.translate(-0.36,0,0.01);
                ATGUtils.bindTexture(TEX);
                LACoatArmFront.render(scale);
                LACoatArmTop.render(scale);
                LACoatArmBack.render(scale);
                LACoatArmLeft.render(scale);
                LACoatArmRight.render(scale);
                GlStateManager.popMatrix();
            }
        });

        ((BodyPartHook)this.bipedRightArm).setRender(new BodyPartHook.IPartRenderer() {
            @Override
            public void render(float scale) {
                GlStateManager.pushMatrix();
                ATGUtils.bindTexture(TEX);
                GlStateManager.translate(0.36,-0.13,0);
                RACoatArmFront.render(scale);
                RACoatArmTop.render(scale);
                RACoatArmLeft.render(scale);
                RACoatArmRight.render(scale);
                RACoatArmBack.render(scale);
                GlStateManager.popMatrix();
            }
        });
        

    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
