package com.lcm.doctorwho.common.items;

import com.lcm.doctorwho.events.ATGClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemHatOutline extends ItemArmor {

	public ItemHatOutline(String name) {
		super(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

	public ItemHatOutline(String name, ArmorMaterial mat) {
		super(mat, 0, EntityEquipmentSlot.HEAD);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

	@SideOnly(Side.CLIENT) public ModelBiped getModel() {
		return ATGClientProxy.CLOTHING.get(this);
	}

	/**
	 * Override this method to have an item handle its own armor rendering.
	 *
	 * @param entityLiving The entity wearing the armor
	 * @param itemStack    The itemStack to render the model of
	 * @param armorSlot    The slot the armor is in
	 * @param _default     Original armor model. Will have attributes set.
	 * @return A ModelBiped to render instead of the default
	 */
	@SideOnly(Side.CLIENT) @Nullable @Override public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default) {
		return getModel();
	}

	/**
	 * Called when the equipped item is right clicked.
	 */
	@Override public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		EntityEquipmentSlot entityequipmentslot = EntityLiving.getSlotForItemStack(itemstack);
		ItemStack itemstack1 = playerIn.getItemStackFromSlot(entityequipmentslot);

		if (itemstack1.isEmpty()) {
			playerIn.setItemStackToSlot(entityequipmentslot, itemstack.copy());
			itemstack.setCount(0);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		} else {
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		}
	}

}
