package com.lcm.doctorwho.networking.packets;

import com.lcm.doctorwho.networking.ATGNetwork;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Nictogen on 3/15/18.
 */
public class MessageRequestChunks implements IMessage {
	private int chunkX, radius, chunkZ, dimensionID;

	public MessageRequestChunks() {
	}

	public MessageRequestChunks(int chunkX, int chunkZ, int radius, int dimensionID) {
		this.chunkX = chunkX;
		this.chunkZ = chunkZ;
		this.dimensionID = dimensionID;
		this.radius = radius;
	}

	@Override public void fromBytes(ByteBuf buf) {
		this.chunkX = buf.readInt();
		this.chunkZ = buf.readInt();
		this.dimensionID = buf.readInt();
		this.radius = buf.readInt();
	}

	@Override public void toBytes(ByteBuf buf) {
		buf.writeInt(this.chunkX);
		buf.writeInt(this.chunkZ);
		buf.writeInt(this.dimensionID);
		buf.writeInt(this.radius);
	}

	public static class Handler implements IMessageHandler<MessageRequestChunks, IMessage> {

		@Override public IMessage onMessage(MessageRequestChunks message, MessageContext ctx) {
			ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
				for (int x = message.chunkX - message.radius; x < message.chunkX + message.radius; x++)
					for (int z = message.chunkZ - message.radius; z < message.chunkZ + message.radius; z++)
						ATGNetwork.INSTANCE.sendToAll(new MessageChunkData(ctx.getServerHandler().player.world.getMinecraftServer().getWorld(message.dimensionID).getChunkProvider().provideChunk(x, z), 65535, message.dimensionID));

			});
			return null;
		}
	}
}
