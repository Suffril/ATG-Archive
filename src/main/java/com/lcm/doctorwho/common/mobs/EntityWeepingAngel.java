package com.lcm.doctorwho.common.mobs;

import com.lcm.doctorwho.utils.ATGUtils;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityWeepingAngel extends EntityMob {

	private static final DataParameter<Boolean> VIEWED = EntityDataManager.<Boolean>createKey(EntityWeepingAngel.class, DataSerializers.BOOLEAN);
	
	private static final DataParameter<Integer> TIME_SEEN = EntityDataManager.<Integer>createKey(EntityWeepingAngel.class, DataSerializers.VARINT);
	
	public EntityWeepingAngel(World world) {
		super(world);
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
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
		
		if (!world.isRemote) {
			if (isSeen()) {
				setSeenTime(getSeenTime() + 1);
				ATGUtils.freezeMob(this, false);
				
				if (getSeenTime() > 15) {
					setSeen(false);
				}
			} else {
				setSeenTime(0);
			}
		}
	}
	
}
