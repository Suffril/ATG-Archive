package com.lcm.doctorwho.common.tiles.tardis;

import com.lcm.doctorwho.client.boti.EntityCamera;
import com.lcm.doctorwho.client.boti.FakeWorld;
import com.lcm.doctorwho.client.boti.ICameraInterface;
import com.lcm.doctorwho.common.capabilities.tardis.capability.CapabilityTardisChunk;
import com.lcm.doctorwho.common.capabilities.tardis.capability.ITardisChunkCapability;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageRequestChunks;
import com.lcm.doctorwho.utils.ATGTeleporter;
import com.sun.javafx.geom.Vec2d;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class TileEntityInteriorDoor extends TileEntity implements ITickable, ICameraInterface {

	protected static final AxisAlignedBB tardis_exit_AABB = new AxisAlignedBB(-1, 0, 0.1, 1, 2,0.2);

	private int cameraID = -1;

	public int modelID;
	public boolean doorOpen = false;

	public TileEntityInteriorDoor() { }

	@Override public NBTTagCompound getUpdateTag() {
		return writeToNBT();
	}

	@Override public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(getPos(), 1, writeToNBT());
	}

	@Override public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
		ITardisChunkCapability c = CapabilityTardisChunk.getTardisChunkCapability(world, pos);
		if (c != null && c.getExteriorPos() != null)
			ATGNetwork.INSTANCE.sendToServer(new MessageRequestChunks(c.getExteriorPos().getX() >> 4, c.getExteriorPos().getZ() >> 4, 5, c.getExteriorDim()));
	}

	@Override public void readFromNBT(NBTTagCompound nbt) {
		modelID = nbt.getInteger("modelID");
		doorOpen = nbt.getBoolean("doorOpen");
		super.readFromNBT(nbt);
	}

	@Override public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		tag.setInteger("modelID", modelID);
		tag.setBoolean("doorOpen", doorOpen);
		super.writeToNBT(tag);
		return tag;
	}

	private NBTTagCompound writeToNBT() {
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override public void update() {
		ITardisChunkCapability c = CapabilityTardisChunk.getTardisChunkCapability(world, pos);
		if (!world.isRemote && c != null && c.getExteriorPos() != null)
			for (Entity e : world.getEntitiesWithinAABB(Entity.class, tardis_exit_AABB.offset(getPos())))
				ATGTeleporter.changeDim(e, c.getExteriorDim(), c.getExteriorPos().north());
	}

	@Override public int getCameraID() {
		return this.cameraID;
	}

	@Override public void setCameraID(int id) {
		this.cameraID = id;
	}

	@Override public int getRenderDimension() {
		ITardisChunkCapability c = CapabilityTardisChunk.getTardisChunkCapability(world, pos);
		return c != null ? c.getExteriorDim() : 0;
	}

	@Override public MessageRequestChunks requestChunks() {
		ITardisChunkCapability c = CapabilityTardisChunk.getTardisChunkCapability(world, pos);
		return new MessageRequestChunks(c.getExteriorPos().getX() >> 4, c.getExteriorPos().getZ() >> 4, 2, c.getExteriorDim());
	}

	@Override public boolean isChunkEmpty(FakeWorld fakeWorld) {
		ITardisChunkCapability c = CapabilityTardisChunk.getTardisChunkCapability(world, pos);

		return fakeWorld.getChunkFromChunkCoords(c.getExteriorPos().getX() >> 4, c.getExteriorPos().getZ() >> 4).isEmpty();
	}

	@Override public Vec3d getCameraSpawnPos() {
		ITardisChunkCapability c = CapabilityTardisChunk.getTardisChunkCapability(world, pos);

		return (c.getExteriorPos() == null) ? null : new Vec3d(c.getExteriorPos().getX(), c.getExteriorPos().getY(), c.getExteriorPos().getZ() - 1);
	}

	@Override public void setupOffset(EntityCamera camera, Vec3d tilePos) {
		EntityPlayer player = Minecraft.getMinecraft().player;

		Vec3d pVec = new Vec3d(player.posX, player.posY, player.posZ);
		Vec3d tVec = new Vec3d(tilePos.x + 0.5, tilePos.y + 0.5, tilePos.z + 0.5);

		Vec3d ref = pVec.add(new Vec3d(0, 0, 100));
		Vec3d diff = ref.subtract(tVec);

		Vec3d projVec = camera.origin.add(diff);

		diff = pVec.subtract(tVec);
		tVec = camera.origin.add(diff.scale(0.2));

		camera.posX = camera.origin.x + diff.x * 0.2;
		camera.posY = camera.origin.y;
		camera.posZ = camera.origin.z - diff.z * 0.2;

		//yaw TODO fix

		double x1 = tVec.x;
		double z1 = tVec.z;

		double x2 = projVec.x;
		double z2 = projVec.z;

		double angleDeg = Math.atan2(z2 - z1, x2 - x1) * 180 / Math.PI;

		if (angleDeg <= 0)
			angleDeg = 360 + angleDeg;

		angleDeg = 90 - (angleDeg);

		camera.rotationYaw = (float) angleDeg - 180;

		//pitch TODO
		//
		//		x1 = tVec.y;
		//		z1 = tVec.z;
		//
		//		x2 = tVec.y;
		//		z2 = projVec.z;
		//
		//		angleDeg = Math.atan2(z2 - z1, x2 - x1) * 180 / Math.PI;
		//
		//		if (angleDeg <= 0)
		//			angleDeg = 360 + angleDeg;
		//		rotationPitch = 0f;
	}

	@Override public Vec2d getResolution() {
		return new Vec2d(500, 500);
	}
}
