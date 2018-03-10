package com.lcm.doctorwho.client.windows;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;

import java.util.ArrayList;
import java.util.Objects;

public class FakeWorld extends WorldClient
{

	private static ArrayList<FakeWorld> fakeWorlds = new ArrayList<>();

	public static FakeWorld getFakeWorld(int dimensionID){
		if(fakeWorlds.stream().noneMatch(world -> world.dimensionID == dimensionID))
		{
			FakeWorld fakeWorld = new FakeWorld(dimensionID);
			fakeWorlds.add(fakeWorld);
			return fakeWorld;
		} else return fakeWorlds.stream().filter(world -> world.dimensionID == dimensionID).findAny().get();
	}

	public EntityCamera getCamera(int entityID, BlockPos pos)
	{
		Entity[] entities = loadedEntityList.stream().filter(entity -> entity instanceof EntityCamera && entity.getEntityId() == entityID).toArray(Entity[]::new);
		if(entities.length == 0){
			EntityCamera camera = new EntityCamera(this, 0.5, 1, 0.5);
			this.spawnEntity(camera);
			return camera;
		} else return (EntityCamera) entities[0];
	}

	public FakeRenderGlobal renderGlobal = new FakeRenderGlobal(Minecraft.getMinecraft());

	private int dimensionID;

	private FakeWorld(int dimensionID) {
		super(Objects.requireNonNull(Minecraft.getMinecraft().getConnection()), new WorldSettings(0L, GameType.SURVIVAL, true, false, WorldType.DEFAULT), dimensionID, Minecraft.getMinecraft().gameSettings.difficulty, Minecraft.getMinecraft().world.profiler);
		renderGlobal.setWorldAndLoadRenderers(this);
		this.dimensionID = dimensionID;
	}

	@Override
	public void playSound(double x, double y, double z, SoundEvent soundIn, SoundCategory category, float volume, float pitch, boolean distanceDelay) {}

	@Override
	public void makeFireworks(double x, double y, double z, double motionX, double motionY, double motionZ, NBTTagCompound compound) { }

	public class FakeRenderGlobal extends RenderGlobal
	{
		public FakeRenderGlobal(Minecraft mcIn)
		{
			super(mcIn);
		}

		@Override public void renderSky(float partialTicks, int pass)
		{
			super.renderSky(partialTicks, pass);
		}
	}
}
