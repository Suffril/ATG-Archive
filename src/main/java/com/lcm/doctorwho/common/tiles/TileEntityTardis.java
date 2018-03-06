package com.lcm.doctorwho.common.tiles;

import com.lcm.doctorwho.common.capabilities.CapabilityTileTardis;
import com.lcm.doctorwho.common.capabilities.iTardis;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityTardis extends TileEntity {

    protected CapabilityTileTardis handler;

    public TileEntityTardis() {
        handler = new CapabilityTileTardis(this);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityTileTardis.TARDIS || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return (T)handler;
    }
    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        iTardis capa = this.getCapability(CapabilityTileTardis.TARDIS, null);
        return nbtTag;
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        iTardis capa = this.getCapability(CapabilityTileTardis.TARDIS, null);
        NBTTagCompound nbt = packet.getNbtCompound();
        this.readFromNBT(packet.getNbtCompound());
    }

}
