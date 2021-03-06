package com.lcm.doctorwho.common.traits.negative;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.traits.positive.TraitSpry;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAttributeModifier;
import lucraft.mods.lucraftcore.util.attributes.LCAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.UUID;

/**
 * Created by AFlyingGrayson on 8/10/17
 */
public class TraitClumsy extends AbilityAttributeModifier implements INegativeTrait {

	public TraitClumsy(EntityPlayer player, UUID uuid, float factor, int operation) {
		super(player, uuid, factor, operation);
	}

	@Override public IAttribute getAttribute() {
		return LCAttributes.JUMP_HEIGHT;
	}

	@Override public Class<? extends Ability> getPositiveTrait() {
		return TraitSpry.class;
	}

	@SideOnly(Side.CLIENT) @Override public void drawIcon(Minecraft mc, Gui gui, int x, int y) {
		mc.renderEngine.bindTexture(AcrossTheGalaxy.ICONS);
		gui.drawTexturedModalRect(x, y, 16, 0, 16, 16);
	}
}
