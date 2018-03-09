package com.lcm.doctorwho.client.render.item;

import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import com.lcm.doctorwho.client.models.interfaces.ItemModelBase;
import com.lcm.doctorwho.utils.ATGUtils;

import lucraft.mods.lucraftcore.util.render.IItemRenderer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.model.IModelState;

public class RenderItemModelBase implements IItemRenderer {
	
	private ResourceLocation modelTexture = null;
	private static final ResourceLocation ENCHANTED_ITEM_GLINT_RES = new ResourceLocation("textures/misc/enchanted_item_glint.png");
	
	private IBakedModel jsonModel;
	private ItemModelBase javaModel;
	private float scale = 0.0625F;
	
	public RenderItemModelBase(IBakedModel jsonModel, ItemModelBase javaModel, ResourceLocation textureLoc) {
		this.jsonModel = jsonModel;
		this.javaModel = javaModel;
		modelTexture = textureLoc;
	}
	
	public RenderItemModelBase(IBakedModel jsonModel, ItemModelBase javaModel, ResourceLocation textureLoc, float scale) {
		this.jsonModel = jsonModel;
		this.javaModel = javaModel;
		modelTexture = textureLoc;
		this.scale = scale;
	}
	
	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		if (jsonModel == null) return IItemRenderer.super.getQuads(state, side, rand);
		return jsonModel.getQuads(state, side, rand);
	}
	
	@Override
	public boolean isAmbientOcclusion() {
		return false;
	}
	
	@Override
	public boolean isGui3d() {
		return false;
	}
	
	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType) {
		if (jsonModel != null && (cameraTransformType == TransformType.GUI || cameraTransformType == TransformType.FIXED)) jsonModel.handlePerspective(cameraTransformType);
		return IItemRenderer.super.handlePerspective(cameraTransformType);
	}
	
	@Override
	public ItemCameraTransforms getItemCameraTransforms() {
		return IItemRenderer.super.getItemCameraTransforms();
	}
	
	@Override
	public IModelState getTransforms() {
		return javaModel.getTransforms();
	}
	
	@Override
	public void renderItem(ItemStack stack, TransformType transformType) {
		if (jsonModel != null && (transformType == TransformType.GUI || transformType == TransformType.FIXED))
			Minecraft.getMinecraft().getRenderItem().renderItem(stack, jsonModel);
		else {
			Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);
			
			javaModel.renderModel(scale);
			if (stack.isItemEnchanted()) ATGUtils.renderEnchantedGlint(Minecraft.getMinecraft().player, javaModel, ENCHANTED_ITEM_GLINT_RES, scale);
		}
	}
	
}
