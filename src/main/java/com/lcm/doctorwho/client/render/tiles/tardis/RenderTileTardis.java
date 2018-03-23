package com.lcm.doctorwho.client.render.tiles.tardis;

import com.lcm.doctorwho.client.boti.EntityCamera;
import com.lcm.doctorwho.client.boti.FakeWorld;
import com.lcm.doctorwho.client.models.interfaces.ITardisModel;
import com.lcm.doctorwho.common.tiles.tardis.TileEntityTardis;
import com.lcm.doctorwho.events.ATGClientProxy;
import com.lcm.doctorwho.utils.ATGConfig;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class RenderTileTardis extends TileEntitySpecialRenderer<TileEntityTardis> {

	private ITardisModel MODEL = null;

	public RenderTileTardis() {

	}

	@Override public void render(TileEntityTardis tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		if (tile.modelID <= ATGClientProxy.TARDIS_MODELS.size()) {
			MODEL = ATGClientProxy.TARDIS_MODELS.get(tile.modelID);
		}

		if (MODEL == null) {
			MODEL = ATGClientProxy.TARDIS_MODELS.get(0);
		}

		GlStateManager.pushMatrix();

		GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GlStateManager.rotate(180, 0.0F, 0.0F, 1.0F);
		MODEL.setDoorOpen(tile.doorOpen);
		if (MODEL.getTexture() != null) {
			ATGUtils.bindTexture(MODEL.getTexture());
		}

		MODEL.renderAll(0.0625f);
		GlStateManager.popMatrix();

		if(tile.doorOpen) {
		FakeWorld fakeWorld = FakeWorld.getFakeWorld(ATGConfig.tardisDIM);

		EntityCamera camera = fakeWorld.getCamera(tile);

			if (camera != null && camera.image != null) {
			camera.bindTexture();

			GlStateManager.pushMatrix();

			GlStateManager.translate(x, y, z);
			GlStateManager.rotate(180f, 0, 1.0f, 0);
			GlStateManager.rotate(180, 0.0F, 0.0F, 1.0F);

			GlStateManager.disableLighting();

			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder bufferBuilder = tessellator.getBuffer();
			bufferBuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
			bufferBuilder.pos(0, -2.5, -0.25).tex(0.9, 0.1).endVertex();
			bufferBuilder.pos(1, -2.5, -0.25).tex(0.1, 0.1).endVertex();
			bufferBuilder.pos(1, 0, -0.25).tex(0.1, 0.9).endVertex();
			bufferBuilder.pos(0, 0, -0.25).tex(0.9, 0.9).endVertex();
			tessellator.draw();

			GlStateManager.enableLighting();

			GlStateManager.popMatrix();

			camera.deleteTexture(new Vec3d(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ()));
			}
		}
	}

	public static void calculateLight()
	{
		float timer = System.nanoTime() / 1000000000l;

		if (timer % 2 == 0) {
			GlStateManager.pushMatrix();
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
			int bright = 0xF0;
			int brightX = bright % 65536;
			int brightY = bright / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightX, brightY);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 0x0, 0xf0);
			GlStateManager.disableAlpha();
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
		}
	}

}
