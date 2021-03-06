package com.lcm.doctorwho.common.traits.positive;

import com.lcm.doctorwho.AcrossTheGalaxy;
import lucraft.mods.lucraftcore.superpowers.SuperpowerHandler;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityConstant;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by AFlyingGrayson on 9/3/17
 *
 * @formatter:off
 */
public class TraitSneaky extends AbilityConstant {

	public TraitSneaky(EntityPlayer player) {
		super(player);
	}

	@SubscribeEvent public static void onVisibilityCalc(PlayerEvent.Visibility event) {
		if (SuperpowerHandler.getSuperpowerPlayerHandler(event.getEntityPlayer()) == null)
			return;
		List<Ability> abilityList = SuperpowerHandler.getSuperpowerPlayerHandler(event.getEntityPlayer()).getAbilities();
		if (abilityList == null)
			return;
		for (Ability ability : abilityList)
			if (ability instanceof TraitSneaky && ability.isUnlocked())
				event.modifyVisibility(0.5);
	}

	@Override public boolean showInAbilityBar() {
		return false;
	}

	@SideOnly(Side.CLIENT) @Override public void drawIcon(Minecraft mc, Gui gui, int x, int y) {
		mc.renderEngine.bindTexture(AcrossTheGalaxy.ICONS);
		gui.drawTexturedModalRect(x, y, 0, 0, 16, 16);
	}

	@Override public void updateTick() {
	}
}
