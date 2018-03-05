package com.lcm.doctorwho.common.capabilities;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.TileEntityTardis;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CapabilityTileTardis implements iTardis
{
    @CapabilityInject(iTardis.class)
    public static final Capability<iTardis> TARDIS = null;

    TileEntityTardis tardis;

    public int tardisID;

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
    public BlockPos getInteriorPos() {
        return null;
    }

    @Override
    public NBTTagCompound writeNBT()
    {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger("tardisID", tardisID);
        System.out.println(compound);
        return compound;
    }

    @Override
    public void readNBT(NBTTagCompound nbt)
    {
        tardisID = nbt.getInteger("tardisID");
    }


    public static class CapabilityTardisProvider implements ICapabilitySerializable<NBTTagCompound>
    {

        private iTardis capability;

        public CapabilityTardisProvider(iTardis capability)
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

    public static class EventHandler
    {
        @SubscribeEvent
        public void onAttachCapabilities(AttachCapabilitiesEvent<TileEntity> event) {
            if (!(event.getObject() instanceof TileEntityTardis) || event.getObject().hasCapability(TARDIS, null))
                return;
            event.addCapability(new ResourceLocation(AcrossTheGalaxy.MODID, "tardis"),
                    new CapabilityTardisProvider(new CapabilityTileTardis((TileEntityTardis) event.getObject())));

        }
    }


    public static class Storage implements Capability.IStorage<iTardis>
    {

        @Nullable @Override public NBTBase writeNBT(Capability<iTardis> capability, iTardis instance, EnumFacing side)
        {
            return instance.writeNBT();
        }

        @Override public void readNBT(Capability<iTardis> capability, iTardis instance, EnumFacing side, NBTBase nbt)
        {
            instance.readNBT((NBTTagCompound) nbt);
        }
    }
}