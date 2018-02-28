package com.lcm.doctorwho;

import com.lcm.doctorwho.client.models.entity.ModelWeepingAngel;
import com.lcm.doctorwho.client.render.entity.RenderEntityBase;
import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = AcrossTheGalaxy.MODID, name = AcrossTheGalaxy.NAME, version = AcrossTheGalaxy.VERSION, dependencies = "required:forge@[14.23.1.2574,); required-after:lucraftcore@[1.12-2.0.4,)", acceptedMinecraftVersions = "1.12, 1.12.1, 1.12.2")
@Mod.EventBusSubscriber
public class AcrossTheGalaxy
{
    public static final String MODID = "lcm-atg";
    public static final String NAME = "Doctor who - Across the galaxy";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityWeepingAngel.class, new RenderEntityBase(new ModelWeepingAngel(), "weeping_angel", 1.0F));
    }

}
