package com.lcm.doctorwho.common.tiles;

import com.lcm.doctorwho.common.capabilities.CapabilityTileTardis;
import com.lcm.doctorwho.common.capabilities.ITardis;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageSyncTardis;
import com.lcm.doctorwho.utils.TardisUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.UUID;

public class TileEntityTardis extends TileEntity implements ITickable {

    protected CapabilityTileTardis handler;

    public TileEntityTardis() {
        handler = new CapabilityTileTardis(this);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityTileTardis.TARDIS || super.hasCapability(capability, facing);
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(TardisUtils.tardisWriteToNBT(getCapability(CapabilityTileTardis.TARDIS, null)));
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTag;
        nbtTag = TardisUtils.tardisWriteToNBT(getCapability(CapabilityTileTardis.TARDIS, null));
        writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        ITardis capa = getCapability(CapabilityTileTardis.TARDIS, null);
        capa = TardisUtils.tardisReadFromNBT(capa, nbt);
        ATGNetwork.INSTANCE.sendToAll(new MessageSyncTardis(pos, TardisUtils.tardisWriteToNBT(capa)));
        super.readFromNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        tag = TardisUtils.tardisWriteToNBT(getCapability(CapabilityTileTardis.TARDIS, null));
        super.writeToNBT(tag);
        return tag;
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return (T)handler;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return super.getRenderBoundingBox().grow(8, 8, 8);
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    @Override
    public void update() {

    }
}
