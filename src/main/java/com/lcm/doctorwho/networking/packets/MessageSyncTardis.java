package com.lcm.doctorwho.networking.packets;

import com.lcm.doctorwho.common.capabilities.tardis.CapabilityTileTardis;
import com.lcm.doctorwho.common.capabilities.tardis.interfaces.ITardisTile;
import com.lcm.doctorwho.common.tiles.tardis.TileEntityTardis;
import com.lcm.doctorwho.utils.TardisUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSyncTardis implements IMessage {

	public MessageSyncTardis() {
	}

	private BlockPos pos;
	private NBTTagCompound nbt;

	public MessageSyncTardis(BlockPos pos, NBTTagCompound nbt) {
		this.pos = pos;
		this.nbt = nbt;
	}

	@Override public void toBytes(ByteBuf buf) {
		buf.writeLong(pos.toLong());
		ByteBufUtils.writeTag(buf, nbt);
	}

	@Override public void fromBytes(ByteBuf buf) {
		pos = BlockPos.fromLong(buf.readLong());
		nbt = ByteBufUtils.readTag(buf);
	}

	public static class TardisSyncHandler implements IMessageHandler<MessageSyncTardis, IMessage> {

		@Override public IMessage onMessage(MessageSyncTardis message, MessageContext ctx) {
			EntityPlayerSP player = Minecraft.getMinecraft().player;

			Minecraft.getMinecraft().addScheduledTask(() -> {
				TileEntity tile = player.world.getTileEntity(message.pos);

				if (tile instanceof TileEntityTardis) {
					ITardisTile capa = tile.getCapability(CapabilityTileTardis.TARDIS, null);
					capa = TardisUtils.tardisReadFromNBT(capa, message.nbt);
				}
			});

			return null;
		}
	}
}
