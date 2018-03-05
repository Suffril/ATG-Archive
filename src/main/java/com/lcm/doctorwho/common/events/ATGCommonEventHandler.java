package com.lcm.doctorwho.common.events;

import com.lcm.doctorwho.client.windows.EntityWindow;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageChunkData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ATGCommonEventHandler
{

	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event)
	{
		if (event.getEntity() instanceof EntityPlayer)
		{
			World w = event.getEntity().world;
			BlockPos pos = new BlockPos(event.getEntity().posX + 5, event.getEntity().posY, event.getEntity().posZ);
			if(!w.isRemote)
			{
				WorldServer world = w.getMinecraftServer().getWorld(-1);
//				ChunkFinder finder = new ChunkFinder(pos, -1, world.getChunkProvider(), (EntityPlayer) event.getEntity(), 3);
//				while(!finder.findChunks()){
//					System.out.println("and loading loading");
//				}
//				System.out.println("done");
				ATGNetwork.INSTANCE.sendTo(new MessageChunkData(world.getChunkProvider().provideChunk(pos.getX() >> 4, pos.getZ() >> 4), 17), (EntityPlayerMP) event.getEntity());
				EntityWindow window = new EntityWindow(w, pos.getX(), pos.getY(), pos.getZ());
//				EntityWindow second = new EntityWindow(w, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ);
//				window.setPairedWindow(second);
//				second.setPairedWindow(window);
				w.spawnEntity(window);

//				w.spawnEntity(second);
			}
		}
	}
}
