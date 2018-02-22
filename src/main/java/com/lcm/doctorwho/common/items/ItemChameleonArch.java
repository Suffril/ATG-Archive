package com.lcm.doctorwho.common.items;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.init.ATGObjects;
import com.lcm.doctorwho.common.superpower.TimelordSuperpower;
import com.lcm.doctorwho.common.superpower.TimelordSuperpowerHandler;
import com.lcm.doctorwho.config.ATGConfig;

import lucraft.mods.lucraftcore.superpowers.SuperpowerHandler;
import lucraft.mods.lucraftcore.superpowers.SuperpowerPlayerHandler;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/** Created by AFlyingGrayson on 8/28/17 */
public class ItemChameleonArch extends Item {
	
	public ItemChameleonArch() { // TODO how does combining/repairing work out?
		setUnlocalizedName("chameleonArch");
		setRegistryName(AcrossTheGalaxy.MODID, "chameleonarch");
		setCreativeTab(CreativeTabs.MISC);
		setMaxStackSize(1);
		setMaxDamage(ATGConfig.regenCapacity);
	}
	
	@Override // TODO where did the "new life" message go?
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack arch = player.getHeldItem(hand);
		SuperpowerPlayerHandler handler = SuperpowerHandler.getSuperpowerPlayerHandler(player);

		if(arch.getTagCompound() == null) {
			arch.setTagCompound(new NBTTagCompound());
			arch.getTagCompound().setBoolean("open", true);
		}

		if (ATGConfig.regenCapacity == 0) { // with infinite regenerations the behavior is quite different
			if (handler == null) {
                arch.getTagCompound().setBoolean("open", true);
				SuperpowerHandler.setSuperpower(player, TimelordSuperpower.INSTANCE);
				SuperpowerHandler.getSpecificSuperpowerPlayerHandler(player, TimelordSuperpowerHandler.class).regenerationsLeft = -1;
				player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.becomeTimelord")), true);
                arch.getTagCompound().setBoolean("open", false);
				return new ActionResult<>(EnumActionResult.PASS, arch);
			} else {
				player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.alreadyTimelord")), true);
				return new ActionResult<>(EnumActionResult.FAIL, arch);
			}
		}
		
		if (handler == null) {
			if (arch.getItemDamage() == ATGConfig.regenCapacity) {
				player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.emptyArch")), true);
				return new ActionResult<>(EnumActionResult.FAIL, arch);
			}
			
			SuperpowerHandler.setSuperpower(player, TimelordSuperpower.INSTANCE);
			
			int used = doUsageDamage(arch, SuperpowerHandler.getSpecificSuperpowerPlayerHandler(player, TimelordSuperpowerHandler.class));
			if (arch.getItemDamage() < ATGConfig.regenCapacity) throw new RuntimeException("Did not fully use arch when receiving superpower (" + used + "," + arch.getCount() + ")");
			
			player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.becomeTimelord")), true);
		} else if (handler instanceof TimelordSuperpowerHandler) {
			TimelordSuperpowerHandler tmh = ((TimelordSuperpowerHandler) handler);
			
			if (!player.isSneaking()) {
				int used = doUsageDamage(arch, tmh);
				if (used == 0) {
                    if (tmh.regenerationsLeft == ATGConfig.regenCapacity) {
                        arch.getTagCompound().setBoolean("open", false);
                    player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.transfer.fullCycle", used)), true);
                }
                else if (arch.getItemDamage() == ATGConfig.regenCapacity) player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.transfer.emptyArch", used)), true);
					return new ActionResult<>(EnumActionResult.FAIL, arch);
				}
				player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.gainedRegenerations", used)), true); // too lazy to fix a single/plural issue here
			} else {
				if (arch.getItemDamage() == 0) {

					player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.transfer.fullArch")), true);
					return new ActionResult<>(EnumActionResult.FAIL, arch);
				} else if (tmh.regenerationsLeft < 1) {
					player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.transfer.emptyCycle")), true);
					return new ActionResult<>(EnumActionResult.FAIL, arch);
				}
				
				// TODO sound effect?
				arch.setItemDamage(arch.getItemDamage() - 1);
				tmh.regenerationsLeft--;
				player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.transfer")), true);
				arch.getTagCompound().setBoolean("open", false);
			}
		} else
			return new ActionResult<>(EnumActionResult.FAIL, arch);
		
		player.world.playSound(null, player.posX, player.posY, player.posZ, ATGObjects.SoundEvents.TIMEY_WIMEY, SoundCategory.PLAYERS, 1.0F, 1.0F);
		return new ActionResult<>(EnumActionResult.PASS, arch);
	}
	
	private int doUsageDamage(ItemStack stack, TimelordSuperpowerHandler handler) {
		int supply = ATGConfig.regenCapacity - stack.getItemDamage(), needed = ATGConfig.regenCapacity - handler.regenerationsLeft, used = Math.min(supply, needed);
		
		if (used == 0) return 0;
		
		handler.regenerationsLeft += used;
		stack.setItemDamage(stack.getItemDamage() + used);
		SuperpowerHandler.syncToAll(handler.getPlayer());
		return used;
	}
}
