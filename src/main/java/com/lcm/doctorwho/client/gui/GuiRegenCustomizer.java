package com.lcm.doctorwho.client.gui;

import com.lcm.doctorwho.common.capabilities.timelord.capability.ITimelordCapability;
import com.lcm.doctorwho.common.capabilities.timelord.capability.CapabilityTimelord;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageRegenerationStyle;
import lucraft.mods.lucraftcore.superpowers.SuperpowerHandler;
import lucraft.mods.lucraftcore.superpowers.gui.GuiCustomizer;
import lucraft.mods.lucraftcore.util.gui.GuiColorSlider;
import lucraft.mods.lucraftcore.util.helper.LCRenderHelper;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.IClientCommand;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import net.minecraftforge.fml.client.config.GuiSlider;

public class GuiRegenCustomizer extends GuiCustomizer implements GuiSlider.ISlider {

	private float primaryRed;
	private float primaryGreen;
	private float primaryBlue;
	private float secondaryRed;
	private float secondaryGreen;
	private float secondaryBlue;
	private boolean textured;
	private GuiButton texturedButton;

	@Override public void initGui() {
		super.initGui();

		this.xSize = 256;
		this.ySize = 189;
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;

		NBTTagCompound old = mc.player.getCapability(CapabilityTimelord.TIMELORD_CAP, null).getStyle();
		primaryRed = old.getFloat("PrimaryRed");
		primaryGreen = old.getFloat("PrimaryGreen");
		primaryBlue = old.getFloat("PrimaryBlue");
		secondaryRed = old.getFloat("SecondaryRed");
		secondaryGreen = old.getFloat("SecondaryGreen");
		secondaryBlue = old.getFloat("SecondaryBlue");
		textured = old.getBoolean("textured");

		this.buttonList.add(new GuiButtonExt(0, i + 4, j + 167, 50, 18, StringHelper.translateToLocal("lucraftcore.info.save")));
		this.buttonList.add(new GuiButtonExt(1, i + 202, j + 167, 50, 18, StringHelper.translateToLocal("gui.cancel")));
		this.texturedButton = new GuiButton(2, i + this.xSize / 2 - 25, j + 45, 50, 20, StringHelper.translateToLocal(""));
		this.buttonList.add(texturedButton);

		this.buttonList.add(new GuiColorSlider(6, i + 20, j + 90, 80, 20, StringHelper.translateToLocal("lucraftcore.info.red"), "", 0, 1, primaryRed, true, true, this));
		this.buttonList.add(new GuiColorSlider(7, i + 20, j + 110, 80, 20, StringHelper.translateToLocal("lucraftcore.info.green"), "", 0, 1, primaryGreen, true, true, this));
		this.buttonList.add(new GuiColorSlider(8, i + 20, j + 130, 80, 20, StringHelper.translateToLocal("lucraftcore.info.blue"), "", 0, 1, primaryBlue, true, true, this));

		this.buttonList.add(new GuiColorSlider(9, i + 135, j + 90, 80, 20, StringHelper.translateToLocal("lucraftcore.info.red"), "", 0, 1, secondaryRed, true, true, this));
		this.buttonList.add(new GuiColorSlider(10, i + 135, j + 110, 80, 20, StringHelper.translateToLocal("lucraftcore.info.green"), "", 0, 1, secondaryGreen, true, true, this));
		this.buttonList.add(new GuiColorSlider(11, i + 135, j + 130, 80, 20, StringHelper.translateToLocal("lucraftcore.info.blue"), "", 0, 1, secondaryBlue, true, true, this));
	}

	@Override public NBTTagCompound getStyleNBTTag() {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setFloat("PrimaryRed", primaryRed);
		nbt.setFloat("PrimaryGreen", primaryGreen);
		nbt.setFloat("PrimaryBlue", primaryBlue);
		nbt.setFloat("SecondaryRed", secondaryRed);
		nbt.setFloat("SecondaryGreen", secondaryGreen);
		nbt.setFloat("SecondaryBlue", secondaryBlue);
		nbt.setBoolean("textured", textured);
		return nbt;
	}

