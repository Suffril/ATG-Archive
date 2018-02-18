package com.lcm.doctorwho.common.init;

import com.lcm.doctorwho.AcrossTheGalaxy;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;


@Mod.EventBusSubscriber(modid = AcrossTheGalaxy.MODID)
public class ATGEntities {

    private static int regID = 0;

    @SubscribeEvent
    public static void RegisterEntities(RegistryEvent.Register<EntityEntry> event) {

        EntityEntry[] entity = {
                
        };

        event.getRegistry().registerAll(entity);
    }

    private static <E extends Entity> EntityEntryBuilder<E> createEntity(String name) {
        EntityEntryBuilder<E> builder = EntityEntryBuilder.create();
        return builder.id(new ResourceLocation(AcrossTheGalaxy.MODID, name), regID++).name(name.replaceAll(AcrossTheGalaxy.MODID + ":", ""));
    }
}
