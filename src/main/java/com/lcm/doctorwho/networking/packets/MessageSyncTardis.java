package com.lcm.doctorwho.networking.packets;

import com.lcm.doctorwho.common.capabilities.CapabilityTileTardis;
import com.lcm.doctorwho.common.capabilities.iTardis;
import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;

import com.lcm.doctorwho.common.tiles.TileEntityTardis;
import com.lcm.doctorwho.utils.TardisUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sun.plugin2.message.Message;

public class MessageSyncTardis implements IMessage {

    public MessageSyncTardis(){}

    private BlockPos pos;
    private NBTTagCompound nbt;

    public MessageSyncTardis(BlockPos pos, NBTTagCompound nbt) {
        this.pos = pos;
        this.nbt = nbt;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        ByteBufUtils.writeTag(buf, nbt);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        nbt = ByteBufUtils.readTag(buf);
    }

    public static class TardisSyncHandler implements IMessageHandler<MessageSyncTardis, IMessage> {

        @Override
        public IMessage onMessage(MessageSyncTardis message, MessageContext ctx) {

            System.out.println(message.nbt);

            EntityPlayerSP player = Minecraft.getMinecraft().player;

            Minecraft.getMinecraft().addScheduledTask(() -> {
                TileEntity tile = player.world.getTileEntity(message.pos);

                if(tile instanceof TileEntityTardis)
                {
                    iTardis capa = tile.getCapability(CapabilityTileTardis.TARDIS, null);
                    iTardis new_capa = TardisUtils.tardisReadFromNBT(capa, message.nbt);
                    capa = new_capa;
                }
                    });

            return null;
        }
    }
}
