package com.lcm.doctorwho.events;

import com.lcm.doctorwho.common.timelord.TimelordEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ATGCommonProxy {

	@Mod.EventHandler public void preInit(FMLPreInitializationEvent ev) {
	}

	@Mod.EventHandler public void init(FMLInitializationEvent ev) {
		MinecraftForge.EVENT_BUS.register(new TimelordEventHandler());
	}

	@Mod.EventHandler public void postInit(FMLPostInitializationEvent ev) {
	}

}
