package com.lcm.doctorwho;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSkull;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = AcrossTheGalaxy.MODID, name = AcrossTheGalaxy.NAME, version = AcrossTheGalaxy.VERSION, dependencies = "required:forge@[14.23.1.2574,); required-after:lucraftcore@[1.12-2.0.4,)", acceptedMinecraftVersions = "1.12, 1.12.1, 1.12.2")
public class AcrossTheGalaxy
{
    public static final String MODID = "lcm-atg";
    public static final String NAME = "Doctor who - Across the galaxy";
    public static final String VERSION = "1.0";

    private static Logger LOG;

    public static FMLCommonHandler FML = FMLCommonHandler.instance();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOG = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        LOG.info("Entered " + MODID + " init stage");
    }

}
