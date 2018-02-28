package com.lcm.doctorwho.obsolete;

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

//FIXME deprecation is bad
public class ModelTest extends ModelBase implements ItemModelBase {
	// fields
	ModelRenderer Wall;
	
	public ModelTest() {
		textureWidth = 140;
		textureHeight = 128;
		
		Wall = new ModelRenderer(this, 0, 20);
		Wall.addBox(0F, 0F, 0F, 58, 68, 1);
		Wall.setRotationPoint(-36F, -44F, 7F);
		Wall.setTextureSize(140, 128);
		Wall.mirror = true;
		setRotation(Wall, 0F, 0F, 0F);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void renderModel(float scale) {
		Wall.render(scale);
	}
	
	@Override
	public IModelState getTransforms() {
		Map<ItemCameraTransforms.TransformType, TRSRTransformation> map = new HashMap<>();
		map.put(ItemCameraTransforms.TransformType.GUI, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(0F, 0F, 0F), new Vector3f(0.5F, 0.5F, 0), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.GROUND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(-90F, 0F, 0F), new Vector3f(0.5F, 0.3F, 0.5F), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -110F, 0F), new Vector3f(1F, 0.7F, 0F), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -110, 0F), new Vector3f(1.4F, 0.7F, 0.9F), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, 0.5F), new Vector3f(0.7F, 0.7F, 0.7F))));
		map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, -0.2F), new Vector3f(0.7F, 0.7F, 0.7F))));
		map.put(ItemCameraTransforms.TransformType.FIXED, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(0F, 0F, 0F), new Vector3f(0.5F, 0.5F, 0.5F), new Vector3f(1F, 1F, 1F))));
		return new LCModelState(map);
	}
}
