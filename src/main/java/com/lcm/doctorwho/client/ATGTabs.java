package com.lcm.doctorwho.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ATGTabs {
    public final CreativeTabs TABS_BLOCKS_TARDIS = new TabBase("tardis", Items.CAKE);
    public final CreativeTabs TABS_ITEMS_SONICS = new TabBase("sonics", Items.CAKE);
}

class TabBase extends CreativeTabs {

    private static ItemStack stack = new ItemStack(Items.CAKE);

    public TabBase(String label, Item item) {
        super(label);
        stack = new ItemStack(item);
    }

    @Override
    public ItemStack getTabIconItem() {
        return stack;
    }

}