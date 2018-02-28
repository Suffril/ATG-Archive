package com.lcm.doctorwho.utils;

import com.lcm.doctorwho.AcrossTheGalaxy;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ATGSoundEvent extends SoundEvent { //TODO in both

    public ATGSoundEvent(String name) {
        super(new ResourceLocation(AcrossTheGalaxy.MODID, name));
        setRegistryName(AcrossTheGalaxy.MODID, name);
    }
}
