package com.lcm.doctorwho.networking.packets;

import com.lcm.doctorwho.common.capabilities.tardis.capability.CapabilityTardisChunk;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Nictogen on 3/19/18.
 */
public class MessageSyncTardisChunkData implements IMessage {

	private Chunk chunk;
	private NBTTagCompound data;

	public MessageSyncTardisChunkData() {
	}

	public MessageSyncTardisChunkData(Chunk chunk, NBTTagCompound data) {
		this.chunk = chunk;
		this.data = data;
	}

	@Override public void fromBytes(ByteBuf buf) {
		int dim = buf.readInt();
		if (dim == Minecraft.getMinecraft().world.provider.getDimension()) {
			chunk = Minecraft.getMinecraft().world.getChunkFromChunkCoords(buf.readInt(), buf.readInt());
			data = ByteBufUtils.readTag(buf);
		}
	}

	@Override public void toBytes(ByteBuf buf) {
		buf.writeInt(chunk.getWorld().provider.getDimension());
		buf.writeInt(chunk.x);
		buf.writeInt(chunk.z);
		ByteBufUtils.writeTag(buf, data);
	}

	public static class Handler implements IMessageHandler<MessageSyncTardisChunkData, IMessage> {

		@Override public IMessage onMessage(MessageSyncTardisChunkData message, MessageContext ctx) {
			if (message.chunk != null && message.chunk.hasCapability(CapabilityTardisChunk.TARDIS_CAP, null)) {
				message.chunk.getCapability(CapabilityTardisChunk.TARDIS_CAP, null).readNBT(message.data);
			}
			return null;
		}
	}
}
