package com.lcm.doctorwho.client.render.item;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.ItemModelBase;
import com.lcm.doctorwho.client.models.items.ModelFobwatch;
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
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.List;

public class RenderItemFobwatch implements IItemRenderer {

	// Textures
	private ResourceLocation modelTexture = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/items/fob.png");

	private static final ResourceLocation ENCHANTED_ITEM_GLINT_RES = new ResourceLocation("textures/misc/enchanted_item_glint.png");

	// Models
	private ItemModelBase modelFobWatchClosed = new ModelFobwatch(false);
	private ItemModelBase modelfobWatchOpen = new ModelFobwatch(true);

	public RenderItemFobwatch() { }

	@Override public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		return IItemRenderer.super.getQuads(state, side, rand);
	}

	@Override public boolean isAmbientOcclusion() {
		return false;
	}

	@Override public boolean isGui3d() {
		return false;
	}

	@Override public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType) {
		return IItemRenderer.super.handlePerspective(cameraTransformType);
	}

	@Override public ItemCameraTransforms getItemCameraTransforms() {
		return IItemRenderer.super.getItemCameraTransforms();
	}

	@Override public IModelState getTransforms() {
		return modelFobWatchClosed.getTransforms();
	}

	@Override public void renderItem(ItemStack stack, TransformType transformType) {
		Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);

		ItemModelBase modelInUse = (stack.getTagCompound() != null && stack.getTagCompound().getBoolean("open")) ? modelfobWatchOpen : modelFobWatchClosed;

		float scale = 0.0625F;
		modelInUse.renderModel(scale);

		if (stack.isItemEnchanted())
			ATGUtils.renderEnchantedGlint(Minecraft.getMinecraft().player, modelInUse, ENCHANTED_ITEM_GLINT_RES, scale);
	}

}
