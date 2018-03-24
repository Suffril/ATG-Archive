package com.lcm.doctorwho.client.render.tiles.tardis;

import com.lcm.doctorwho.client.models.interfaces.TileModelOutline;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderTileBase extends TileEntitySpecialRenderer {

	private TileModelOutline MODEL;

	public RenderTileBase(TileModelOutline model) {
		MODEL = model;
	}

	@Override public void render(TileEntity tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GlStateManager.rotate(180, 0.0F, 0.0F, 1.0F);
		super.render(tile, x, y, z, partialTicks, destroyStage, alpha);
		ATGUtils.bindTexture(MODEL.getTexture());
		MODEL.render(0.0625f);
		GlStateManager.popMatrix();
	}

}
