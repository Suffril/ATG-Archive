package com.lcm.doctorwho.client.boti;

import com.lcm.doctorwho.common.tiles.tardis.TileEntityTardis;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageRequestChunks;
import com.lcm.doctorwho.utils.ATGConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Nictogen on 2/19/18
 */
@Mod.EventBusSubscriber(Side.CLIENT) public class ATGBOTIHandler {

	//TODO interior doesn't render until you visit the dimension once?
	@SubscribeEvent public static void onRenderTick(TickEvent.RenderTickEvent event) {

		if (event.phase != TickEvent.Phase.END)
			return;
		WorldClient worldClient = Minecraft.getMinecraft().world;
		if (worldClient != null) {
			RenderGlobal renderGlobal = Minecraft.getMinecraft().renderGlobal;

			worldClient.loadedTileEntityList.forEach(tileEntity -> {
				if (tileEntity instanceof TileEntityTardis) {
					FakeWorld fakeWorld = FakeWorld.getFakeWorld(ATGConfig.tardisDIM);
					Minecraft.getMinecraft().world = fakeWorld;
					Minecraft.getMinecraft().getRenderManager().setWorld(fakeWorld);
					Minecraft.getMinecraft().renderGlobal = fakeWorld.renderGlobal;

					BlockPos pos = ((TileEntityTardis) tileEntity).getInteriorDoorPos();
					EntityCamera camera = fakeWorld.getCamera((TileEntityTardis) tileEntity, new Vec3d(pos.getX(), pos.getY(), pos.getZ()).add(new Vec3d(0.0, 0, 0.5)));

					GlStateManager.pushMatrix();
					GlStateManager.pushAttrib();
					camera.renderWorldToTexture(new Vec3d(tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()), event.renderTickTime);
					GlStateManager.popAttrib();
					GlStateManager.popMatrix();

					GlStateManager.enableBlend();
					GlStateManager.disableTexture2D();
					GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
					GlStateManager.enableTexture2D();
					GlStateManager.disableBlend();

					Minecraft.getMinecraft().world = worldClient;
					Minecraft.getMinecraft().renderGlobal = renderGlobal;
					Minecraft.getMinecraft().getRenderManager().setWorld(worldClient);

					if (Minecraft.getMinecraft().world.getTotalWorldTime() % 200 == 0 || fakeWorld.getChunkFromChunkCoords(((TileEntityTardis) tileEntity).interiorPos.getX(), ((TileEntityTardis) tileEntity).interiorPos.getZ()).isEmpty()) { //TODO optimize
						ATGNetwork.INSTANCE.sendToServer(new MessageRequestChunks(((TileEntityTardis) tileEntity).interiorPos.getX(), ((TileEntityTardis) tileEntity).interiorPos.getZ(), 2, ATGConfig.tardisDIM));
					}
				}
			});
		} else if(!FakeWorld.fakeWorlds.isEmpty()){
			FakeWorld.fakeWorlds.clear();
		}
	}

	@SubscribeEvent public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().world != null)
			FakeWorld.getFakeWorld(ATGConfig.tardisDIM).updateEntities();
	}

}
