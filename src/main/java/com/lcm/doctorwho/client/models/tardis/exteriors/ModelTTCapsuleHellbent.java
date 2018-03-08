package com.lcm.doctorwho.client.models.tardis.exteriors;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.ITardisModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.ResourceLocation;

public class ModelTTCapsuleHellbent extends ModelBase implements ITardisModel {

    private ResourceLocation TEX = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/models/tardis/tardis_hellbent.png");
    private boolean doorOpen = false;
    private boolean lampOn;

    ModelRenderer MS1;
    ModelRenderer MS2;
    ModelRenderer MS3;
    ModelRenderer MS4;
    ModelRenderer MS5;
    ModelRenderer MS6;
    ModelRenderer MS7;
    ModelRenderer MS8;
    ModelRenderer MS9;
    ModelRenderer MS10;
    ModelRenderer MS11;
    ModelRenderer MS12;
    ModelRenderer MS13;
    ModelRenderer PO1;
    ModelRenderer PO2;
    ModelRenderer PO3;
    ModelRenderer PO4;
    ModelRenderer PO5;
    ModelRenderer PO6;
    ModelRenderer PO7;
    ModelRenderer P08;
    ModelRenderer PO9;
    ModelRenderer PO10;
    ModelRenderer PO11;
    ModelRenderer PO12;
    ModelRenderer DoorLeft;
    ModelRenderer DoorRight;
    ModelRenderer Void1;
    ModelRenderer Void2;
    ModelRenderer Void3;

