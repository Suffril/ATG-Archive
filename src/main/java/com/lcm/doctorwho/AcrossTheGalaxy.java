package com.lcm.doctorwho;

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
import org.apache.logging.log4j.Logger;

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
    }

    @SubscribeEvent
    public static void registerLoot(LootTableLoadEvent e) { //TODO can this loot table actually be overriden in resource packs?
        if (!e.getName().toString().toLowerCase().matches(ATGConfig.lootRegex) || ATGConfig.disableArch) return;

        LootCondition[] condAlways = new LootCondition[] { new RandomChance(1F) };
        LootEntry entry = new LootEntryTable(new ResourceLocation(MODID, "inject/arch_loot"), 1, 1, condAlways, "lcm-regen:arch-entry");
        LootPool lootPool = new LootPool(new LootEntry[] { entry }, condAlways, new RandomValueRange(1), new RandomValueRange(1), "lcm-regen:arch-pool");
        e.getTable().addPool(lootPool);
    }



}
