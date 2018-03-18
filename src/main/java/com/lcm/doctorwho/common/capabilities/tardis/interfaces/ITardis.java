package com.lcm.doctorwho.common.capabilities.interfaces;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

public interface ITardis {
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

	BlockPos getInteriorPos();

	void setBlockPos(BlockPos pos);
}
