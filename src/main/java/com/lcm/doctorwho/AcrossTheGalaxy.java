package com.lcm.doctorwho;

import com.lcm.doctorwho.client.models.entity.ModelWeepingAngel;
import com.lcm.doctorwho.client.render.entity.RenderEntityBase;
import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import org.apache.logging.log4j.Logger;

import com.lcm.doctorwho.config.ATGConfig;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = AcrossTheGalaxy.MODID, name = AcrossTheGalaxy.NAME, version = AcrossTheGalaxy.VERSION, dependencies = "required:forge@[14.23.1.2574,); required-after:lucraftcore@[1.12-2.0.4,)", acceptedMinecraftVersions = "1.12, 1.12.1, 1.12.2")
@Mod.EventBusSubscriber
public class AcrossTheGalaxy
{
    public static final String MODID = "lcm-atg";
    public static final String NAME = "Doctor who - Across the galaxy";
    public static final String VERSION = "1.0";

    private static Logger LOG;

    public static final ResourceLocation ICONS = new ResourceLocation(MODID, "textures/gui/ability_icons.png");

    public static FMLCommonHandler FML = FMLCommonHandler.instance();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOG = event.getModLog();
        ATGConfig.init(new Configuration(event.getSuggestedConfigurationFile()), event.getSide());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        LOG.info("Entered " + MODID + " init stage");

        RenderingRegistry.registerEntityRenderingHandler(EntityWeepingAngel.class, new RenderEntityBase(new ModelWeepingAngel(), "weeping_angel", 1.0F));

    }

}
