package com.lcm.doctorwho.utils;

import com.lcm.doctorwho.AcrossTheGalaxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class ATGUtils {

    //Common
    //==================================================================================================\\
    public static void playSound(Entity entity, SoundEvent sound) {
        entity.world.playSound(null, entity.posX, entity.posY, entity.posZ, sound, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }

    public static boolean isClient()
    {
        return AcrossTheGalaxy.FML.getSide().isClient();
    }

    public static void setWalkSpeed(EntityPlayerMP p, float speed) { ReflectionHelper.setPrivateValue(PlayerCapabilities.class, p.capabilities, speed, 6); }

}
