package com.lcm.doctorwho.common.mobs.hostile;

import com.lcm.doctorwho.utils.ATGConfig;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraft.world.border.WorldBorder;

public class EntityWeepingAngel extends EntityMob {

	private static DataParameter<Boolean> VIEWED = EntityDataManager.<Boolean>createKey(EntityWeepingAngel.class, DataSerializers.BOOLEAN);

	private static DataParameter<Integer> TIME_SEEN = EntityDataManager.<Integer>createKey(EntityWeepingAngel.class, DataSerializers.VARINT);

	public EntityWeepingAngel(World world) {
		super(world);
		tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
		tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
		experienceValue = 9;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		getDataManager().register(VIEWED, false);
		getDataManager().register(TIME_SEEN, 0);
	}

	/**
	 * @return Returns whether the angel is being viewed or not
	 */
	public boolean isSeen() {
		return getDataManager().get(VIEWED);
	}

	/**
	 * Set's whether the angel is being viewed or not
	 */
	public void setSeen(boolean viewed) {
		getDataManager().set(VIEWED, viewed);
	}

	/**
	 * @return Returns the time the angel has been viewed for
	 */
	public int getSeenTime() {
		return getDataManager().get(TIME_SEEN);
	}

	/**
	 * Set's the time the angel is being viewed for
	 */
	public void setSeenTime(int time) {
		getDataManager().set(TIME_SEEN, time);
	}

	/**
	 * Minecrafts generic onUpdate()
	 */
	@Override
	public void onUpdate() {
		super.onUpdate();

		if (!world.isRemote) if (isSeen()) {
				setSeenTime(getSeenTime() + 1);
				motionX = 0;
				motionZ = 0;
				if (onGround) {
					motionZ = 0;
				}

				if (getSeenTime() > 15) setSeen(false);
			} else
				setSeenTime(0);
	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		dropItem(Item.getItemFromBlock(Blocks.STONE), 2);
	}

	@Override
	protected void collideWithEntity(Entity entity) {
		entity.applyEntityCollision(this);
		if (ATGConfig.angelTeleporting && this.rand.nextBoolean()) {
			WorldBorder border = entity.getEntityWorld().getWorldBorder();
			int x = rand.nextInt(border.getSize());
			int z = rand.nextInt(border.getSize());
			int y = world.getSpawnPoint().getY();
			entity.setPositionAndUpdate(x, y, z);
		}
	}

	/**
	 * Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("isSeen", isSeen());
		compound.setInteger("timeSeen", getSeenTime());
	}

	/**
	 * Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);

		if (compound.hasKey("isSeen")) setSeen(compound.getBoolean("isSeen"));

		if (compound.hasKey("timeSeen")) setSeenTime(compound.getInteger("timeSeen"));
	}

}
