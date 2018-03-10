package com.lcm.doctorwho.client.render.tiles.tardis;

import com.lcm.doctorwho.client.events.ATGClientEventHandler;
import com.lcm.doctorwho.client.models.interfaces.ITardisModel;
import com.lcm.doctorwho.client.windows.EntityCamera;
import com.lcm.doctorwho.client.windows.FakeWorld;
import com.lcm.doctorwho.common.capabilities.CapabilityTileTardis;
import com.lcm.doctorwho.common.capabilities.ITardis;
import com.lcm.doctorwho.common.tiles.TileEntityTardis;
import com.lcm.doctorwho.events.ATGClientProxy;
import com.lcm.doctorwho.utils.ATGConfig;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class RenderTileTardis extends TileEntitySpecialRenderer<TileEntityTardis>
{
	//TODO animated portal
	//TODO fix memory leaks
	//TODO variable door sizes
	//TODO smoother teleporting
	//TODO teleport all entities/when colliding
	//TODO bigger hitbox
	//TODO more than one area
	//TODO interior spawning
	private ITardisModel MODEL = null;

	public RenderTileTardis() { }

	@Override
	public void render(TileEntityTardis tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{

		ITardis capa = tile.getCapability(CapabilityTileTardis.TARDIS, null);
		if (capa != null && capa.getModelID() <= ATGClientProxy.TARDIS_MODELS.size())
		{
			MODEL = ATGClientProxy.TARDIS_MODELS.get(capa.getModelID());
		}

		if (MODEL == null)
		{
			MODEL = ATGClientProxy.TARDIS_MODELS.get(0);
		}

		GlStateManager.pushMatrix();
		GlStateManager.pushMatrix();

		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		MODEL.setDoorOpen(capa.isDoorOpen());
		MODEL.setLampOn(new Random().nextBoolean());
		ATGUtils.bindTexture(MODEL.getTexture());
		MODEL.renderAll(0.0625f);

		GlStateManager.popMatrix();
		FakeWorld fakeWorld = FakeWorld.getFakeWorld(ATGConfig.tardisDIM);

		EntityCamera camera = fakeWorld.getCamera(ATGClientEventHandler.cameraID, new BlockPos(0.5, 0.5, 0.5));
		ATGClientEventHandler.cameraID = camera.getEntityId();
		if (camera.image != null)
		{
			GlStateManager.bindTexture(new DynamicTexture(camera.image).getGlTextureId());
			GlStateManager.pushMatrix();

			GlStateManager.translate(x, y, z);

			GlStateManager.rotate(180f, 0, 1f, 0);
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			GlStateManager.disableLighting();
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder bufferBuilder = tessellator.getBuffer();
			bufferBuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
			bufferBuilder.pos(0, -2.5, -0.25).tex(0.25, 0).endVertex();
			bufferBuilder.pos(1, -2.5, -0.25).tex(0.75, 0).endVertex();
			bufferBuilder.pos(1, 0, -0.25).tex(0.75, 1).endVertex();
			bufferBuilder.pos(0, 0, -0.25).tex(0.25, 1).endVertex();
			tessellator.draw();
			GlStateManager.popMatrix();
			GlStateManager.enableLighting();
		}

		GlStateManager.popMatrix();
	}

}