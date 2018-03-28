package com.lcm.doctorwho.client.models.tardis.decoration;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.TileModelOutline;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Nictogen on 3/19/18.
 */
public class ModelMonitor extends TileModelOutline {

	private static final ResourceLocation TEXTURE = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/blocks/monitor.png");
	private ModelRenderer body;
	private ModelRenderer leftHandle;
	private ModelRenderer rightHandle;
	private ModelRenderer neck;

	public ModelMonitor() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this, 5, 0);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addBox(0.0F, 0.0F, 0.0F, 13, 8, 2);
		leftHandle = new ModelRenderer(this, 0, 0);
		leftHandle.setRotationPoint(13.5F, 2.0F, 0.0F);
		leftHandle.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
		setRotation(leftHandle, 0.0F, 0.39269908169872414F, 0.0F);
		ModelRenderer leftHandleTop = new ModelRenderer(this, 0, 6);
		leftHandleTop.setRotationPoint(-1.0F, 0.0F, 0.0F);
		leftHandleTop.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		leftHandle.addChild(leftHandleTop);
		ModelRenderer leftHandleBottom = new ModelRenderer(this, 0, 9);
		leftHandleBottom.setRotationPoint(-1.0F, 3.0F, 0.0F);
		leftHandleBottom.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		leftHandle.addChild(leftHandleBottom);
		rightHandle = new ModelRenderer(this, 36, 0);
		rightHandle.setRotationPoint(-1.5F, 2.0F, 0.0F);
		rightHandle.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
		setRotation(rightHandle, 0.0F, -0.39269908169872414F, 0.0F);
		ModelRenderer rightHandleTop = new ModelRenderer(this, 36, 6);
		rightHandleTop.setRotationPoint(1.0F, 0.0F, 0.0F);
		rightHandleTop.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		rightHandle.addChild(rightHandleTop);
		ModelRenderer rightHandleBottom = new ModelRenderer(this, 36, 9);
		rightHandleBottom.setRotationPoint(1.0F, 3.0F, 0.0F);
		rightHandleBottom.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		rightHandle.addChild(rightHandleBottom);
		neck = new ModelRenderer(this, 18, 11);
		neck.setRotationPoint(6.0F, 2.4F, 1.5F);
		neck.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
		setRotation(neck, 0.7853981633974483F, 0.0F, 0.0F);
		ModelRenderer neckBase = new ModelRenderer(this, 18, 18);
		neckBase.setRotationPoint(0.0F, 4.3F, 0.3F);
		neckBase.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
		setRotation(neckBase, -0.7853981633974483F, 0.0F, 0.0F);
		neck.addChild(neckBase);
	}

	@Override public void render(float scale) {
		body.render(scale);
		leftHandle.render(scale);
		rightHandle.render(scale);
		neck.render(scale);
	}

	@Override public ResourceLocation getTexture() {
		return TEXTURE;
	}
}
