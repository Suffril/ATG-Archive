package com.lcm.doctorwho.networking.packets;

import com.lcm.doctorwho.common.capabilities.tardis.capability.CapabilityTardisChunk;
import com.lcm.doctorwho.utils.ATGConfig;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Nictogen on 3/20/18.
 */
public class MessageRequestTardisChunkDataSync implements IMessage {

	private ChunkPos chunk;

	public MessageRequestTardisChunkDataSync() {
	}

	public MessageRequestTardisChunkDataSync(Chunk chunk) {
		this.chunk = chunk.getPos();
	}

	@Override public void fromBytes(ByteBuf buf) {
		chunk = new ChunkPos(buf.readInt(), buf.readInt());
	}

	@Override public void toBytes(ByteBuf buf) {
		buf.writeInt(chunk.x);
		buf.writeInt(chunk.z);
	}

	public static class Handler implements IMessageHandler<MessageRequestTardisChunkDataSync, IMessage> {

		@Override public IMessage onMessage(MessageRequestTardisChunkDataSync message, MessageContext ctx) {
			Chunk c = ctx.getServerHandler().player.world.getMinecraftServer().getWorld(ATGConfig.tardisDIM).getChunkProvider().provideChunk(message.chunk.x, message.chunk.z);
			if (c != null && c.hasCapability(CapabilityTardisChunk.TARDIS_CAP, null))
				return new MessageSyncTardisChunkData(c, c.getCapability(CapabilityTardisChunk.TARDIS_CAP, null).writeNBT());
			return null;
		}
	}
}
