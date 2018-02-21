package com.lcm.doctorwho.client.models.items;

import com.lcm.doctorwho.client.models.ItemModelBase;
import lucraft.mods.lucraftcore.util.render.LCModelState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemTransformVec3f;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import org.lwjgl.util.vector.Vector3f;

import java.util.HashMap;
import java.util.Map;

public class ModelFirstDoctorCane extends ModelBase implements ItemModelBase
{
    //fields
    ModelRenderer Handle1;
    ModelRenderer Handle2;
    ModelRenderer Silver1;
    ModelRenderer Silver2;
    ModelRenderer CaneTop;
    ModelRenderer CaneCurve1;
    ModelRenderer CaneCurve2;
    ModelRenderer CaneCurve3;
    ModelRenderer CaneCurve4;
    ModelRenderer CaneCurve5;
    ModelRenderer CaneCurve6;
    ModelRenderer CaneCurve7;
    ModelRenderer CaneCurve8;
    ModelRenderer CaneBase;

    public ModelFirstDoctorCane()
    {
        textureWidth = 64;
        textureHeight = 64;

        Handle1 = new ModelRenderer(this, 13, 1);
        Handle1.addBox(0F, 0F, 0F, 6, 2, 2);
        Handle1.setRotationPoint(0F, 0F, 0F);
        Handle1.setTextureSize(64, 64);
        Handle1.mirror = true;
        setRotation(Handle1, 0F, 0F, 0F);
        Handle2 = new ModelRenderer(this, 30, 1);
        Handle2.addBox(0F, 0F, 0F, 2, 2, 2);
        Handle2.setRotationPoint(-0.5F, 1F, 0F);
        Handle2.setTextureSize(64, 64);
        Handle2.mirror = true;
        setRotation(Handle2, 0F, 0F, 0F);
        Silver1 = new ModelRenderer(this, 13, 6);
        Silver1.addBox(0F, 0F, 0F, 2, 3, 2);
        Silver1.setRotationPoint(-0.7F, 3F, 0.2F);
        Silver1.setTextureSize(64, 64);
        Silver1.mirror = true;
        setRotation(Silver1, 0F, 0F, 0F);
        Silver2 = new ModelRenderer(this, 22, 6);
        Silver2.addBox(0F, 0F, 0F, 2, 3, 2);
        Silver2.setRotationPoint(-0.4F, 3F, -0.2F);
        Silver2.setTextureSize(64, 64);
        Silver2.mirror = true;
        setRotation(Silver2, 0F, 0F, 0F);
        CaneTop = new ModelRenderer(this, 13, 13);
        CaneTop.addBox(0F, 0F, 0F, 2, 1, 2);
        CaneTop.setRotationPoint(-0.5F, 6F, 0F);
        CaneTop.setTextureSize(64, 64);
        CaneTop.mirror = true;
        setRotation(CaneTop, 0F, 0F, 0F);
        CaneCurve1 = new ModelRenderer(this, 30, 13);
        CaneCurve1.addBox(-2F, 0F, 0F, 2, 1, 2);
        CaneCurve1.setRotationPoint(0.8F, 6.5F, 0F);
        CaneCurve1.setTextureSize(64, 64);
        CaneCurve1.mirror = true;
        setRotation(CaneCurve1, 0F, 0F, -0.3490659F);
        CaneCurve2 = new ModelRenderer(this, 30, 17);
        CaneCurve2.addBox(0F, 0F, 0F, 2, 1, 2);
        CaneCurve2.setRotationPoint(-0.6F, 7.5F, 0F);
        CaneCurve2.setTextureSize(64, 64);
        CaneCurve2.mirror = true;
        setRotation(CaneCurve2, 0F, 0F, 0.3490659F);
        CaneCurve3 = new ModelRenderer(this, 30, 21);
        CaneCurve3.addBox(-2F, 0F, 0F, 2, 1, 2);
        CaneCurve3.setRotationPoint(0.8F, 8.5F, 0F);
        CaneCurve3.setTextureSize(64, 64);
        CaneCurve3.mirror = true;
        setRotation(CaneCurve3, 0F, 0F, -0.3490659F);
        CaneCurve4 = new ModelRenderer(this, 30, 25);
        CaneCurve4.addBox(0F, 0F, 0F, 2, 1, 2);
        CaneCurve4.setRotationPoint(-0.6F, 9.5F, 0F);
        CaneCurve4.setTextureSize(64, 64);
        CaneCurve4.mirror = true;
        setRotation(CaneCurve4, 0F, 0F, 0.3490659F);
        CaneCurve5 = new ModelRenderer(this, 39, 13);
        CaneCurve5.addBox(-2F, 0F, 0F, 2, 1, 2);
        CaneCurve5.setRotationPoint(0.8F, 10.5F, 0F);
        CaneCurve5.setTextureSize(64, 64);
        CaneCurve5.mirror = true;
        setRotation(CaneCurve5, 0F, 0F, -0.3490659F);
        CaneCurve6 = new ModelRenderer(this, 39, 17);
        CaneCurve6.addBox(0F, 0F, 0F, 2, 1, 2);
        CaneCurve6.setRotationPoint(-0.6F, 11.5F, 0F);
        CaneCurve6.setTextureSize(64, 64);
        CaneCurve6.mirror = true;
        setRotation(CaneCurve6, 0F, 0F, 0.3490659F);
        CaneCurve7 = new ModelRenderer(this, 39, 21);
        CaneCurve7.addBox(-2F, 0F, 0F, 2, 1, 2);
        CaneCurve7.setRotationPoint(0.8F, 12.5F, 0F);
        CaneCurve7.setTextureSize(64, 64);
        CaneCurve7.mirror = true;
        setRotation(CaneCurve7, 0F, 0F, -0.3490659F);
        CaneCurve8 = new ModelRenderer(this, 39, 25);
        CaneCurve8.addBox(0F, 0F, 0F, 2, 1, 2);
        CaneCurve8.setRotationPoint(-0.6F, 13.5F, 0F);
        CaneCurve8.setTextureSize(64, 64);
        CaneCurve8.mirror = true;
        setRotation(CaneCurve8, 0F, 0F, 0.3490659F);
        CaneBase = new ModelRenderer(this, 13, 17);
        CaneBase.addBox(0F, 0F, 0F, 2, 9, 2);
        CaneBase.setRotationPoint(-1F, 14.8F, 0F);
        CaneBase.setTextureSize(64, 64);
        CaneBase.mirror = true;
        setRotation(CaneBase, 0F, 0F, 0F);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    @Override
    public void renderModel(float scale) {
        Handle1.render(scale);
        Handle2.render(scale);
        Silver1.render(scale);
        Silver2.render(scale);
        CaneTop.render(scale);
        CaneCurve1.render(scale);
        CaneCurve2.render(scale);
        CaneCurve3.render(scale);
        CaneCurve4.render(scale);
        CaneCurve5.render(scale);
        CaneCurve6.render(scale);
        CaneCurve7.render(scale);
        CaneCurve8.render(scale);
        CaneBase.render(scale);
    }

    @Override
    public IModelState getTransforms() {
        Map map = new HashMap<ItemCameraTransforms.TransformType, TRSRTransformation>();
        map.put(ItemCameraTransforms.TransformType.GUI, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(0F, 1.0F, 0F), new Vector3f(0.5F, 0.5F, 0), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.GROUND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(-90F, 0F, 0F), new Vector3f(0.5F, 0.3F, 0.5F), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -120F, 0F), new Vector3f(1F, 0.3F, 0F), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -110, 0F), new Vector3f(1.4F, 0.7F, 0.9F), new Vector3f(1F, 1F, 1F))));
        map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, 0.5F), new Vector3f(0.7F, 0.7F, 0.7F))));
        map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, -0.2F), new Vector3f(0.7F, 0.7F, 0.7F))));
        map.put(ItemCameraTransforms.TransformType.FIXED, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(0F, 0F, 0F), new Vector3f(0.5F, 0.5F, 0.5F), new Vector3f(1F, 1F, 1F))));
        return new LCModelState(map);
    }
}
