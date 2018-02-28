package com.lcm.doctorwho.utils;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.regeneration.util.RegenRequires;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

@RegenRequires
public class ATGSoundEvent extends SoundEvent {
	
	public ATGSoundEvent(String name) {
		super(new ResourceLocation(AcrossTheGalaxy.MODID, name));
		setRegistryName(AcrossTheGalaxy.MODID, name);
	}
}
