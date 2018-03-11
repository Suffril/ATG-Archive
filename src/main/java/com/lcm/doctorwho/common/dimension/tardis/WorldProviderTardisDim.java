package com.lcm.doctorwho.common.dimension.tardis;

import javax.annotation.Nullable;

import com.lcm.doctorwho.common.dimension.ATGDims;

import lucraft.mods.lucraftcore.space.dimension.ChunkGeneratorSpace;
import lucraft.mods.lucraftcore.space.dimension.SpaceSkyRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderTardisDim extends WorldProvider {

    public WorldProviderTardisDim() {

    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorSpace(this.world);
    }

    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0.0F;
    }

    /**
     * Returns array with sunrise/sunset colors
     */
    @Override
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
        return new float[] { 0, 0, 0, 1F };
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isSkyColored() {
        return false;
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    @Override
    public boolean canRespawnHere() {
        return false;
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public int getHeight() {
        return 256;
    }

    @Override
    public int getActualHeight() {
        return 256;
    }

    @Override
    public DimensionType getDimensionType() {
        return ATGDims.tardisDim;
    }

    @Override
    public boolean shouldMapSpin(String entity, double x, double z, double rotation) {
        return true;
    }

    @Override
    public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
        return new Vec3d(0, 0, 0);
    }

    @Override
    public float getStarBrightness(float par1) {
        return 0.8F;
    }

    /**
     * Return Vec3D with biome specific fog color
     */
    @Override
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
        return new Vec3d(0, 0, 0);
    }

    @SideOnly(Side.CLIENT)
    @Nullable
    @Override
    public IRenderHandler getSkyRenderer() {
        if (super.getSkyRenderer() == null)
            this.setSkyRenderer(new SpaceSkyRenderer(world));
        return super.getSkyRenderer();
    }
}