package com.lcm.doctorwho.common.items.outlines;

import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ItemSonic extends Item {

	private SoundEvent sound = null;

	public ItemSonic(String name, SoundEvent sonicSound) {
		setRegistryName(name);
		setUnlocalizedName(name);
		setMaxStackSize(1);
		sound = sonicSound;
	}

	@Override public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
		ATGUtils.playSound(player, sound);
		return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(handIn));
	}

	@Override public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {

	}
}
