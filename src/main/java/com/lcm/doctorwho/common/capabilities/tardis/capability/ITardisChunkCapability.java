package com.lcm.doctorwho.common.capabilities.tardis.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

/**
 * Created by Nictogen on 3/19/18.
 */
public interface ITardisChunkCapability {

	NBTTagCompound writeNBT();

	void readNBT(NBTTagCompound nbt);

	void syncToAll();

	int getExteriorDim();

	void setExteriorDim(int dim);

	BlockPos getExteriorPos();

	void setExteriorPos(BlockPos pos);
}
