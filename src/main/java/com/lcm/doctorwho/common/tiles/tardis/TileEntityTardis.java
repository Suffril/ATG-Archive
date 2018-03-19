package com.lcm.doctorwho.common.tiles.tardis;

import com.lcm.doctorwho.common.capabilities.tardis.CapabilityTileTardis;
import com.lcm.doctorwho.common.capabilities.tardis.interfaces.ITardisTile;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageSyncTardis;
import com.lcm.doctorwho.utils.ATGConfig;
import com.lcm.doctorwho.utils.ATGTeleporter;
import com.lcm.doctorwho.utils.TardisUtils;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class TileEntityTardis extends TileEntity implements ITickable {

	AxisAlignedBB tardis_enter_AABB = new AxisAlignedBB(0, 0, 0, 1, 2, 1);

	public int cameraID = -1;

	protected CapabilityTileTardis handler;

	public TileEntityTardis() {
		handler = new CapabilityTileTardis(this);
	}

	@Override public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityTileTardis.TARDIS || super.hasCapability(capability, facing);
	}

	@Override public NBTTagCompound getUpdateTag() {
		return writeToNBT(TardisUtils.tardisWriteToNBT(getCapability(CapabilityTileTardis.TARDIS, null)));
	}

	@Override public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbtTag;
		nbtTag = TardisUtils.tardisWriteToNBT(getCapability(CapabilityTileTardis.TARDIS, null));
		writeToNBT(nbtTag);
		return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
	}

	@Override public void readFromNBT(NBTTagCompound nbt) {
		ITardisTile capa = getCapability(CapabilityTileTardis.TARDIS, null);
		capa = TardisUtils.tardisReadFromNBT(capa, nbt);
		ATGNetwork.INSTANCE.sendToAll(new MessageSyncTardis(pos, TardisUtils.tardisWriteToNBT(capa)));
		super.readFromNBT(nbt);
	}

	@Override public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		tag = TardisUtils.tardisWriteToNBT(getCapability(CapabilityTileTardis.TARDIS, null));
		super.writeToNBT(tag);
		return tag;
	}

	@SuppressWarnings("unchecked") // ASM black magic I presume?
	@Nullable @Override public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		return (T) handler;
	}

	@Override @SideOnly(Side.CLIENT) public AxisAlignedBB getRenderBoundingBox() {
		return super.getRenderBoundingBox().grow(8, 8, 8);
	}

	/**
	 * Like the old updateEntity(), except more generic.
	 */
	@Override public void update() {
		if (!world.isRemote && getCapability(CapabilityTileTardis.TARDIS, null).isDoorOpen()) {
			List<Entity> entities = world.getEntitiesWithinAABB(Entity.class, tardis_enter_AABB.offset(getPos()));
			if (!entities.isEmpty()) {
				for (Entity e : entities) {
					ITardisTile capa = getCapability(CapabilityTileTardis.TARDIS, null);
					ATGNetwork.INSTANCE.sendToAll(new MessageSyncTardis(pos, TardisUtils.tardisWriteToNBT(getCapability(CapabilityTileTardis.TARDIS, null))));
					TardisUtils.TardisInfo info = TardisUtils.loadInfoFromFile(capa.getTardisID());
					ATGTeleporter.changeDim(e, ATGConfig.tardisDIM, info.getInteriorX(), info.getInteriorY(), info.getInteriorZ());
				}
			}

		}
	}
}
