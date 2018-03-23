package com.lcm.doctorwho.common.tiles.tardis;

import com.lcm.doctorwho.client.boti.EntityCamera;
import com.lcm.doctorwho.client.boti.FakeWorld;
import com.lcm.doctorwho.client.boti.ICameraInterface;
import com.lcm.doctorwho.common.capabilities.tardis.capability.CapabilityTardisChunk;
import com.lcm.doctorwho.common.capabilities.tardis.capability.ITardisChunkCapability;
import com.lcm.doctorwho.networking.packets.MessageRequestChunks;
import com.sun.javafx.geom.Vec2d;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.Vec3d;

/**
 * Created by Nictogen on 3/19/18.
 */
public class TileEntityMonitor extends TileEntity implements ICameraInterface {

	private int cameraID = -1;

	@Override public int getCameraID() {
		return cameraID;
	}

	@Override public void setCameraID(int id) {
		this.cameraID = id;
	}

	@Override public int getRenderDimension() {
		ITardisChunkCapability c = CapabilityTardisChunk.getTardisChunkCapability(world, pos);

		return c.getExteriorDim();
	}

	@Override public MessageRequestChunks requestChunks() {
		ITardisChunkCapability c = CapabilityTardisChunk.getTardisChunkCapability(world, pos);

		return new MessageRequestChunks(c.getExteriorPos().getX() >> 4, c.getExteriorPos().getZ() >> 4, 3, 0);
	}

	@Override public boolean isChunkEmpty(FakeWorld world) {
		ITardisChunkCapability c = CapabilityTardisChunk.getTardisChunkCapability(this.world, pos);
		return world.getChunkFromChunkCoords(c.getExteriorPos().getX() >> 4, c.getExteriorPos().getZ() >> 4).isEmpty();
	}

	@Override public Vec3d getCameraSpawnPos() {
		ITardisChunkCapability c = CapabilityTardisChunk.getTardisChunkCapability(world, pos);

		return (c.getExteriorPos() == null) ? null : new Vec3d(c.getExteriorPos().getX(), c.getExteriorPos().getY(), c.getExteriorPos().getZ());
	}

	@Override public void setupOffset(EntityCamera camera, Vec3d tilePos) {
		camera.posY = camera.origin.y - 1;
		camera.posZ = camera.origin.z - 2.5;
		camera.posX = camera.origin.x + 0.5;
		camera.rotationYaw = 0;
		camera.rotationPitch = -15;
	}

	@Override public Vec2d getResolution() {
		return new Vec2d(500, 500);
	}
}
