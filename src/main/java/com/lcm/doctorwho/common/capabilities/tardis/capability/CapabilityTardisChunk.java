package com.lcm.doctorwho.common.capabilities.tardis.capability;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageRequestTardisChunkDataSync;
import com.lcm.doctorwho.networking.packets.MessageSyncTardisChunkData;
import com.lcm.doctorwho.utils.ATGConfig;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Nictogen on 3/19/18.
 */
@Mod.EventBusSubscriber public class CapabilityTardisChunk implements ITardisChunkCapability {

	@CapabilityInject(ITardisChunkCapability.class) public static final Capability<ITardisChunkCapability> TARDIS_CAP = null;

	private Chunk chunk;

	private int exteriorDim;
	private BlockPos exteriorPos;

	public CapabilityTardisChunk(Chunk chunk) {
		this.chunk = chunk;
	}

	public static ITardisChunkCapability getTardisChunkCapability(World w, BlockPos pos) {
		Chunk c = w.getChunkFromChunkCoords(pos.getX() >> 4, pos.getZ() >> 4);
		ITardisChunkCapability cap = c.getCapability(TARDIS_CAP, null);
		if (cap != null && w.isRemote && cap.getExteriorPos() == null)
			ATGNetwork.INSTANCE.sendToServer(new MessageRequestTardisChunkDataSync(c));
		return cap;
	}

	@SubscribeEvent public static void onAttachCapabilities(AttachCapabilitiesEvent<Chunk> event) {
		if (event.getObject().hasCapability(TARDIS_CAP, null))
			return;
		if (event.getObject().x % 4 == 0 && event.getObject().z % 4 == 0 && event.getObject().getWorld().provider.getDimension() == ATGConfig.tardisDIM)
			event.addCapability(new ResourceLocation(AcrossTheGalaxy.MODID, "tardis_chunk"), new CapabilityTardisChunk.CapabilityTardisChunkProvider(new CapabilityTardisChunk(event.getObject())));
	}

	@SubscribeEvent public static void onChunkLoad(ChunkEvent.Load event) {
		Boolean b = event.getChunk().getWorld().isRemote;
		if (event.getChunk().hasCapability(TARDIS_CAP, null)) {
			event.getChunk().getCapability(TARDIS_CAP, null).syncToAll();
		}
	}

	@SubscribeEvent public static void onChunkLoad(ChunkDataEvent.Load event) {
		if (event.getChunk().hasCapability(TARDIS_CAP, null)) {
			event.getChunk().getCapability(TARDIS_CAP, null).syncToAll();
		}
	}

	@Override public NBTTagCompound writeNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		if (exteriorPos != null) {
			tag.setInteger("exteriorX", exteriorPos.getX());
			tag.setInteger("exteriorY", exteriorPos.getY());
			tag.setInteger("exteriorZ", exteriorPos.getZ());
		}
		tag.setInteger("exteriorDim", exteriorDim);
		return tag;
	}

	@Override public void readNBT(NBTTagCompound nbt) {
		if (nbt.hasKey("exteriorX"))
			exteriorPos = new BlockPos(nbt.getInteger("exteriorX"), nbt.getInteger("exteriorY"), nbt.getInteger("exteriorZ"));
		exteriorDim = nbt.getInteger("exteriorDim");
	}

	@Override public void syncToAll() {
		ATGNetwork.INSTANCE.sendToDimension(new MessageSyncTardisChunkData(this.chunk, this.writeNBT()), chunk.getWorld().provider.getDimension());
	}

	@Override public int getExteriorDim() {
		return exteriorDim;
	}

	@Override public void setExteriorDim(int dim) {
		exteriorDim = dim;
	}

	@Override public BlockPos getExteriorPos() {
		return exteriorPos;
	}

	@Override public void setExteriorPos(BlockPos pos) {
		exteriorPos = pos;
	}

	public static class CapabilityTardisChunkProvider implements ICapabilitySerializable<NBTTagCompound> {

		private ITardisChunkCapability capability;

		public CapabilityTardisChunkProvider(ITardisChunkCapability capability) {
			this.capability = capability;
		}

		@Override public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
			return TARDIS_CAP != null && capability == TARDIS_CAP;
		}

		@Nullable @Override public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
			return capability == TARDIS_CAP ? TARDIS_CAP.cast(this.capability) : null;
		}

		@Override public NBTTagCompound serializeNBT() {
			return (NBTTagCompound) TARDIS_CAP.getStorage().writeNBT(TARDIS_CAP, this.capability, null);
		}

		@Override public void deserializeNBT(NBTTagCompound nbt) {
			TARDIS_CAP.getStorage().readNBT(TARDIS_CAP, this.capability, null, nbt);
		}
	}

	public static class Storage implements Capability.IStorage<ITardisChunkCapability> {

		@Nullable @Override public NBTBase writeNBT(Capability<ITardisChunkCapability> capability, ITardisChunkCapability instance, EnumFacing side) {
			return instance.writeNBT();
		}

		@Override public void readNBT(Capability<ITardisChunkCapability> capability, ITardisChunkCapability instance, EnumFacing side, NBTBase nbt) {
			instance.readNBT((NBTTagCompound) nbt);
		}
	}
}
