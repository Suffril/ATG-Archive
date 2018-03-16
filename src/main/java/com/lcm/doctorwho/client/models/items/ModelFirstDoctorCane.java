package com.lcm.doctorwho.client.models.items;

import com.lcm.doctorwho.client.models.interfaces.ItemModelBase;
import com.lcm.doctorwho.utils.ATGUtils;
import lucraft.mods.lucraftcore.util.render.LCModelState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemTransformVec3f;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModelFirstDoctorCane extends ModelBase implements ItemModelBase {

	private ArrayList<ModelRenderer> boxes = new ArrayList<>();

	public ModelFirstDoctorCane() {
		textureWidth = 64;
		textureHeight = 64;

		ModelRenderer handle1 = new ModelRenderer(this, 13, 1);
		handle1.addBox(0F, 0F, 0F, 6, 2, 2);
		boxes.add(handle1);

		ModelRenderer handle2 = new ModelRenderer(this, 30, 1);
		handle2.addBox(0F, 0F, 0F, 2, 2, 2);
		handle2.setRotationPoint(-0.5F, 1F, 0F);
		boxes.add(handle2);

		ModelRenderer silver1 = new ModelRenderer(this, 13, 6);
		silver1.addBox(0F, 0F, 0F, 2, 3, 2);
		silver1.setRotationPoint(-0.7F, 3F, 0.2F);
		boxes.add(silver1);

		ModelRenderer silver2 = new ModelRenderer(this, 22, 6);
		silver2.addBox(0F, 0F, 0F, 2, 3, 2);
		silver2.setRotationPoint(-0.4F, 3F, -0.2F);
		boxes.add(silver2);

		ModelRenderer caneTop = new ModelRenderer(this, 13, 13);
		caneTop.addBox(0F, 0F, 0F, 2, 1, 2);
		caneTop.setRotationPoint(-0.5F, 6F, 0F);
		boxes.add(caneTop);

		ModelRenderer caneCurve1 = new ModelRenderer(this, 30, 13);
		caneCurve1.addBox(-2F, 0F, 0F, 2, 1, 2);
		caneCurve1.setRotationPoint(0.8F, 6.5F, 0F);
		ATGUtils.setRotation(caneCurve1, 0F, 0F, -0.3490659F);
		boxes.add(caneCurve1);

		ModelRenderer caneCurve2 = new ModelRenderer(this, 30, 17);
		caneCurve2.addBox(0F, 0F, 0F, 2, 1, 2);
		caneCurve2.setRotationPoint(-0.6F, 7.5F, 0F);
		ATGUtils.setRotation(caneCurve2, 0F, 0F, 0.3490659F);
		boxes.add(caneCurve2);

		ModelRenderer caneCurve3 = new ModelRenderer(this, 30, 21);
		caneCurve3.addBox(-2F, 0F, 0F, 2, 1, 2);
		caneCurve3.setRotationPoint(0.8F, 8.5F, 0F);
		ATGUtils.setRotation(caneCurve3, 0F, 0F, -0.3490659F);
		boxes.add(caneCurve3);

		ModelRenderer caneCurve4 = new ModelRenderer(this, 30, 25);
		caneCurve4.addBox(0F, 0F, 0F, 2, 1, 2);
		caneCurve4.setRotationPoint(-0.6F, 9.5F, 0F);
		ATGUtils.setRotation(caneCurve4, 0F, 0F, 0.3490659F);
		boxes.add(caneCurve4);

		ModelRenderer caneCurve5 = new ModelRenderer(this, 39, 13);
		caneCurve5.addBox(-2F, 0F, 0F, 2, 1, 2);
		caneCurve5.setRotationPoint(0.8F, 10.5F, 0F);
		ATGUtils.setRotation(caneCurve5, 0F, 0F, -0.3490659F);
		boxes.add(caneCurve5);

		ModelRenderer caneCurve6 = new ModelRenderer(this, 39, 17);
		caneCurve6.addBox(0F, 0F, 0F, 2, 1, 2);
		caneCurve6.setRotationPoint(-0.6F, 11.5F, 0F);
		ATGUtils.setRotation(caneCurve6, 0F, 0F, 0.3490659F);
		boxes.add(caneCurve6);

		ModelRenderer caneCurve7 = new ModelRenderer(this, 39, 21);
		caneCurve7.addBox(-2F, 0F, 0F, 2, 1, 2);
		caneCurve7.setRotationPoint(0.8F, 12.5F, 0F);
		ATGUtils.setRotation(caneCurve7, 0F, 0F, -0.3490659F);
		boxes.add(caneCurve7);

		ModelRenderer caneCurve8 = new ModelRenderer(this, 39, 25);
		caneCurve8.addBox(0F, 0F, 0F, 2, 1, 2);
		caneCurve8.setRotationPoint(-0.6F, 13.5F, 0F);
		ATGUtils.setRotation(caneCurve8, 0F, 0F, 0.3490659F);
		boxes.add(caneCurve8);

		ModelRenderer caneBase = new ModelRenderer(this, 13, 17);
		caneBase.addBox(0F, 0F, 0F, 2, 9, 2);
		caneBase.setRotationPoint(-1F, 14.8F, 0F);
		boxes.add(caneBase);
	}

	@Override public void renderModel(float scale) {
		for (ModelRenderer box : boxes)
			box.render(scale);
	}

	@Override public IModelState getTransforms() {
		Map<ItemCameraTransforms.TransformType, TRSRTransformation> map = new HashMap<>();
		map.put(ItemCameraTransforms.TransformType.GUI, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(0F, 1.0F, 0F), new Vector3f(0.5F, 0.5F, 0), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.GROUND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(-90F, 0F, 0F), new Vector3f(0.5F, 0.3F, 0.5F), new Vector3f(0.5F, 0.5F, 0.5F))));
		map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -120F, 0F), new Vector3f(1F, 1.5F, 0F), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -110, 0F), new Vector3f(1F, 1.5F, 0F), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, 0.5F), new Vector3f(0.7F, 0.7F, 0.7F))));
		map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 0.6F, -0.2F), new Vector3f(0.7F, 0.7F, 0.7F))));
		map.put(ItemCameraTransforms.TransformType.FIXED, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(0F, 0F, 0F), new Vector3f(0.5F, 0.5F, 0.5F), new Vector3f(1F, 1F, 1F))));
		return new LCModelState(map);
	}
}
