package com.lcm.doctorwho.client.render.item;

import java.util.List;

import javax.vecmath.Matrix4f;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.items.ModelFobwatchClosed;
import com.lcm.doctorwho.client.models.items.ModelFobwatchOpen;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.potion.Potion;
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

public class RenderItemFobwatch implements IItemRenderer {

    //Textures
    private ResourceLocation modelTextureOpen = new ResourceLocation(AcrossTheGalaxy.MODID,"textures/items/fob_watch/fob_open.png");
    private ResourceLocation modelTextureClosed = new ResourceLocation(AcrossTheGalaxy.MODID,"textures/items/fob_watch/fob_closed.png");
    private ResourceLocation modelTexture = modelTextureClosed;

    private static final ResourceLocation ENCHANTED_ITEM_GLINT_RES = new ResourceLocation("textures/misc/enchanted_item_glint.png");

    //Models
    private ItemModelBase modelFobWatchClosed = new ModelFobwatchClosed();
    private ItemModelBase modelfobWatchOpen = new ModelFobwatchOpen();
    private ItemModelBase modelInUse = modelFobWatchClosed;

    private float scale = 0.0625F;

    public RenderItemFobwatch() {

    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
    return IItemRenderer.super.getQuads(state, side, rand);
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
       return IItemRenderer.super.handlePerspective(cameraTransformType);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return IItemRenderer.super.getItemCameraTransforms();
    }

    @Override
    public IModelState getTransforms() {
        return modelInUse.getTransforms();
    }

    @Override
    public void renderItem(ItemStack stack, TransformType transformType) {
            Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);

        if(stack.getTagCompound() != null && stack.getTagCompound().getBoolean("open"))
        {
            modelInUse = modelfobWatchOpen;
            modelTexture = modelTextureOpen;
        } else
            { modelInUse = modelFobWatchClosed;
              modelTexture = modelTextureClosed;
            }

            modelInUse.renderModel(scale);

            if (stack.isItemEnchanted()) {
                ATGUtils.renderEnchantedGlint(Minecraft.getMinecraft().player, modelInUse, ENCHANTED_ITEM_GLINT_RES, scale);
            }
    }

}
