package com.lcm.doctorwho.common.traits.positive;

import java.util.UUID;

import com.lcm.doctorwho.AcrossTheGalaxy;

import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAttributeModifier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** Created by AFlyingGrayson on 8/7/17 */
public class TraitLucky extends AbilityAttributeModifier {

	public TraitLucky(EntityPlayer player, UUID uuid, float factor, int operation) {
		super(player, uuid, factor, operation);
	}

	@Override
	public IAttribute getAttribute() {
		return SharedMonsterAttributes.LUCK;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void drawIcon(Minecraft mc, Gui gui, int x, int y) {
		mc.renderEngine.bindTexture(AcrossTheGalaxy.ICONS);
		gui.drawTexturedModalRect(x, y, 0, 0, 16, 16);
	}
}
