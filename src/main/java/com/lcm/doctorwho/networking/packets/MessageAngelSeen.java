package com.lcm.doctorwho.networking.packets;

import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageAngelSeen implements IMessage {
	
	public MessageAngelSeen(){}
	
	private int angelID;
	public MessageAngelSeen(int angelID) {
		this.angelID = angelID;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(angelID);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		angelID = buf.readInt();
	}
	
	public static class AngelSeenHandler implements IMessageHandler<MessageAngelSeen, IMessage> {
		
		@Override
		public IMessage onMessage(MessageAngelSeen message, MessageContext ctx) {
			
			EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
			
			serverPlayer.getServerWorld().addScheduledTask(() -> {
				
				Entity entity = serverPlayer.world.getEntityByID(message.angelID);
				
				if(entity instanceof EntityWeepingAngel)
				{
					EntityWeepingAngel angel = (EntityWeepingAngel) entity;
					angel.setSeen(true);
				}
				
			});
			return null;
		}
	}
}
