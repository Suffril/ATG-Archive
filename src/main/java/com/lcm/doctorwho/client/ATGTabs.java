package com.lcm.doctorwho.client;

import com.lcm.doctorwho.common.init.ATGObjects;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ATGTabs {
	public static CreativeTabs TABS_BLOCKS_TARDIS = new TabBase("tardis", Item.getItemFromBlock(ATGObjects.Blocks.CreamRoundel));
	public static CreativeTabs TABS_ITEMS_SONICS = new TabBase("sonics", Items.CAKE);
	
	static class TabBase extends CreativeTabs {
		
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
