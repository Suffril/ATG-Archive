package com.lcm.doctorwho.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ATGTabs {
    public static final CreativeTabs MAIN_TAB = new TabBase("maintab", Items.CAKE);
}




class TabBase extends CreativeTabs {

    private static ItemStack stack = new ItemStack(Items.CAKE);

    public TabBase(String label, Item item) {
        super(label);
        stack = new ItemStack(item);
        this.setBackgroundImageName("main.png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return stack;
    }

}