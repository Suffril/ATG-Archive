package com.lcm.doctorwho.common.init;

import java.util.ArrayList;
import java.util.List;

import com.lcm.doctorwho.AcrossTheGalaxy;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(AcrossTheGalaxy.MODID)
@Mod.EventBusSubscriber(modid = AcrossTheGalaxy.MODID)
public class ATGSounds {

    public static final SoundEvent TEST = null;

    @SubscribeEvent
    public static void addSounds(RegistryEvent.Register<SoundEvent> event) {
        IForgeRegistry<SoundEvent> reg = event.getRegistry();

        registerSound("test", reg);
    }

    private static void registerSound(String name, IForgeRegistry<SoundEvent> reg) {
        ResourceLocation rl = new ResourceLocation(AcrossTheGalaxy.MODID, name);
        SoundEvent sound = new SoundEvent(rl).setRegistryName(name);
        reg.register(sound);
    }

}
