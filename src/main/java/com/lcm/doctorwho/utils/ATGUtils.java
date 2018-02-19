package com.lcm.doctorwho.utils;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.util.List;

public class ATGUtils {

    /**
     * Really easy way of playing sounds
     */
    public static void playSound(Entity entity, SoundEvent sound) {
        entity.world.playSound(null, entity.posX, entity.posY, entity.posZ, sound, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }

    /**
     * Checks whether we are on a client or not
     */
    public static boolean isClient()
    {
        return AcrossTheGalaxy.FML.getSide().isClient();
    }

    /**
     * Set's the players walk speed serverside
     */
    public static void setWalkSpeed(EntityPlayerMP p, float speed) { ReflectionHelper.setPrivateValue(PlayerCapabilities.class, p.capabilities, speed, 6); }

    /**
     * Stops a mob in it's tracks, FULLY.
     */
    public static void freezeMob(Entity entity)
    {
        entity.motionX = 0;
        entity.motionY = 0;
        entity.motionZ = 0;
    }

}
