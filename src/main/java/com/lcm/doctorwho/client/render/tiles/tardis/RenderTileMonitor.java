package com.lcm.doctorwho.client.render.tiles.tardis;

import com.lcm.doctorwho.client.boti.EntityCamera;
import com.lcm.doctorwho.client.boti.FakeWorld;
import com.lcm.doctorwho.client.models.tardis.decoration.ModelMonitor;
import com.lcm.doctorwho.common.tiles.tardis.TileEntityMonitor;
import com.lcm.doctorwho.utils.ATGUtils;
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
public class RenderTileMonitor extends TileEntitySpecialRenderer<TileEntityMonitor> {

	public static ModelMonitor model = new ModelMonitor();

	@Override public void render(TileEntityMonitor tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(x + 0.9, y + 0.775, z + 0.4);
		GlStateManager.rotate(180f, 0, 0, 1f);
		ATGUtils.bindTexture(model.getTexture());
		model.render(0.0625f);

		FakeWorld fakeWorld = FakeWorld.getFakeWorld(0);

		EntityCamera camera = fakeWorld.getCamera(tile);
		GlStateManager.rotate(180f, 0, 1f, 0f);
		if (camera != null && camera.image != null) {
			camera.bindTexture();

			GlStateManager.pushMatrix();

			GlStateManager.disableLighting();

			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder bufferBuilder = tessellator.getBuffer();
			bufferBuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
			bufferBuilder.pos(-0.75, 0.05, 0.001).tex(1, 0).endVertex();
			bufferBuilder.pos(-0.05, 0.05, 0.001).tex(0, 0).endVertex();
			bufferBuilder.pos(-0.05, 0.45, 0.001).tex(0, 1).endVertex();
			bufferBuilder.pos(-0.75, 0.45, 0.001).tex(1, 1).endVertex();
			tessellator.draw();

			GlStateManager.enableLighting();

			GlStateManager.popMatrix();

			camera.deleteTexture(new Vec3d(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ()));
		}

		GlStateManager.popMatrix();
	}
}
