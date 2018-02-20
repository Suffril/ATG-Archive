package com.lcm.doctorwho.client.render;

import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import com.lcm.doctorwho.client.models.ItemModelBase;

import lucraft.mods.lucraftcore.util.helper.LCRenderHelper;
import lucraft.mods.lucraftcore.util.render.IItemRenderer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.model.IModelState;

public class RenderItemModelBase implements IItemRenderer {

    public static ResourceLocation TEX = null;
    public static final ResourceLocation ENCHANTED_ITEM_GLINT_RES = new ResourceLocation("textures/misc/enchanted_item_glint.png");

     private static IBakedModel jsonModel;
     private static ItemModelBase javaModel;
     private static float scale = 0.0625F;


    public RenderItemModelBase(IBakedModel jsonModel, ItemModelBase javaModel, ResourceLocation textureLoc) {
        RenderItemModelBase.jsonModel = jsonModel;
        RenderItemModelBase.javaModel = javaModel;
        RenderItemModelBase.TEX = textureLoc;
    }

    public RenderItemModelBase(IBakedModel jsonModel, ItemModelBase javaModel, ResourceLocation textureLoc, float scale) {
        RenderItemModelBase.jsonModel = jsonModel;
        RenderItemModelBase.javaModel = javaModel;
        RenderItemModelBase.TEX = textureLoc;
        RenderItemModelBase.scale = scale;
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
        if(jsonModel == null)
            return IItemRenderer.super.getQuads(state, side, rand);
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
        if(jsonModel != null && (cameraTransformType == TransformType.GUI || cameraTransformType == TransformType.FIXED))
            jsonModel.handlePerspective(cameraTransformType);
        return IItemRenderer.super.handlePerspective(cameraTransformType);
    }

    @SuppressWarnings("deprecation")
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
        if(jsonModel != null && (transformType == TransformType.GUI || transformType == TransformType.FIXED))
            Minecraft.getMinecraft().getRenderItem().renderItem(stack, jsonModel);
        else {
            Minecraft.getMinecraft().renderEngine.bindTexture(TEX);

            javaModel.renderModel(scale);
            if(stack.isItemEnchanted())
                renderEnchantedGlint(Minecraft.getMinecraft().player, javaModel);
        }
    }

    private static void renderEnchantedGlint(EntityLivingBase entity, ItemModelBase model) {
        float f = (float) entity.ticksExisted + LCRenderHelper.renderTick;
        Minecraft.getMinecraft().renderEngine.bindTexture(ENCHANTED_ITEM_GLINT_RES);
        GlStateManager.enableBlend();
        GlStateManager.depthFunc(514);
        GlStateManager.depthMask(false);
        GlStateManager.color(0.5F, 0.5F, 0.5F, 1.0F);

        for (int i = 0; i < 2; ++i) {
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_COLOR, GlStateManager.DestFactor.ONE);
            GlStateManager.color(0.38F, 0.19F, 0.608F, 1.0F);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.scale(0.33333334F, 0.33333334F, 0.33333334F);
            GlStateManager.rotate(30.0F - (float) i * 60.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.translate(0.0F, f * (0.001F + (float) i * 0.003F) * 20.0F, 0.0F);
            GlStateManager.matrixMode(5888);
            javaModel.renderModel(scale);
        }

        GlStateManager.matrixMode(5890);
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode(5888);
        GlStateManager.enableLighting();
        GlStateManager.depthMask(true);
        GlStateManager.depthFunc(515);
        GlStateManager.disableBlend();
    }

}
