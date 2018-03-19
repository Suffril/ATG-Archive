package com.lcm.doctorwho.client.render.tiles.tardis;

import com.lcm.doctorwho.client.boti.EntityCamera;
import com.lcm.doctorwho.client.boti.FakeWorld;
import com.lcm.doctorwho.common.tiles.tardis.TileEntityInteriorDoor;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

/**
 * Created by Nictogen on 3/19/18.
 */
public class RenderTileInteriorDoor extends TileEntitySpecialRenderer<TileEntityInteriorDoor> {

	@Override public void render(TileEntityInteriorDoor tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {

		FakeWorld fakeWorld = FakeWorld.getFakeWorld(tile.exteriorDim);

		EntityCamera camera = fakeWorld.getCamera(tile);

		if (camera.image != null) {
			camera.bindTexture();

			GlStateManager.pushMatrix();
			GlStateManager.translate(x, y, z);
			GlStateManager.rotate(180, 0.0F, 0.0F, 1.0F);

			GlStateManager.disableLighting();

			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder bufferBuilder = tessellator.getBuffer();
			bufferBuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
			bufferBuilder.pos(-1, -2, 0).tex(1, 0).endVertex();
			bufferBuilder.pos(1, -2, 0).tex(0, 0).endVertex();
			bufferBuilder.pos(1, 0, 0).tex(0, 1).endVertex();
			bufferBuilder.pos(-1, 0, 0).tex(1, 1).endVertex();
			tessellator.draw();

			GlStateManager.enableLighting();

			GlStateManager.popMatrix();

			camera.deleteTexture(new Vec3d(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ()));
		}
	}

}
