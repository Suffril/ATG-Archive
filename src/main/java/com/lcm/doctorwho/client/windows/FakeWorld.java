package com.lcm.doctorwho.client.windows;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.GameType;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;

public class FakeWorld extends WorldClient
{

	public FakeWorld(int dimensionID) {
		super(Minecraft.getMinecraft().getConnection(), new WorldSettings(0L, GameType.SURVIVAL, true, false, WorldType.DEFAULT), dimensionID, Minecraft.getMinecraft().gameSettings.difficulty, Minecraft.getMinecraft().world.profiler);
	}

	@Override
	public void playSound(double x, double y, double z, SoundEvent soundIn, SoundCategory category, float volume, float pitch, boolean distanceDelay) {}

	@Override
	public void makeFireworks(double x, double y, double z, double motionX, double motionY, double motionZ, NBTTagCompound compound) { }
}
