package com.lcm.doctorwho.common.capabilities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

public interface iTardis
{
    NBTTagCompound writeNBT();
    void readNBT(NBTTagCompound nbt);
    int getTardisID();
    void setTardisID(int id);
    BlockPos getInteriorPos();
}