    public ModelTTCapsuleHellbent()
    {
        textureWidth = 256;
        textureHeight = 256;

        MS1 = new ModelRenderer(this, 65, 60);
        MS1.addBox(-8F, -15F, -9F, 1, 35, 1);
        MS1.setRotationPoint(0F, 0F, 0F);
        MS1.setTextureSize(256, 256);
        MS1.mirror = true;
        setRotation(MS1, 0F, 0F, 0F);
        MS2 = new ModelRenderer(this, 65, 60);
        MS2.addBox(7F, -15F, -9F, 1, 35, 1);
        MS2.setRotationPoint(0F, 0F, 0F);
        MS2.setTextureSize(256, 256);
        MS2.mirror = true;
        setRotation(MS2, 0F, 0F, 0F);
        MS3 = new ModelRenderer(this, 0, 111);
        MS3.addBox(10F, -15F, -3F, 1, 35, 6);
        MS3.setRotationPoint(0F, 0F, 0F);
        MS3.setTextureSize(256, 256);
        MS3.mirror = true;
        setRotation(MS3, 0F, 0F, 0F);
        MS4 = new ModelRenderer(this, 31, 191);
        MS4.addBox(-3F, -15F, 10F, 6, 35, 1);
        MS4.setRotationPoint(0F, 0F, 0F);
        MS4.setTextureSize(256, 256);
        MS4.mirror = true;
        setRotation(MS4, 0F, 0F, 0F);
        MS5 = new ModelRenderer(this, 0, 64);
        MS5.addBox(9F, -15F, -6F, 1, 35, 12);
        MS5.setRotationPoint(0F, 0F, 0F);
        MS5.setTextureSize(256, 256);
        MS5.mirror = true;
        setRotation(MS5, 0F, 0F, 0F);
        MS6 = new ModelRenderer(this, 0, 111);
        MS6.addBox(-11F, -15F, -3F, 1, 35, 6);
        MS6.setRotationPoint(0F, 0F, 0F);
        MS6.setTextureSize(256, 256);
        MS6.mirror = true;
        setRotation(MS6, 0F, 0F, 0F);
        MS7 = new ModelRenderer(this, 0, 64);
        MS7.addBox(-10F, -15F, -6F, 1, 35, 12);
        MS7.setRotationPoint(0F, 0F, 0F);
        MS7.setTextureSize(256, 256);
        MS7.mirror = true;
        setRotation(MS7, 0F, 0F, 0F);
        MS8 = new ModelRenderer(this, 0, 14);
        MS8.addBox(0F, -15F, 0F, 1, 35, 2);
        MS8.setRotationPoint(7F, 0F, -9F);
        MS8.setTextureSize(256, 256);
        MS8.mirror = true;
        setRotation(MS8, 0F, -0.3490659F, 0F);
        MS9 = new ModelRenderer(this, 28, 59);
        MS9.addBox(8F, -15F, -8F, 1, 35, 16);
        MS9.setRotationPoint(0F, 0F, 0F);
        MS9.setTextureSize(256, 256);
        MS9.mirror = true;
        setRotation(MS9, 0F, 0F, 0F);
        MS10 = new ModelRenderer(this, 0, 153);
        MS10.addBox(-8F, -15F, 8F, 16, 35, 1);
        MS10.setRotationPoint(0F, 0F, 0F);
        MS10.setTextureSize(256, 256);
        MS10.mirror = true;
        setRotation(MS10, 0F, 0F, 0F);
        MS11 = new ModelRenderer(this, 0, 191);
        MS11.addBox(-6F, -15F, 9F, 12, 35, 1);
        MS11.setRotationPoint(0F, 0F, 0F);
        MS11.setTextureSize(256, 256);
        MS11.mirror = true;
        setRotation(MS11, 0F, 0F, 0F);
        MS12 = new ModelRenderer(this, 28, 59);
        MS12.addBox(-9F, -15F, -8F, 1, 35, 16);
        MS12.setRotationPoint(0F, 0F, 0F);
        MS12.setTextureSize(256, 256);
        MS12.mirror = true;
        setRotation(MS12, 0F, 0F, 0F);
        MS13 = new ModelRenderer(this, 0, 14);
        MS13.addBox(-1F, -15F, 0F, 1, 35, 2);
        MS13.setRotationPoint(-7F, 0F, -9F);
        MS13.setTextureSize(256, 256);
        MS13.mirror = true;
        setRotation(MS13, 0F, 0.3490659F, 0F);
        PO1 = new ModelRenderer(this, 122, 78);
        PO1.addBox(-10.5F, 20F, -6.5F, 21, 4, 13);
        PO1.setRotationPoint(0F, 0F, 0F);
        PO1.setTextureSize(256, 256);
        PO1.mirror = true;
        setRotation(PO1, 0F, 0F, 0F);
        PO2 = new ModelRenderer(this, 0, 0);
        PO2.addBox(-11.5F, 20F, -3.5F, 23, 4, 7);
        PO2.setRotationPoint(0F, 0F, 0F);
        PO2.setTextureSize(256, 256);
        PO2.mirror = true;
        setRotation(PO2, 0F, 0F, 0F);
        PO3 = new ModelRenderer(this, 60, 0);
        PO3.addBox(-3.5F, 20F, -11.5F, 7, 4, 23);
        PO3.setRotationPoint(0F, 0F, 0F);
        PO3.setTextureSize(256, 256);
        PO3.mirror = true;
        setRotation(PO3, 0F, 0F, 0F);
        PO4 = new ModelRenderer(this, 120, 0);
        PO4.addBox(-6.5F, 20F, -10.5F, 13, 4, 21);
        PO4.setRotationPoint(0F, 0F, 0F);
        PO4.setTextureSize(256, 256);
        PO4.mirror = true;
        setRotation(PO4, 0F, 0F, 0F);
        PO5 = new ModelRenderer(this, 120, 28);
        PO5.addBox(-8.5F, 20F, -9.5F, 17, 4, 19);
        PO5.setRotationPoint(0F, 0F, 0F);
        PO5.setTextureSize(256, 256);
        PO5.mirror = true;
        setRotation(PO5, 0F, 0F, 0F);
        PO6 = new ModelRenderer(this, 121, 54);
        PO6.addBox(-9.5F, 20F, -8.5F, 19, 4, 17);
        PO6.setRotationPoint(0F, 0F, 0F);
        PO6.setTextureSize(256, 256);
        PO6.mirror = true;
        setRotation(PO6, 0F, 0F, 0F);
        PO7 = new ModelRenderer(this, 60, 0);
        PO7.addBox(-3.5F, -22F, -11.5F, 7, 7, 23);
        PO7.setRotationPoint(0F, 0F, 0F);
        PO7.setTextureSize(256, 256);
        PO7.mirror = true;
        setRotation(PO7, 0F, 0F, 0F);
        P08 = new ModelRenderer(this, 120, 0);
        P08.addBox(-6.5F, -22F, -10.5F, 13, 7, 21);
        P08.setRotationPoint(0F, 0F, 0F);
        P08.setTextureSize(256, 256);
        P08.mirror = true;
        setRotation(P08, 0F, 0F, 0F);
        PO9 = new ModelRenderer(this, 122, 78);
        PO9.addBox(-10.5F, -22F, -6.5F, 21, 7, 13);
        PO9.setRotationPoint(0F, 0F, 0F);
        PO9.setTextureSize(256, 256);
        PO9.mirror = true;
        setRotation(PO9, 0F, 0F, 0F);
        PO10 = new ModelRenderer(this, 121, 54);
        PO10.addBox(-9.5F, -22F, -8.5F, 19, 7, 17);
        PO10.setRotationPoint(0F, 0F, 0F);
        PO10.setTextureSize(256, 256);
        PO10.mirror = true;
        setRotation(PO10, 0F, 0F, 0F);
        PO11 = new ModelRenderer(this, 120, 28);
        PO11.addBox(-8.5F, -22F, -9.5F, 17, 7, 19);
        PO11.setRotationPoint(0F, 0F, 0F);
        PO11.setTextureSize(256, 256);
        PO11.mirror = true;
        setRotation(PO11, 0F, 0F, 0F);
        PO12 = new ModelRenderer(this, 0, 0);
        PO12.addBox(-11.5F, -22F, -3.5F, 23, 7, 7);
        PO12.setRotationPoint(0F, 0F, 0F);
        PO12.setTextureSize(256, 256);
        PO12.mirror = true;
        setRotation(PO12, 0F, 0F, 0F);
        DoorLeft = new ModelRenderer(this, 19, 114);
        DoorLeft.addBox(0F, -15F, 0F, 7, 35, 1);
        DoorLeft.setRotationPoint(-7F, 0F, -8F);
        DoorLeft.setTextureSize(256, 256);
        DoorLeft.mirror = true;
        setRotation(DoorLeft, 0F, 0F, 0F);
        DoorRight = new ModelRenderer(this, 19, 114);
        DoorRight.addBox(-7F, -15F, 0F, 7, 35, 1);
        DoorRight.setRotationPoint(7F, 0F, -8F);
        DoorRight.setTextureSize(256, 256);
        DoorRight.mirror = true;
        setRotation(DoorRight, 0F, 0F, 0F);
        DoorRight.mirror = false;
        Void1 = new ModelRenderer(this, 38, 115);
        Void1.addBox(0F, -15F, 0F, 5, 35, 1);
        Void1.setRotationPoint(5F, 0F, 0F);
        Void1.setTextureSize(256, 256);
        Void1.mirror = true;
        setRotation(Void1, 0F, 0.7853982F, 0F);
        Void2 = new ModelRenderer(this, 54, 113);
        Void2.addBox(-5F, -15F, 0F, 10, 35, 1);
        Void2.setRotationPoint(0F, 0F, 0F);
        Void2.setTextureSize(256, 256);
        Void2.mirror = true;
        setRotation(Void2, 0F, 0F, 0F);
        Void3 = new ModelRenderer(this, 38, 115);
        Void3.addBox(-5F, -15F, 0F, 5, 35, 1);
        Void3.setRotationPoint(-5F, 0F, 0F);
        Void3.setTextureSize(256, 256);
        Void3.mirror = true;
        setRotation(Void3, 0F, -0.7853982F, 0F);
    }



