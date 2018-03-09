package com.lcm.doctorwho.utils;

import com.lcm.doctorwho.common.capabilities.ITardis;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TardisUtils {

    public static NBTTagCompound tardisWriteToNBT(ITardis capa)
    {
        NBTTagCompound nbtTag = new NBTTagCompound();
        nbtTag.setInteger("tardisID", capa.getTardisID());
        nbtTag.setString("ownerUUID", capa.getOwner());
        nbtTag.setInteger("modelID", capa.getModelID());
        nbtTag.setBoolean("doorOpen", capa.isDoorOpen());
        return nbtTag;
    }

    public static ITardis tardisReadFromNBT(ITardis capa, NBTTagCompound nbt)
    {
        capa.setTardisID(nbt.getInteger("tardisID"));
        capa.setOwner(nbt.getString("ownerUUID"));
        capa.setModelID(nbt.getInteger("modelID"));
        capa.setDoorOpen(nbt.getBoolean("doorOpen"));
        return capa;
    }

}
