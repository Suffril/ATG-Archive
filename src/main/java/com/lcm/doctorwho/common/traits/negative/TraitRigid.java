package com.lcm.doctorwho.common.traits.negative;

import java.util.UUID;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.traits.positive.TraitBouncy;

import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAttributeModifier;
import lucraft.mods.lucraftcore.util.attributes.LCAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** Created by AFlyingGrayson on 8/15/17 */
public class TraitRigid extends AbilityAttributeModifier implements INegativeTrait {
	
	public TraitRigid(EntityPlayer player, UUID uuid, float factor, int operation) {
		super(player, uuid, factor, operation);
	}
	
	@Override
	public IAttribute getAttribute() {
		return LCAttributes.FALL_RESISTANCE;
	}
	
	@Override
	public Class<? extends Ability> getPositiveTrait() {
		return TraitBouncy.class;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void drawIcon(Minecraft mc, Gui gui, int x, int y) {
		mc.renderEngine.bindTexture(AcrossTheGalaxy.ICONS);
		gui.drawTexturedModalRect(x, y, 16, 0, 16, 16);
	}
}
