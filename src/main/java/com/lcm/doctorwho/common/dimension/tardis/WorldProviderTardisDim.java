package com.lcm.doctorwho.common.dimension.tardis;

import com.lcm.doctorwho.common.dimension.ATGDims;
import com.lcm.doctorwho.events.ATGClientProxy;
import com.lcm.doctorwho.events.ATGObjects;
import lucraft.mods.lucraftcore.space.dimension.ChunkGeneratorSpace;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class WorldProviderTardisDim extends WorldProvider {

	public WorldProviderTardisDim() {

	}

	@Override
	public boolean isBlockHighHumidity(BlockPos pos) {
		return false;
	}

	@Override
	public void calculateInitialWeather() { }

	@Override
	public void updateWeather() { }

	@Override public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorSpace(this.world);
	}

	/**
	 * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
	 */
	@Override public float calculateCelestialAngle(long worldTime, float partialTicks) {
		return 0.0F;
	}

	/**
	 * Returns array with sunrise/sunset colors
	 */
	@Override @SideOnly(Side.CLIENT) public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
		return new float[] { 0, 0, 0, 1F };
	}

	@Override @SideOnly(Side.CLIENT) public boolean isSkyColored() {
		return false;
	}

	/**
	 * True if the player can respawn in this dimension (true = overworld, false = nether).
	 */
	@Override public boolean canRespawnHere() {
		return false;
	}

	/**
	 * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
	 */
	@Override public boolean isSurfaceWorld() {
		return false;
	}

	@Override public int getHeight() {
		return 256;
	}

	@Override public int getActualHeight() {
		return 256;
	}

	@Override public DimensionType getDimensionType() {
		return ATGDims.tardisDim;
	}

	@Override public boolean shouldMapSpin(String entity, double x, double z, double rotation) {
		return false;
	}

	@Override public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
		return new Vec3d(0, 0, 0);
	}

	@Override public float getStarBrightness(float par1) {
		return 0.0F;
	}

	/**
	 * Return Vec3D with biome specific fog color
	 */
	@Override public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		return new Vec3d(0, 0, 0);
	}

	@SideOnly(Side.CLIENT) @Nullable @Override public IRenderHandler getSkyRenderer() {
		return null;
	}

    /**
     * Called on the client to get the music type to play when in this world type.
     * At the time of calling, the client player and world are guaranteed to be non-null
     * @return null to use vanilla logic, otherwise a MusicType to play in this world
     */
    @Nullable
    @SideOnly(Side.CLIENT)
    public net.minecraft.client.audio.MusicTicker.MusicType getMusicType()
    {
        return MusicTicker.MusicType.valueOf("TARDIS_HUM");
    }

}