	@Override protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;

		if (SuperpowerHandler.getSuperpower(mc.player).getPlayerRenderer() != null)
			SuperpowerHandler.getSuperpower(mc.player).getPlayerRenderer().applyColor();

		mc.getTextureManager().bindTexture(GuiCustomizer.DEFAULT_TEX);
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

		String name = StringHelper.translateToLocal("lcm-atg.info.textured");
		int length = mc.fontRenderer.getStringWidth(name);
		this.drawString(mc.fontRenderer, name, i + this.xSize / 2 - length / 2, j + 30, 0xffffff);

		this.texturedButton.displayString = (textured) ? "Yes" : "No";

		name = StringHelper.translateToLocal("lcm-atg.info.primary");
		length = mc.fontRenderer.getStringWidth(name);
		this.drawString(mc.fontRenderer, name, i + 70 - length / 2, j + 75, 0xffffff);

		name = StringHelper.translateToLocal("lcm-atg.info.secondary");
		length = mc.fontRenderer.getStringWidth(name);
		this.drawString(mc.fontRenderer, name, i + 185 - length / 2, j + 75, 0xffffff);

		LCRenderHelper.drawRect(i + 99, j + 90, i + 121, j + 150, 0.1F, 0.1F, 0.1F, 1);
		LCRenderHelper.drawRect(i + 100, j + 91, i + 120, j + 149, primaryRed, primaryGreen, primaryBlue, 1);

		LCRenderHelper.drawRect(i + 214, j + 90, i + 236, j + 150, 0.1F, 0.1F, 0.1F, 1);
		LCRenderHelper.drawRect(i + 215, j + 91, i + 235, j + 149, secondaryRed, secondaryGreen, secondaryBlue, 1);

		this.drawString(mc.fontRenderer, StringHelper.translateToLocal("lucraftcore.info.customizer"), i + 5, j + 5, 0xffffff);
	}

	@Override protected void actionPerformed(GuiButton button) {
		if (button.id == 0)
			ATGNetwork.INSTANCE.sendToServer(new MessageRegenerationStyle(getStyleNBTTag()));
		if (button.id == 0 || button.id == 1) {
			mc.player.closeScreen();
		}
		if (button.id == 2)
			textured = !textured;
	}

	@Override public void onChangeSliderValue(GuiSlider slider) {
		if (slider.id == 6)
			this.primaryRed = (float) slider.sliderValue;
		else if (slider.id == 7)
			this.primaryGreen = (float) slider.sliderValue;
		else if (slider.id == 8)
			this.primaryBlue = (float) slider.sliderValue;
		else if (slider.id == 9)
			this.secondaryRed = (float) slider.sliderValue;
		else if (slider.id == 10)
			this.secondaryGreen = (float) slider.sliderValue;
		else if (slider.id == 11)
			this.secondaryBlue = (float) slider.sliderValue;
	}

	//TODO fix
	public static class CustomizeCommand extends CommandBase implements IClientCommand {

		@Override public String getName() {
			return "customizeregen";
		}

		@Override public String getUsage(ICommandSender sender) {
			return "/customizeregen";
		}

		@Override public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
			if (!(sender.getCommandSenderEntity() instanceof EntityPlayer))
				throw new CommandException("Can only use regeneration debug commands as player", (Object[]) args);
			EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
			ITimelordCapability capability = player.getCapability(CapabilityTimelord.TIMELORD_CAP, null);
			if(capability != null && capability.isTimelord())
				Minecraft.getMinecraft().displayGuiScreen(new GuiRegenCustomizer());
		}

		@Override public boolean allowUsageWithoutPrefix(ICommandSender sender, String message) {
			return true;
		}

		@Override public int getRequiredPermissionLevel() {
			return 0;
		}
	}

}
