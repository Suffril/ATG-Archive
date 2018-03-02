package com.lcm.doctorwho;

import com.lcm.doctorwho.common.superpower.TimelordSuperpower;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.utils.ATGConfig;

import lucraft.mods.lucraftcore.utilities.items.ItemInjection;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AcrossTheGalaxy.MODID, name = AcrossTheGalaxy.NAME, version = AcrossTheGalaxy.VERSION, dependencies = "required:forge@[14.23.1.2574,); required-after:lucraftcore@[1.12-2.0.4,)", acceptedMinecraftVersions = "1.12, 1.12.1, 1.12.2")
@Mod.EventBusSubscriber
public class AcrossTheGalaxy {
	public static final String MODID = "lcm-atg";
	public static final String NAME = "Doctor who - Across the galaxy";
	public static final String VERSION = "1.0";
	
	public static final ResourceLocation ICONS = new ResourceLocation(MODID, "textures/gui/ability_icons.png");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ATGConfig.init(new Configuration(event.getSuggestedConfigurationFile()));
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		ATGNetwork.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ItemInjection.registerInjection(new TimelordSuperpower.Injection(), TimelordSuperpower.INSTANCE.getRegistryName());
	}
	
}
