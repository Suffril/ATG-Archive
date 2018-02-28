package com.lcm.regeneration;

import com.lcm.regeneration.util.RegenConfig;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RegenerationATG.MODID, name = RegenerationATG.NAME, version = RegenerationATG.VERSION, dependencies = "required:forge@[14.23.1.2574,); required-after:lucraftcore@[1.12-2.0.4,)", acceptedMinecraftVersions = "1.12, 1.12.1, 1.12.2")
@Mod.EventBusSubscriber
public class RegenerationATG {
	public static final String MODID = "lcm-regen-atg";
	public static final String NAME = "Regeneration (ATG)";
	public static final String VERSION = "1.0";
	
	public static final ResourceLocation ICONS = new ResourceLocation(MODID, "textures/gui/ability_icons.png");
	
	public static FMLCommonHandler FML = FMLCommonHandler.instance();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		RegenConfig.init(new Configuration(event.getSuggestedConfigurationFile()));
	}
}
