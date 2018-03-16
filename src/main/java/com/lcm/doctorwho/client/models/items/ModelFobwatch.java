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

public class ModelFobwatch extends ModelBase implements ItemModelBase {

	private ArrayList<ModelRenderer> boxes = new ArrayList<>();

	public ModelFobwatch(boolean open) {
		textureWidth = 64;
		textureHeight = 64;

		ModelRenderer WatchFace = new ModelRenderer(this, 0, 12);
		WatchFace.addBox(0F, 0F, 0F, 6, 6, 1);
		WatchFace.setRotationPoint(-3F, 17F, 0F);
		boxes.add(WatchFace);

		ModelRenderer WatchFaceGold1 = new ModelRenderer(this, 1, 20);
		WatchFaceGold1.addBox(0F, 0F, 0F, 2, 2, 1);
		WatchFaceGold1.setRotationPoint(-1F, 17.6F, -0.3F);
		boxes.add(WatchFaceGold1);

		ModelRenderer WatchFaceGold2 = new ModelRenderer(this, 8, 20);
		WatchFaceGold2.addBox(0F, 0F, 0F, 1, 1, 1);
		WatchFaceGold2.setRotationPoint(-2.5F, 19.6F, -0.3F);
		boxes.add(WatchFaceGold2);

		ModelRenderer WatchFaceGold3 = new ModelRenderer(this, 8, 23);
		WatchFaceGold3.addBox(0F, 0F, 0F, 1, 1, 1);
		WatchFaceGold3.setRotationPoint(1.5F, 19.6F, -0.3F);
		boxes.add(WatchFaceGold3);

		ModelRenderer WatchFaceHand1 = new ModelRenderer(this, 0, 24);
		WatchFaceHand1.addBox(0F, 0F, 0F, 3, 1, 0);
		WatchFaceHand1.setRotationPoint(0F, 19.6F, -0.3F);
		ATGUtils.setRotation(WatchFaceHand1, 0F, 0F, 0.5585054F);
		boxes.add(WatchFaceHand1);

		ModelRenderer WatchFaceHand2 = new ModelRenderer(this, 0, 26);
		WatchFaceHand2.addBox(0F, 0F, 0F, 2, 1, 0);
		WatchFaceHand2.setRotationPoint(0F, 19.6F, -0.3F);
		ATGUtils.setRotation(WatchFaceHand2, 0F, 0F, 1.204277F);
		boxes.add(WatchFaceHand2);

		ModelRenderer WatchBaseTop = new ModelRenderer(this, 0, 6);
		WatchBaseTop.addBox(0F, 0F, 0F, 6, 1, 4);
		WatchBaseTop.setRotationPoint(-3F, 16F, -1.5F);
		ATGUtils.setRotation(WatchBaseTop, 0F, 0F, 0F);
		boxes.add(WatchBaseTop);

		ModelRenderer WatchBaseBottom = new ModelRenderer(this, 0, 0);
		WatchBaseBottom.addBox(0F, 0F, 0F, 6, 1, 4);
		WatchBaseBottom.setRotationPoint(-3F, 23F, -1.5F);
		ATGUtils.setRotation(WatchBaseBottom, 0F, 0F, 0F);
		boxes.add(WatchBaseBottom);

		ModelRenderer WatchBaseSide1 = new ModelRenderer(this, 22, 0);
		WatchBaseSide1.addBox(0F, 0F, 0F, 4, 6, 1);
		WatchBaseSide1.setRotationPoint(-4F, 17F, 2.5F);
		ATGUtils.setRotation(WatchBaseSide1, 0F, 1.570796F, 0F);
		boxes.add(WatchBaseSide1);

		ModelRenderer WatchBaseSide2 = new ModelRenderer(this, 22, 8);
		WatchBaseSide2.addBox(0F, 0F, 0F, 4, 6, 1);
		WatchBaseSide2.setRotationPoint(3F, 17F, 2.5F);
		ATGUtils.setRotation(WatchBaseSide2, 0F, 1.570796F, 0F);
		boxes.add(WatchBaseSide2);

		ModelRenderer WatchLatch = new ModelRenderer(this, 15, 27);
		WatchLatch.addBox(0F, 0F, 0F, 2, 1, 1);
		WatchLatch.setRotationPoint(-1F, 22.7F, -2F);
		boxes.add(WatchLatch);

		ModelRenderer WatchCoverFront = new ModelRenderer(this, 0, 30);
		WatchCoverFront.addBox(0F, 0F, 0F, 6, 1, 6);
		if (open) {
			WatchCoverFront.setRotationPoint(-3F, 23F, -7.8F);
			ATGUtils.setRotation(WatchCoverFront, 0F, 0F, 0F);
		} else {
			WatchCoverFront.setRotationPoint(-3F, 23F, -1.1F);
			ATGUtils.setRotation(WatchCoverFront, 1.570796F, 0F, 0F);
		}
		boxes.add(WatchCoverFront);

		ModelRenderer WatchCoverBack = new ModelRenderer(this, 15, 19);
		WatchCoverBack.addBox(0F, 0F, 0F, 6, 6, 1);
		WatchCoverBack.setRotationPoint(-3F, 17F, 2F);
		boxes.add(WatchCoverBack);

		ModelRenderer WatchDial = new ModelRenderer(this, 22, 27);
		WatchDial.addBox(0F, 0F, 0F, 2, 1, 1);
		WatchDial.setRotationPoint(-1F, 13.9F, 0F);
		boxes.add(WatchDial);

		ModelRenderer WatchDialTop = new ModelRenderer(this, 26, 31);
		WatchDialTop.addBox(0F, 0F, 0F, 1, 1, 1);
		WatchDialTop.setRotationPoint(-0.5F, 13.7F, 0F);
		boxes.add(WatchDialTop);

		ModelRenderer WatchFobBase = new ModelRenderer(this, 26, 34);
		WatchFobBase.addBox(0F, 0F, 0F, 1, 1, 1);
		WatchFobBase.setRotationPoint(-0.5F, 15.3F, 0F);
		boxes.add(WatchFobBase);

		ModelRenderer WatchHandleHold = new ModelRenderer(this, 6, 27);
		WatchHandleHold.addBox(0F, 0F, 0F, 3, 1, 1);
		WatchHandleHold.setRotationPoint(-1.5F, 14.3F, 0F);
		boxes.add(WatchHandleHold);

		ModelRenderer WatchBackIndent1 = new ModelRenderer(this, 15, 12);
		WatchBackIndent1.addBox(0F, 0F, 0F, 2, 2, 1);
		WatchBackIndent1.setRotationPoint(-1F, 19F, 2.1F);
		boxes.add(WatchBackIndent1);

		ModelRenderer WatchBackIndent2 = new ModelRenderer(this, 15, 16);
		WatchBackIndent2.addBox(0F, 0F, 0F, 1, 1, 1);
		WatchBackIndent2.setRotationPoint(-2.5F, 20.3F, 2.1F);
		boxes.add(WatchBackIndent2);

		ModelRenderer WatchBackIndent3 = new ModelRenderer(this, 20, 16);
		WatchBackIndent3.addBox(0F, 0F, 0F, 1, 1, 1);
		WatchBackIndent3.setRotationPoint(1.5F, 21.3F, 2.1F);
		boxes.add(WatchBackIndent3);

		for (ModelRenderer box : boxes) {
			box.mirror = true;
			box.setTextureSize(64, 64);
		}
	}

	@Override public void renderModel(float scale) {
		for (ModelRenderer box : boxes)
			box.render(scale);
	}

	@Override public IModelState getTransforms() {
		Map<ItemCameraTransforms.TransformType, TRSRTransformation> map = new HashMap<>();
		map.put(ItemCameraTransforms.TransformType.GUI, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, 1F, 0F), new Vector3f(0.5F, 1.7F, 0), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.GROUND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, 1F, 0F), new Vector3f(0.5F, 1.2F, 0.5F), new Vector3f(0.5F, 0.5F, 0.5F))));
		map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, 395F, 0F), new Vector3f(1F, 1.7F, 0F), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(180F, -395, 0F), new Vector3f(1.3F, 1.7F, 1F), new Vector3f(1F, 1F, 1F))));
		map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 1.4F, 0.5F), new Vector3f(0.7F, 0.7F, 0.7F))));
		map.put(ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, new TRSRTransformation(new ItemTransformVec3f(new Vector3f(90F, 90F, 90F), new Vector3f(0.45F, 1.4F, -0.2F), new Vector3f(0.7F, 0.7F, 0.7F))));
		return new LCModelState(map);
	}
}
