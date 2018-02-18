package com.lcm.doctorwho.common.init;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.blocks.BlockOutline;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@GameRegistry.ObjectHolder(AcrossTheGalaxy.MODID)
@Mod.EventBusSubscriber
public class ATGBlocks {

    public static List<Block> BLOCKS = new ArrayList<>();

    public static final Block TEST = null;

    @SubscribeEvent
    public static final void register(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> reg = event.getRegistry();

        reg(reg,
                new BlockOutline(Material.AIR,"test")
        );

        if(ATGUtils.isClient()){ ATGUtils.blockRenders(); }
    }


    private static void reg(IForgeRegistry<Block> reg, Block... blocks){
        for(Block block : blocks){
            BLOCKS.add(block);
        }
        reg.registerAll(blocks);
    }

}
