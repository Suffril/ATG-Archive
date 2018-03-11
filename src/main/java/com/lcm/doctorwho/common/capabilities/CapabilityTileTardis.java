package com.lcm.doctorwho.common.capabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.lcm.doctorwho.common.tiles.TileEntityTardis;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CapabilityTileTardis implements ITardis
{
    @CapabilityInject(ITardis.class)
    public static final Capability<ITardis> TARDIS = null;

    TileEntityTardis tardis;

    private int tardisID, modelID;
    private String ownerUUID = "No-one";
    private boolean doorOpen;
    BlockPos interiorPos;

    public CapabilityTileTardis(TileEntityTardis tile)
    {
        tardis = tile;
    }

    @Override
    public int getTardisID() {
        return tardisID;
    }

    @Override
    public void setTardisID(int id) {
        tardisID = id;
    }

    @Override
    public int getModelID() {
        return modelID;
    }

    @Override
    public void setModelID(int id) {
        modelID = id;
    }

    @Override
    public boolean isDoorOpen() {
        return doorOpen;
    }

    @Override
    public void setDoorOpen(boolean open) {
        doorOpen = open;
    }

    @Override
    public String getOwner() {
        return ownerUUID;
    }

    @Override
    public void setOwner(String uuid) {
        ownerUUID = uuid;
    }

    @Override
    public BlockPos getInteriorPos() {
        return null;
    }

    @Override
    public void setBlockPos(BlockPos pos)
    {
       interiorPos = pos;
    }

    @Override
    public NBTTagCompound writeNBT()
    {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger("tardisID", tardisID);
        compound.setString("ownerUUID", ownerUUID);
        compound.setInteger("modelID", modelID);
        compound.setBoolean("doorOpen", doorOpen);
        return compound;
    }

    @Override
    public void readNBT(NBTTagCompound nbt)
    {
        System.out.println("sadasdasdasdas");
        tardisID = nbt.getInteger("tardisID");
        ownerUUID = nbt.getString("ownerUUID");
        modelID = nbt.getInteger("modelID");
        doorOpen = nbt.getBoolean("doorOpen");
    }


    public static class CapabilityTardisProvider implements ICapabilitySerializable<NBTTagCompound>
    {

        private ITardis capability;

        public CapabilityTardisProvider(ITardis capability)
        {
            this.capability = capability;
        }

        @Override public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
        {
            return TARDIS != null && capability == TARDIS;
        }

        @Nullable @Override public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
        {
            return capability == TARDIS ? TARDIS.cast(this.capability) : null;
        }

        @Override public NBTTagCompound serializeNBT()
        {
            return (NBTTagCompound) TARDIS.getStorage().writeNBT(TARDIS, this.capability, null);
        }

        @Override public void deserializeNBT(NBTTagCompound nbt)
        {
            TARDIS.getStorage().readNBT(TARDIS, this.capability, null, nbt);
        }
    }

    public static class Storage implements Capability.IStorage<ITardis>
    {

        @Nullable @Override public NBTBase writeNBT(Capability<ITardis> capability, ITardis instance, EnumFacing side)
        {
            return instance.writeNBT();
        }

        @Override public void readNBT(Capability<ITardis> capability, ITardis instance, EnumFacing side, NBTBase nbt)
        {
            instance.readNBT((NBTTagCompound) nbt);
        }
    }
}