package com.lcm.doctorwho.common.mobs;

import com.lcm.doctorwho.utils.ATGUtils;

import net.minecraft.entity.EntityLiving;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityWeepingAngel extends EntityLiving {
	
	private static final DataParameter<Boolean> VIEWED = EntityDataManager.<Boolean>createKey(EntityWeepingAngel.class, DataSerializers.BOOLEAN);
	
	private static final DataParameter<Integer> TIME_SEEN = EntityDataManager.<Integer>createKey(EntityWeepingAngel.class, DataSerializers.VARINT);
	
	public EntityWeepingAngel(World world) {
		super(world);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		getDataManager().register(VIEWED, false);
		getDataManager().register(TIME_SEEN, 0);
	}
	
	/**
	 * @return Returns whether the angel is beign viewed or not
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
				ATGUtils.freezeMob(this);
				
				if (getSeenTime() > 15) {
					setSeen(false);
				}
			} else {
				setSeenTime(0);
			}
		}
	}
	
}
