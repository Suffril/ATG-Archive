package com.lcm.doctorwho.utils;

import com.lcm.doctorwho.AcrossTheGalaxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

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
