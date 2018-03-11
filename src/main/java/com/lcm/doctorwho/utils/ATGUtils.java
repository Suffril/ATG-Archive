package com.lcm.doctorwho.utils;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.interfaces.ItemModelBase;

import lucraft.mods.lucraftcore.util.helper.LCRenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
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
	public static boolean isPhysicalClient() {
		return FMLCommonHandler.instance().getSide().isClient();
	}

	/**
	 * Set's the players walk speed serverside
	 */
	public static void setWalkSpeed(EntityPlayerMP p, float speed) {
		ReflectionHelper.setPrivateValue(PlayerCapabilities.class, p.capabilities, speed, 6);
	}

	/**
	 * Send a message to the player
	 */
	public static void sendPlayerMessage(EntityPlayer p, String message) {
		if (!p.world.isRemote) {
			p.sendMessage(new TextComponentString(message));
		}
	}

	@SideOnly(Side.CLIENT)
	public static void bindTexture(ResourceLocation resource) {
		Minecraft.getMinecraft().renderEngine.bindTexture(resource);
	}

	/**
	 * Stops a mob in it's tracks, FULLY.
	 */
	@Deprecated
	public static void freezeMob(Entity entity, boolean considerYlevel) {
		entity.motionX = 0;
		if (considerYlevel && entity.onGround) entity.motionY = 0;
		entity.motionZ = 0;
	}

	public static void regenerationExplosion(EntityPlayer player) {
		explodeKill(player, player.world, player.getPosition(), ATGConfig.regenerativeKillRange);
		explodeKnockback(player, player.world, player.getPosition(), ATGConfig.regenerativeKnockback, ATGConfig.regenerativeKnockbackRange);
	}

	public static void explodeKnockback(Entity exploder, World world, BlockPos pos, float knockback, int range) {
		world.getEntitiesWithinAABBExcludingEntity(exploder, getReach(pos, range)).forEach(entity -> {
			if (!(entity instanceof EntityLiving || entity instanceof EntityPlayer) || exploder.isDead) return;
			EntityLivingBase victim = (EntityLivingBase) entity;
			float densMod = world.getBlockDensity(new Vec3d(pos), entity.getEntityBoundingBox());

			int xr, zr;
			xr = (int) -(victim.posX - exploder.posX);
			zr = (int) -(victim.posZ - exploder.posZ);

			victim.knockBack(exploder, knockback * densMod, xr, zr);
		});
	}

	public static void explodeKill(Entity exploder, World world, BlockPos pos, int range) {
		world.getEntitiesWithinAABBExcludingEntity(exploder, getReach(pos, range)).forEach(entity -> {
			if (!(entity instanceof EntityLiving || entity instanceof EntityPlayer) || !entity.isNonBoss()) return;
			entity.attackEntityFrom(ATGUtils.RegenerativeDamageSource.INSTANCE, Float.MAX_VALUE);
		});
	}

	public static AxisAlignedBB getReach(BlockPos pos, int range) {
		return new AxisAlignedBB(pos.up(range).north(range).west(range), pos.down(range).south(range).east(range));
	}

	public static class RegenerativeDamageSource extends DamageSource { // useful for future extension / add-on hooking
		public static final DamageSource INSTANCE = new ATGUtils.RegenerativeDamageSource();

		private RegenerativeDamageSource() {
			super("regeneration");
		}
	}

	/**
	 * Rendering a enchanted effect onto modelled items
	 */
	@SideOnly(Side.CLIENT)
	public static void renderEnchantedGlint(EntityLivingBase entity, ItemModelBase model, ResourceLocation loc, float scale) {
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

	public static class ATGSoundEvent extends SoundEvent {
		public ATGSoundEvent(String name) {
			super(new ResourceLocation(AcrossTheGalaxy.MODID, name));
			setRegistryName(AcrossTheGalaxy.MODID, name);
		}
	}

}
