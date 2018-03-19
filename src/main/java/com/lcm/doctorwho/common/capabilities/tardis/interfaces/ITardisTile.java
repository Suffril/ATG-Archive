package com.lcm.doctorwho.common.capabilities.tardis.interfaces;

import net.minecraft.nbt.NBTTagCompound;

public interface ITardisTile {
	NBTTagCompound writeNBT();

	void readNBT(NBTTagCompound nbt);

	int getTardisID();

	void setTardisID(int id);

	int getModelID();

	void setModelID(int id);

	boolean isDoorOpen();

	void setDoorOpen(boolean open);

	String getOwner();

	void setOwner(String uuid);
}
