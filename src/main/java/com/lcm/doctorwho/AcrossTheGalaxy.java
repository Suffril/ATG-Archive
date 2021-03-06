package com.lcm.doctorwho;

import com.lcm.doctorwho.common.capabilities.tardis.capability.CapabilityTardisChunk;
import com.lcm.doctorwho.common.capabilities.tardis.capability.ITardisChunkCapability;
import com.lcm.doctorwho.common.capabilities.timelord.capability.CapabilityTimelord;
import com.lcm.doctorwho.common.capabilities.timelord.capability.ITimelordCapability;
import com.lcm.doctorwho.common.dimension.ATGDims;
import com.lcm.doctorwho.events.ATGCommonProxy;
import com.lcm.doctorwho.events.ATGObjects;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.utils.ATGConfig;
import com.lcm.doctorwho.utils.DebugCommand;
import com.lcm.doctorwho.utils.WorldJsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = AcrossTheGalaxy.MODID, name = AcrossTheGalaxy.NAME, version = AcrossTheGalaxy.VERSION, dependencies = "required:forge@[14.23.1.2574,); required-after:lucraftcore@[1.12-2.0.4,)", acceptedMinecraftVersions = "1.12, 1.12.1, 1.12.2") @EventBusSubscriber public class AcrossTheGalaxy {

	@SidedProxy(serverSide = "com.lcm.doctorwho.events.ATGCommonProxy", clientSide = "com.lcm.doctorwho.events.ATGClientProxy")
	public static ATGCommonProxy proxy;

	public static final String MODID = "lcm-atg";
	public static final String NAME = "Doctor who - Across the galaxy";
	public static final String VERSION = "1.0";
	public static final ResourceLocation ICONS = new ResourceLocation(MODID, "textures/gui/ability_icons.png");

	@Mod.Instance("lcm-atg") public static AcrossTheGalaxy instance;

	@EventHandler public void preInit(FMLPreInitializationEvent event) {
		ATGConfig.init(new Configuration(event.getSuggestedConfigurationFile()));
		proxy.preInit(event);
	}

	@EventHandler public void init(FMLInitializationEvent event) {
		ATGObjects.setUpTiles();
		ATGNetwork.init();
		MinecraftForge.EVENT_BUS.register(proxy);
		CapabilityManager.INSTANCE.register(ITimelordCapability.class, new CapabilityTimelord.Storage(), CapabilityTimelord.class);
		CapabilityManager.INSTANCE.register(ITardisChunkCapability.class, new CapabilityTardisChunk.Storage(), CapabilityTardisChunk.class);
		proxy.init(event);
		ATGDims.dimSetup();
	}

	@EventHandler public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	@EventHandler public void serverStart(FMLServerStartingEvent event) {
		event.registerServerCommand(new DebugCommand());
		event.registerServerCommand(new WorldJsonUtils.GenerateJsonCommand());
		event.registerServerCommand(new WorldJsonUtils.BuildJsonCommand());
	}

}
