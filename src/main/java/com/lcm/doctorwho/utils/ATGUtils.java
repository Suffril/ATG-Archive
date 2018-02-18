package com.lcm.doctorwho.utils;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.init.ATGBlocks;
import com.lcm.doctorwho.common.init.ATGItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ATGUtils {

    //Common
    //==================================================================================================\\
    public static void playSound(Entity entity, SoundEvent sound) {
        entity.world.playSound(null, entity.posX, entity.posY, entity.posZ, sound, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }

    public static boolean isClient()
    {
        return AcrossTheGalaxy.FML.getSide().isClient();
    }


    //Client
    //==================================================================================================\\

    @SideOnly(Side.CLIENT)
    public static void itemRenders()
    {
        for (int i = 0; i < ATGItems.ITEMS.size(); i++) {
            Item item = ATGItems.ITEMS.get(i);
            ModelResourceLocation mrl = new ModelResourceLocation(AcrossTheGalaxy.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, mrl);
        }
    }

    @SideOnly(Side.CLIENT)
    public static void blockRenders() {
        for (int i = 0; i < ATGBlocks.BLOCKS.size(); i++) {
            Block b = ATGBlocks.BLOCKS.get(i);
            Item item = Item.getItemFromBlock(b);
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(AcrossTheGalaxy.MODID + ":" + b.getUnlocalizedName().substring(5), "inventory"));
        }
    }
}