    @Override
    public void renderRightDoor(float scale) {
        GlStateManager.pushMatrix();

        if(isDoorOpen()) {
            GlStateManager.translate(0.4F, 0.0F, 0.1F);
            GlStateManager.rotate(40, 0.0F, 1.0F, 0.0F);
        }
        DoorRight.render(scale);
        GlStateManager.popMatrix();
    }

    @Override
    public void renderLeftDoor(float scale) {
        GlStateManager.pushMatrix();

        if(isDoorOpen()) {
            GlStateManager.translate(-0.4F, 0.0F, 0.1F);
            GlStateManager.rotate(-40, 0.0F, 1.0F, 0.0F);
        }
        DoorLeft.render(scale);
        GlStateManager.popMatrix();
    }

    @Override
    public void renderShell(float scale) {
       //Main
        MS1.render(scale);
        MS2.render(scale);
        MS3.render(scale);
        MS4.render(scale);
        MS5.render(scale);
        MS6.render(scale);
        MS7.render(scale);
        MS8.render(scale);
        MS9.render(scale);
        MS10.render(scale);
        MS11.render(scale);
        MS12.render(scale);
        MS13.render(scale);

        //base

        PO1.render(scale);
        PO2.render(scale);
        PO3.render(scale);
        PO4.render(scale);
        PO5.render(scale);
        PO6.render(scale);
        PO7.render(scale);
        P08.render(scale);
        PO9.render(scale);
        PO10.render(scale);
        PO11.render(scale);
        PO12.render(scale);


        Void1.render(scale);
        Void2.render(scale);
        Void3.render(scale);

    }

    @Override
    public void renderLamp(float scale) {

    }

    @Override
    public void renderText(float scale) {

    }

    @Override
    public void other(float scale) {

    }

    @Override
    public void renderAll(float scale) {
        renderLamp(scale);

        RenderHelper.enableStandardItemLighting();
        renderRightDoor(scale);
        renderLeftDoor(scale);
        renderShell(scale);
        renderText(scale);
        other(scale);
    }

    @Override
    public boolean isDoorOpen() {
        return doorOpen;
    }

    @Override
    public boolean isLampOn() {
        return lampOn;
    }

    @Override
    public void setLampOn(boolean on) {
        lampOn = on;
    }

    @Override
    public void setDoorOpen(boolean open) {
        doorOpen = open;
    }

    @Override
    public ResourceLocation getTexture() {
        return TEX;
    }
    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
