package com.lcm.doctorwho.client.windows;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Created by Nictogen on 3/5/18.
 */
public class EntityCamera extends EntityPlayerSP
{
	public EntityCamera(World world){
		super(Minecraft.getMinecraft(), FakeWorldHandler.fakeWorld, Minecraft.getMinecraft().getConnection(), null, null);

	}

	public EntityCamera(double x, double y, double z)
	{
		super(Minecraft.getMinecraft(), FakeWorldHandler.fakeWorld, Minecraft.getMinecraft().getConnection(), null, null);
		this.setPositionAndUpdate(x, y, z);
	}

	@Override
	public void onEntityUpdate() {}

	@Override
	public void onLivingUpdate() {}

	@Override
	public void onUpdate() {}

	@Override
	protected int getExperiencePoints(EntityPlayer par1EntityPlayer) {
		return 0;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {}

	@Override
	public void setAIMoveSpeed(float par1) {}

	@Override
	protected void dropEquipment(boolean par1, int par2) {}

	@Override
	protected void onDeathUpdate() {
		setDead();
	}

	@Override
	public void setRevengeTarget(EntityLivingBase par1) {}

	@Override
	protected void updatePotionEffects() {}

	@Override
	public void clearActivePotions() {}

	@Override
	public boolean isPotionActive(Potion par1) {
		return false;
	}

	@Override
	public PotionEffect getActivePotionEffect(Potion par1) {
		return null;
	}

	@Override
	public void addPotionEffect(PotionEffect par1) {}

	@Override
	public boolean isPotionApplicable(PotionEffect par1) {
		return false;
	}

	@Override
	public boolean isEntityUndead() {
		return false;
	}

	@Override
	protected void onNewPotionEffect(PotionEffect par1) {}

	@Override
	protected void onChangedPotionEffect(PotionEffect par1, boolean par2) {}

	@Override
	protected void onFinishedPotionEffect(PotionEffect par1) {}

	@Override
	public void heal(float par1) {}

	@Override
	public boolean attackEntityFrom(DamageSource par1, float par2) {
		return false;
	}

	@Override
	public void renderBrokenItemStack(ItemStack par1) {}

	@Override
	public void onDeath(DamageSource par1) {
		world.setEntityState(this, (byte) 3);
	}

	@Override
	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {}

	@Override
	public boolean isOnLadder() {
		return false;
	}

	@Override
	public int getTotalArmorValue() {
		return 0;
	}

	@Override
	protected float applyArmorCalculations(DamageSource par1DamageSource, float par2) {
		return par2;
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource par1DamageSource, float par2) {
		return par2;
	}

	@Override
	protected void damageEntity(DamageSource par1, float par2) {}

	@Override
	protected void updateArmSwingProgress() {}

	@Override
	public void setSprinting(boolean par1) {}

	@Override
	protected float getSoundVolume() {
		return 0F;
	}

	@Override
	public void dismountEntity(Entity par1Entity) {}

	@Override
	public void updateRidden() {}

	@Override
	public void setJumping(boolean par1) {}

	@Override
	public void onItemPickup(Entity par1Entity, int par2) {}

	@Override
	public boolean canEntityBeSeen(Entity par1Entity) {
		return false;
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	public boolean handleWaterMovement() {
		return false;
	}

	@Override
	public boolean isInsideOfMaterial(Material par1Material) {
		return false;
	}

	@Override
	public void move(MoverType type, double par1, double par2, double par3) {}

	@Override
	public float getBrightness() {
		return 0;
	}

	@Override
	public void applyEntityCollision(Entity par1Entity) {}

	@Override
	public boolean isBurning() {
		return false;
	}

	@Override
	public boolean isRiding() {
		return false;
	}

	@Override
	public boolean isSneaking() {
		return false;
	}

	@Override
	public boolean isInvisible() {
		return true;
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt par1) {}

	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		return true;
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return false;
	}

	@Override
	protected void collideWithEntity(Entity par1Entity) {}

	@Override
	protected void collideWithNearbyEntities() {}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return true;
	}
}