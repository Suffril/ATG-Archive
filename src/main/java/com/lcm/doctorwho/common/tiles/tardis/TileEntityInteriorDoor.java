package com.lcm.doctorwho.common.tiles.tardis;

import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageRequestChunks;
import com.lcm.doctorwho.utils.ATGTeleporter;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityInteriorDoor extends TileEntity implements ITickable {

	protected static final AxisAlignedBB tardis_exit_AABB = new AxisAlignedBB(-1, 0, 0.1, 1, 2,0.2);

	public int cameraID = -1;

	public int modelID;
	public boolean doorOpen = false;
	public int exteriorDim;
	public BlockPos exteriorPos = new BlockPos(0, 0, 0);

	public TileEntityInteriorDoor() { }

	@Override public NBTTagCompound getUpdateTag() {
		return writeToNBT();
	}

	@Override public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(getPos(), 1, writeToNBT());
	}

	@Override public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
		ATGNetwork.INSTANCE.sendToServer(new MessageRequestChunks(exteriorPos.getX() >> 4, exteriorPos.getZ() >> 4, 5, exteriorDim));
	}

	@Override public void readFromNBT(NBTTagCompound nbt) {
		modelID = nbt.getInteger("modelID");
		doorOpen = nbt.getBoolean("doorOpen");
		exteriorPos = new BlockPos(nbt.getInteger("exteriorX"), nbt.getInteger("exteriorY"), nbt.getInteger("exteriorZ"));
		exteriorDim = nbt.getInteger("exteriorDim");
		super.readFromNBT(nbt);
	}

	@Override public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		tag.setInteger("modelID", modelID);
		tag.setBoolean("doorOpen", doorOpen);
		tag.setInteger("exteriorX", exteriorPos.getX());
		tag.setInteger("exteriorY", exteriorPos.getY());
		tag.setInteger("exteriorZ", exteriorPos.getZ());
		tag.setInteger("exteriorDim", exteriorDim);
		super.writeToNBT(tag);
		return tag;
	}

	private NBTTagCompound writeToNBT() {
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override @SideOnly(Side.CLIENT) public AxisAlignedBB getRenderBoundingBox() {
		return super.getRenderBoundingBox().grow(8, 8, 8);
	}

	@Override public void update() {
		if (!world.isRemote)
			for (Entity e : world.getEntitiesWithinAABB(Entity.class, tardis_exit_AABB.offset(getPos())))
				ATGTeleporter.changeDim(e, exteriorDim, exteriorPos.north());
	}
}
