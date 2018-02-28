package com.lcm.doctorwho.utils;

import com.lcm.doctorwho.client.models.ItemModelBase;

import lucraft.mods.lucraftcore.util.helper.LCRenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ATGUtils {
	
	/**
	 * Really easy way of playing sounds
	 */
	public static void playSound(Entity entity, SoundEvent sound) {
		entity.world.playSound(null, entity.posX, entity.posY, entity.posZ, sound, SoundCategory.PLAYERS, 1.0F, 1.0F);
	}
	
	/**
	 * Checks whether we are on a client or not
	 */
	public static boolean isClient() {
		return FMLCommonHandler.instance().getSide().isClient();
	}
	
	/**
	 * Set's the players walk speed serverside
	 */
	public static void setWalkSpeed(EntityPlayerMP p, float speed) { // TODO in both
		ReflectionHelper.setPrivateValue(PlayerCapabilities.class, p.capabilities, speed, 6);
	}
	
	/**
	 * Stops a mob in it's tracks, FULLY.
	 */
	@Deprecated
	public static void freezeMob(Entity entity, boolean considerYlevel) {
		entity.motionX = 0;
		if (considerYlevel & entity.onGround) entity.motionY = 0;
		entity.motionZ = 0;
	}
	
	/**
	 * Rendering a enchanted effect onto modelled items
	 */
	@SideOnly(Side.CLIENT)
	public static void renderEnchantedGlint(EntityLivingBase entity, ItemModelBase model, ResourceLocation loc, float scale) { // TODO in both
		float f = entity.ticksExisted + LCRenderHelper.renderTick;
		Minecraft.getMinecraft().renderEngine.bindTexture(loc);
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
			GlStateManager.rotate(30.0F - i * 60.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.translate(0.0F, f * (0.001F + i * 0.003F) * 20.0F, 0.0F);
			GlStateManager.matrixMode(5888);
			model.renderModel(scale);
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
