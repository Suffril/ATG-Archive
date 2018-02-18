package com.lcm.doctorwho.common.init;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@GameRegistry.ObjectHolder(AcrossTheGalaxy.MODID)
@Mod.EventBusSubscriber
public class ATGItems {

    public static List<Item> ITEMS = new ArrayList<>();

    public static final Item test = null;

    @SubscribeEvent
    public static final void register(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> reg = event.getRegistry();

//        reg(reg,
//                new ItemBase("test").setCreativeTab(ATGTabs.MAIN_TAB)
//        );
//TODO
        if(ATGUtils.isClient()){
            ATGUtils.itemRenders();
        }

    }


    private static void reg(IForgeRegistry<Item> reg, Item... items){
        for(Item item : items){
            ITEMS.add(item);
        }
        reg.registerAll(items);
    }



}
