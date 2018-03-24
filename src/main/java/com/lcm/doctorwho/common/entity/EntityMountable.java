package com.lcm.doctorwho.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMountable extends Entity
{
    int EntityPosX;
    int EntityPosY;
    int EntityPosZ;

    public EntityMountable(World world)
    {
        super(world);
        noClip = true;
        height = 0.01F;
        width = 0.01F;
    }

    public EntityMountable(World world, double x, double y, double z, double y0ffset)
    {
        this(world);
        EntityPosX = (int) x;
        EntityPosY = (int) y;
        EntityPosZ = (int) z;
        setPosition(x + 0.5D, y + y0ffset, z + 0.5D);
    }

    @Override
    public double getMountedYOffset()
    {
        return height * 0.0D;
    }

    @Override
    protected boolean shouldSetPosAfterLoading()
    {
        return false;
    }

    @Override
    public void onEntityUpdate()
    {
        if (!world.isRemote)
        {
            if (!isBeingRidden())
            {
                setDead();
            }
        }
    }

    @Override
    protected void entityInit()
    {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }

}