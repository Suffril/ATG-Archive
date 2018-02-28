package com.lcm.doctorwho.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ATGTabs {
	public static CreativeTabs TABS_BLOCKS_TARDIS = new TabBase("tardis", Item.getItemFromBlock(ATGObjects.Blocks.creamRoundel));
	public static CreativeTabs TABS_ITEMS_SONICS = new TabBase("sonics", Items.CAKE);
	
	private static class TabBase extends CreativeTabs {
		
		private ItemStack stack = null;
		
		public TabBase(String label, Item item) {
			super(label);
			stack = new ItemStack(item);
		}
		
		@Override
		public ItemStack getTabIconItem() {
			return stack;
		}
		
	}
}
