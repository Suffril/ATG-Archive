package com.lcm.doctorwho.common.capabilities.timelord.capability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Nictogen on 3/16/18.
 */
public interface ITimelordCapability
{
	void update();

	NBTTagCompound writeNBT();
	void readNBT(NBTTagCompound nbt);
	void syncToAll();
	boolean isTimelord();
	int getRegenTicks();
	int getRegensLeft();
	int getTimesRegenerated();
	CapabilityTimelord.RegenerationState getState();
	EntityPlayer getPlayer();
	NBTTagCompound getStyle();
	void setTimelord(boolean timelord);
	void setRegenTicks(int ticks);
	void setRegensLeft(int left);
	void setTimesRegenerated(int times);
	void changeState(CapabilityTimelord.RegenerationState state);
	void setStyle(NBTTagCompound nbtTagCompound);
}
