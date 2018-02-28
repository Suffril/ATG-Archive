package com.lcm.regeneration.client.models;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.util.vector.Vector3f;

import com.lcm.doctorwho.client.models.ItemModelBase;

import lucraft.mods.lucraftcore.util.render.LCModelState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemTransformVec3f;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

public class ModelFobwatchClosed extends ModelBase implements ItemModelBase
{
    ModelRenderer WatchFace;
    ModelRenderer WatchFaceGold1;
    ModelRenderer WatchFaceGold2;
    ModelRenderer WatchFaceGold3;
    ModelRenderer WatchFaceHand1;
    ModelRenderer WatchFaceHand2;
    ModelRenderer WatchBaseTop;
    ModelRenderer WatchBaseBottom;
    ModelRenderer WatchBaseSide1;
    ModelRenderer WatchBaseSide2;
    ModelRenderer WatchLatch;
    ModelRenderer WatchCoverFront;
    ModelRenderer WatchCoverBack;
    ModelRenderer WatchDial;
    ModelRenderer WatchDialTop;
    ModelRenderer WatchFobBase;
    ModelRenderer WatchHandleHold;
    ModelRenderer WatchBackIndent1;
    ModelRenderer WatchBackIndent2;
    ModelRenderer WatchBackIndent3;

    public ModelFobwatchClosed()
    {
        textureWidth = 64;
        textureHeight = 64;

        WatchFace = new ModelRenderer(this, 0, 12);
        WatchFace.addBox(0F, 0F, 0F, 6, 6, 1);
        WatchFace.setRotationPoint(-3F, 17F, 0F);
        WatchFace.setTextureSize(64, 64);
        WatchFace.mirror = true;
        setRotation(WatchFace, 0F, 0F, 0F);
        WatchFaceGold1 = new ModelRenderer(this, 1, 20);
        WatchFaceGold1.addBox(0F, 0F, 0F, 2, 2, 1);
        WatchFaceGold1.setRotationPoint(-1F, 17.6F, -0.3F);
        WatchFaceGold1.setTextureSize(64, 64);
        WatchFaceGold1.mirror = true;
        setRotation(WatchFaceGold1, 0F, 0F, 0F);
        WatchFaceGold2 = new ModelRenderer(this, 8, 20);
        WatchFaceGold2.addBox(0F, 0F, 0F, 1, 1, 1);
        WatchFaceGold2.setRotationPoint(-2.5F, 19.6F, -0.3F);
        WatchFaceGold2.setTextureSize(64, 64);
        WatchFaceGold2.mirror = true;
        setRotation(WatchFaceGold2, 0F, 0F, 0F);
        WatchFaceGold3 = new ModelRenderer(this, 8, 23);
        WatchFaceGold3.addBox(0F, 0F, 0F, 1, 1, 1);
        WatchFaceGold3.setRotationPoint(1.5F, 19.6F, -0.3F);
        WatchFaceGold3.setTextureSize(64, 64);
        WatchFaceGold3.mirror = true;
        setRotation(WatchFaceGold3, 0F, 0F, 0F);
        WatchFaceHand1 = new ModelRenderer(this, 0, 24);
        WatchFaceHand1.addBox(0F, 0F, 0F, 3, 1, 0);
        WatchFaceHand1.setRotationPoint(0F, 19.6F, -0.3F);
        WatchFaceHand1.setTextureSize(64, 64);
        WatchFaceHand1.mirror = true;
        setRotation(WatchFaceHand1, 0F, 0F, 0.5585054F);
        WatchFaceHand2 = new ModelRenderer(this, 0, 26);
        WatchFaceHand2.addBox(0F, 0F, 0F, 2, 1, 0);
        WatchFaceHand2.setRotationPoint(0F, 19.6F, -0.3F);
        WatchFaceHand2.setTextureSize(64, 64);
        WatchFaceHand2.mirror = true;
        setRotation(WatchFaceHand2, 0F, 0F, 1.204277F);
        WatchBaseTop = new ModelRenderer(this, 0, 6);
        WatchBaseTop.addBox(0F, 0F, 0F, 6, 1, 4);
        WatchBaseTop.setRotationPoint(-3F, 16F, -1.5F);
        WatchBaseTop.setTextureSize(64, 64);
        WatchBaseTop.mirror = true;
        setRotation(WatchBaseTop, 0F, 0F, 0F);
        WatchBaseBottom = new ModelRenderer(this, 0, 0);
        WatchBaseBottom.addBox(0F, 0F, 0F, 6, 1, 4);
        WatchBaseBottom.setRotationPoint(-3F, 23F, -1.5F);
        WatchBaseBottom.setTextureSize(64, 64);
        WatchBaseBottom.mirror = true;
        setRotation(WatchBaseBottom, 0F, 0F, 0F);
        WatchBaseSide1 = new ModelRenderer(this, 22, 0);
        WatchBaseSide1.addBox(0F, 0F, 0F, 4, 6, 1);
        WatchBaseSide1.setRotationPoint(-4F, 17F, 2.5F);
        WatchBaseSide1.setTextureSize(64, 64);
        WatchBaseSide1.mirror = true;
        setRotation(WatchBaseSide1, 0F, 1.570796F, 0F);
        WatchBaseSide2 = new ModelRenderer(this, 22, 8);
        WatchBaseSide2.addBox(0F, 0F, 0F, 4, 6, 1);
        WatchBaseSide2.setRotationPoint(3F, 17F, 2.5F);
        WatchBaseSide2.setTextureSize(64, 64);
        WatchBaseSide2.mirror = true;
        setRotation(WatchBaseSide2, 0F, 1.570796F, 0F);
        WatchLatch = new ModelRenderer(this, 15, 27);
        WatchLatch.addBox(0F, 0F, 0F, 2, 1, 1);
        WatchLatch.setRotationPoint(-1F, 22.7F, -2F);
        WatchLatch.setTextureSize(64, 64);
        WatchLatch.mirror = true;
        setRotation(WatchLatch, 0F, 0F, 0F);
        WatchCoverFront = new ModelRenderer(this, 0, 30);
        WatchCoverFront.addBox(0F, 0F, -6F, 6, 1, 6);
        WatchCoverFront.setRotationPoint(-3F, 23F, -1.1F);
        WatchCoverFront.setTextureSize(64, 64);
        WatchCoverFront.mirror = true;
        setRotation(WatchCoverFront, -1.570796F, 0F, 0F);
        WatchCoverBack = new ModelRenderer(this, 15, 19);
        WatchCoverBack.addBox(0F, 0F, 0F, 6, 6, 1);
        WatchCoverBack.setRotationPoint(-3F, 17F, 2F);
        WatchCoverBack.setTextureSize(64, 64);
        WatchCoverBack.mirror = true;
        setRotation(WatchCoverBack, 0F, 0F, 0F);
        WatchDial = new ModelRenderer(this, 22, 27);
        WatchDial.addBox(0F, 0F, 0F, 2, 1, 1);
        WatchDial.setRotationPoint(-1F, 13.9F, 0F);
        WatchDial.setTextureSize(64, 64);
        WatchDial.mirror = true;
        setRotation(WatchDial, 0F, 0F, 0F);
        WatchDialTop = new ModelRenderer(this, 26, 31);
        WatchDialTop.addBox(0F, 0F, 0F, 1, 1, 1);
        WatchDialTop.setRotationPoint(-0.5F, 13.7F, 0F);
        WatchDialTop.setTextureSize(64, 64);
        WatchDialTop.mirror = true;
        setRotation(WatchDialTop, 0F, 0F, 0F);
        WatchFobBase = new ModelRenderer(this, 26, 34);
        WatchFobBase.addBox(0F, 0F, 0F, 1, 1, 1);
        WatchFobBase.setRotationPoint(-0.5F, 15.3F, 0F);
        WatchFobBase.setTextureSize(64, 64);
        WatchFobBase.mirror = true;
        setRotation(WatchFobBase, 0F, 0F, 0F);
        WatchHandleHold = new ModelRenderer(this, 6, 27);
        WatchHandleHold.addBox(0F, 0F, 0F, 3, 1, 1);
        WatchHandleHold.setRotationPoint(-1.5F, 14.3F, 0F);
        WatchHandleHold.setTextureSize(64, 64);
        WatchHandleHold.mirror = true;
        setRotation(WatchHandleHold, 0F, 0F, 0F);
        WatchBackIndent1 = new ModelRenderer(this, 15, 12);
        WatchBackIndent1.addBox(0F, 0F, 0F, 2, 2, 1);
        WatchBackIndent1.setRotationPoint(-1F, 19F, 2.1F);
        WatchBackIndent1.setTextureSize(64, 64);
        WatchBackIndent1.mirror = true;
        setRotation(WatchBackIndent1, 0F, 0F, 0F);
        WatchBackIndent2 = new ModelRenderer(this, 15, 16);
        WatchBackIndent2.addBox(0F, 0F, 0F, 1, 1, 1);
        WatchBackIndent2.setRotationPoint(-2.5F, 20.3F, 2.1F);
        WatchBackIndent2.setTextureSize(64, 64);
        WatchBackIndent2.mirror = true;
        setRotation(WatchBackIndent2, 0F, 0F, 0F);
        WatchBackIndent3 = new ModelRenderer(this, 20, 16);
        WatchBackIndent3.addBox(0F, 0F, 0F, 1, 1, 1);
        WatchBackIndent3.setRotationPoint(1.5F, 21.3F, 2.1F);
        WatchBackIndent3.setTextureSize(64, 64);
        WatchBackIndent3.mirror = true;
        setRotation(WatchBackIndent3, 0F, 0F, 0F);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void renderModel(float scale) {
        WatchFace.render(scale);
        WatchFaceGold1.render(scale);
        WatchFaceGold2.render(scale);
        WatchFaceGold3.render(scale);
        WatchFaceHand1.render(scale);
        WatchFaceHand2.render(scale);
        WatchBaseTop.render(scale);
        WatchBaseBottom.render(scale);
        WatchBaseSide1.render(scale);
        WatchBaseSide2.render(scale);
        WatchLatch.render(scale);
        WatchCoverFront.render(scale);
        WatchCoverBack.render(scale);
        WatchDial.render(scale);
        WatchDialTop.render(scale);
        WatchFobBase.render(scale);
        WatchHandleHold.render(scale);
        WatchBackIndent1.render(scale);
        WatchBackIndent2.render(scale);
        WatchBackIndent3.render(scale);
    }

    @Override
    public IModelState getTransforms() {
        Map<ItemCameraTransforms.TransformType, TRSRTransformation> map = new HashMap<>();
        map.put(ItemCameraTransforms.TransformType.GUI, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(1F, 1F, 0F), new Vector3f(0.5F, 0.5F, 0), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.GROUND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(-90F, 0F, 0F), new Vector3f(0.5F, 0.3F, 0.5F), new Vector3f(0.5F, 0.5F, 0.5F))));    map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -120F, 0F), new Vector3f(1F, 0.3F, 0F), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -110, 0F), new Vector3f(1.4F, 0.7F, 0.9F), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, 0.5F), new Vector3f(0.7F, 0.7F, 0.7F))));
        map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, -0.2F), new Vector3f(0.7F, 0.7F, 0.7F))));
        map.put(ItemCameraTransforms.TransformType.FIXED, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(0F, 0F, 0F), new Vector3f(0.5F, 0.5F, 0.5F), new Vector3f(1F, 1F, 1F))));
        return new LCModelState(map);
    }
}
