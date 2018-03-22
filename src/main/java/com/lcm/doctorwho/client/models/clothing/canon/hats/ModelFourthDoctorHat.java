package com.lcm.doctorwho.client.models.clothing.canon.hats;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.BodyPartHook;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class ModelFourthDoctorHat extends ModelBiped
{
    private ResourceLocation TEX = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/models/clothing/fourth_doc_hat.png");

    public ModelFourthDoctorHat()
    {
        textureWidth = 128;
        textureHeight = 128;

        ArrayList<ModelRenderer> boxes = new ArrayList<>();

        ModelRenderer HatBase1 = new ModelRenderer(this, 0, 55);
        HatBase1.addBox(0F, 0F, 0F, 14, 1, 8);
        HatBase1.setRotationPoint(-7F, -8F, -4F);
        HatBase1.setTextureSize(128, 128);
       ATGUtils.setRotation(HatBase1, 0F, 0F, 0F);
        ModelRenderer HatBase2 = new ModelRenderer(this, 0, 39);
        HatBase2.addBox(0F, 0F, 0F, 8, 1, 14);
        HatBase2.setRotationPoint(-4F, -8F, -7F);
        HatBase2.setTextureSize(128, 128);
       ATGUtils.setRotation(HatBase2, 0F, 0F, 0F);
        ModelRenderer HatBase3 = new ModelRenderer(this, 0, 25);
        HatBase3.addBox(0F, 0F, 0F, 1, 1, 12);
        HatBase3.setRotationPoint(-5F, -8F, -6F);
        HatBase3.setTextureSize(128, 128);
       ATGUtils.setRotation(HatBase3, 0F, 0F, 0F);
        ModelRenderer HatBase4 = new ModelRenderer(this, 0, 11);
        HatBase4.addBox(0F, 0F, 0F, 1, 1, 12);
        HatBase4.setRotationPoint(4F, -8F, -6F);
        HatBase4.setTextureSize(128, 128);
       ATGUtils.setRotation(HatBase4, 0F, 0F, 0F);
        ModelRenderer HatBase5 = new ModelRenderer(this, 38, 36);
        HatBase5.addBox(0F, 0F, 0F, 12, 1, 1);
        HatBase5.setRotationPoint(-6F, -8F, -5F);
        HatBase5.setTextureSize(128, 128);
       ATGUtils.setRotation(HatBase5, 0F, 0F, 0F);
        ModelRenderer HatBase6 = new ModelRenderer(this, 38, 33);
        HatBase6.addBox(0F, 0F, 0F, 12, 1, 1);
        HatBase6.setRotationPoint(-6F, -8F, 4F);
        HatBase6.setTextureSize(128, 128);
       ATGUtils.setRotation(HatBase6, 0F, 0F, 0F);
        ModelRenderer HatMiddle1 = new ModelRenderer(this, 32, 0);
        HatMiddle1.addBox(0F, 0F, 0F, 8, 4, 8);
        HatMiddle1.setRotationPoint(-4F, -11.5F, -4F);
        HatMiddle1.setTextureSize(128, 128);
       ATGUtils.setRotation(HatMiddle1, 0F, 0F, 0F);
        ModelRenderer HatMiddle2 = new ModelRenderer(this, 46, 45);
        HatMiddle2.addBox(0F, 0F, 0F, 1, 1, 8);
        HatMiddle2.setRotationPoint(4F, -8.5F, -4F);
        HatMiddle2.setTextureSize(128, 128);
       ATGUtils.setRotation(HatMiddle2, 0F, 0F, 0.7853982F);
        ModelRenderer HatMiddle3 = new ModelRenderer(this, 46, 55);
        HatMiddle3.addBox(0F, 0F, 0F, 1, 1, 8);
        HatMiddle3.setRotationPoint(-4.5F, -8F, -4F);
        HatMiddle3.setTextureSize(128, 128);
       ATGUtils.setRotation(HatMiddle3, 0F, 0F, -0.7853982F);
        ModelRenderer HatMiddle4 = new ModelRenderer(this, 46, 42);
        HatMiddle4.addBox(0F, 0F, 0F, 8, 1, 1);
        HatMiddle4.setRotationPoint(-4F, -8F, -4.5F);
        HatMiddle4.setTextureSize(128, 128);
       ATGUtils.setRotation(HatMiddle4, 0.7853982F, 0F, 0F);
        ModelRenderer HatMiddle5 = new ModelRenderer(this, 46, 39);
        HatMiddle5.addBox(0F, 0F, 0F, 8, 1, 1);
        HatMiddle5.setRotationPoint(-4F, -8.5F, 4F);
        HatMiddle5.setTextureSize(128, 128);
       ATGUtils.setRotation(HatMiddle5, -0.7853982F, 0F, 0F);
        ModelRenderer HatStrap1 = new ModelRenderer(this, 32, 13);
        HatStrap1.addBox(0F, 0F, 0F, 8, 1, 8);
        HatStrap1.setRotationPoint(-4.1F, -10F, -4.1F);
        HatStrap1.setTextureSize(128, 128);
       ATGUtils.setRotation(HatStrap1, 0F, 0F, 0F);
        ModelRenderer HatStrap2 = new ModelRenderer(this, 32, 23);
        HatStrap2.addBox(0F, 0F, 0F, 8, 1, 8);
        HatStrap2.setRotationPoint(-3.9F, -10F, -3.9F);
        HatStrap2.setTextureSize(128, 128);
       ATGUtils.setRotation(HatStrap2, 0F, 0F, 0F);
        ModelRenderer HatBow1 = new ModelRenderer(this, 65, 0);
        HatBow1.addBox(0F, 0F, 0F, 1, 1, 5);
        HatBow1.setRotationPoint(3.3F, -10F, -2.5F);
        HatBow1.setTextureSize(128, 128);
       ATGUtils.setRotation(HatBow1, 0F, 0F, 0F);
        ModelRenderer HatBow2 = new ModelRenderer(this, 65, 7);
        HatBow2.addBox(0F, 0F, 0F, 1, 1, 2);
        HatBow2.setRotationPoint(3.4F, -10F, -1F);
        HatBow2.setTextureSize(128, 128);
       ATGUtils.setRotation(HatBow2, 0F, 0F, 0F);
        ModelRenderer HatTop1 = new ModelRenderer(this, 65, 12);
        HatTop1.addBox(0F, 0F, 0F, 2, 1, 8);
        HatTop1.setRotationPoint(-4F, -12.4F, -4F);
        HatTop1.setTextureSize(128, 128);
       ATGUtils.setRotation(HatTop1, 0F, 0F, 0F);
        ModelRenderer HatTop2 = new ModelRenderer(this, 65, 40);
        HatTop2.addBox(0F, 0F, 0F, 8, 2, 2);
        HatTop2.setRotationPoint(-4F, -12.8F, 2F);
        HatTop2.setTextureSize(128, 128);
       ATGUtils.setRotation(HatTop2, 0F, 0F, 0F);
        ModelRenderer HatTop3 = new ModelRenderer(this, 65, 30);
        HatTop3.addBox(0F, 0F, 0F, 2, 1, 8);
        HatTop3.setRotationPoint(2F, -12.4F, -4F);
        HatTop3.setTextureSize(128, 128);
       ATGUtils.setRotation(HatTop3, 0F, 0F, 0F);
        ModelRenderer HatTop4 = new ModelRenderer(this, 65, 22);
        HatTop4.addBox(0F, 0F, 0F, 4, 1, 6);
        HatTop4.setRotationPoint(-2F, -12F, -4F);
        HatTop4.setTextureSize(128, 128);
       ATGUtils.setRotation(HatTop4, 0F, 0F, 0F);

        boxes.add(HatBase1);
        boxes.add(HatBase2);
        boxes.add(HatBase3);
        boxes.add(HatBase4);
        boxes.add(HatBase5);
        boxes.add(HatBase6);
        boxes.add(HatMiddle1);
        boxes.add(HatMiddle2);
        boxes.add(HatMiddle3);
        boxes.add(HatMiddle4);
        boxes.add(HatMiddle5);
        boxes.add(HatStrap1);
        boxes.add(HatStrap2);
        boxes.add(HatBow1);
        boxes.add(HatBow2);
        boxes.add(HatTop1);
        boxes.add(HatTop2);
        boxes.add(HatTop3);
        boxes.add(HatTop4);

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
            ATGUtils.bindTexture(TEX);
            for (ModelRenderer box : boxes)
                box.render(scale);
            GlStateManager.popMatrix();
        });

    }
}
