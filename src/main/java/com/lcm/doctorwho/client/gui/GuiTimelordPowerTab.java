package com.lcm.doctorwho.client.gui;

import com.lcm.doctorwho.common.superpower.TimelordSuperpowerHandler;
import lucraft.mods.lucraftcore.superpowers.SuperpowerHandler;
import lucraft.mods.lucraftcore.superpowers.gui.GuiSuperpowerAbilities;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;

public class GuiTimelordPowerTab extends GuiSuperpowerAbilities {
	
	public GuiTimelordPowerTab(EntityPlayer player) {
		super(player);
	}
	
	@Override
	public void initGui() {
		super.initGui();
		buttonList.removeIf(button -> button.displayString.equals("?"));
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);

		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		
		TimelordSuperpowerHandler handler = SuperpowerHandler.getSpecificSuperpowerPlayerHandler(player, TimelordSuperpowerHandler.class);
		
		if (handler.regenerationsLeft != -1) {
			String txtCount = StringHelper.translateToLocal("lcm-atg.messages.regenLeft", handler.regenerationsLeft);
			int xCount = (this.width - i) - mc.fontRenderer.getStringWidth(txtCount) - 20;
			mc.fontRenderer.drawString(TextFormatting.DARK_GRAY + txtCount, xCount, j + 165 + 5, 0x373737);
		}
	}
	
}
