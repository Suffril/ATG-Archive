package com.lcm.doctorwho.common.tiles.tardis;

import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageRequestChunks;
import com.lcm.doctorwho.utils.ATGConfig;
import com.lcm.doctorwho.utils.ATGTeleporter;
import com.sun.javafx.geom.Vec2d;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.lcm.doctorwho.AcrossTheGalaxy.MODID;

public class TileEntityTardis extends TileEntity implements ITickable {

	private AxisAlignedBB tardis_enter_AABB = new AxisAlignedBB(0.2, 0, 0, 0.8, 2, 0.1);

	public int cameraID = -1;

	public int modelID;
	public String ownerUUID = "No-one";
	public boolean doorOpen = false;
	public BlockPos interiorPos = new BlockPos(0, 0, 0);

	public TileEntityTardis() { }

	@Override public NBTTagCompound getUpdateTag() {
		return writeToNBT();
	}

	@Override public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(getPos(), 1, writeToNBT());
	}

	@Override public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
		ATGNetwork.INSTANCE.sendToServer(new MessageRequestChunks(interiorPos.getX(), interiorPos.getZ(), 2, ATGConfig.tardisDIM));
	}

	@Override public void readFromNBT(NBTTagCompound nbt) {
		ownerUUID = nbt.getString("ownerUUID");
		modelID = nbt.getInteger("modelID");
		doorOpen = nbt.getBoolean("doorOpen");
		interiorPos = new BlockPos(nbt.getInteger("interiorX"), 0, nbt.getInteger("interiorZ"));
		super.readFromNBT(nbt);
	}

	@Override public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		tag.setString("ownerUUID", ownerUUID);
		tag.setInteger("modelID", modelID);
		tag.setBoolean("doorOpen", doorOpen);
		tag.setInteger("interiorX", interiorPos.getX());
		tag.setInteger("interiorZ", interiorPos.getZ());
		super.writeToNBT(tag);
		return tag;
	}

	private NBTTagCompound writeToNBT() {
		return this.writeToNBT(new NBTTagCompound());
	}

	public BlockPos getInteriorDoorPos() {
		return new BlockPos((interiorPos.getX() << 4) + 8, 70, interiorPos.getZ() << 4);
	}

	@Override @SideOnly(Side.CLIENT) public AxisAlignedBB getRenderBoundingBox() {
		return super.getRenderBoundingBox().grow(8, 8, 8);
	}

	@Override public void update() {
		if (!world.isRemote && doorOpen)
			for (Entity e : world.getEntitiesWithinAABB(Entity.class, tardis_enter_AABB.offset(getPos())))
				ATGTeleporter.changeDim(e, ATGConfig.tardisDIM, getInteriorDoorPos().south());
	}

	public static class TardisWorldData extends WorldSavedData {

		private static final String TARDIS_DATA = MODID + "_TardisWorldData";
		private int nextChunkX = 0, nextChunkZ = 0, max = 0;
		private Direction direction = Direction.RIGHT;

		@SuppressWarnings("unused")
		public TardisWorldData(String string){
			super(string);
		}

		public TardisWorldData() {
			super(TARDIS_DATA);
		}

		@Override public void readFromNBT(NBTTagCompound nbt) {
			nextChunkX = nbt.getInteger("nextChunkX");
			nextChunkZ = nbt.getInteger("nextChunkZ");
			max = nbt.getInteger("max");
			direction = Direction.values()[nbt.getInteger("direction")];
		}

		@Override public NBTTagCompound writeToNBT(NBTTagCompound compound) {
			compound.setInteger("nextChunkX", nextChunkX);
			compound.setInteger("nextChunkZ", nextChunkZ);
			compound.setInteger("max", max);
			compound.setInteger("direction", direction.ordinal());
			return compound;
		}

		//Generates new chunk coordinates in a spiral from 0,0. Adds/Subtracts 4 to leave a 1 chunk gap between
		public Vec2d getNewChunkCoordinates() {
			Vec2d returnChunk = new Vec2d(nextChunkX, nextChunkZ);
			if (direction == Direction.RIGHT && nextChunkX == max)
				max += 4;

			switch (direction) {
				case UP:
					nextChunkZ += 4;
					if (nextChunkZ == max)
						direction = Direction.LEFT;
					break;
				case RIGHT:
					nextChunkX += 4;
					if (nextChunkX == max)
						direction = Direction.UP;
					break;
				case DOWN:
					nextChunkZ -= 4;
					if (nextChunkZ == -max)
						direction = Direction.RIGHT;
					break;
				case LEFT:
					nextChunkX -= 4;
					if (nextChunkX == -max)
						direction = Direction.DOWN;
					break;
			}
			markDirty();
			return returnChunk;
		}

		public static TardisWorldData get(World world) {
			MapStorage storage = world.getPerWorldStorage();
			TardisWorldData instance = (TardisWorldData) storage.getOrLoadData(TardisWorldData.class, TARDIS_DATA);

			if (instance == null) {
				instance = new TardisWorldData();
				storage.setData(TARDIS_DATA, instance);
			}
			return instance;
		}

		private enum Direction {
			RIGHT, DOWN, LEFT, UP
		}
	}
}
