package com.lcm.doctorwho.client.render.tiles.tardis;

import java.util.Random;

import net.minecraft.client.renderer.GlStateManager;

import com.lcm.doctorwho.client.models.interfaces.ITardisModel;
import com.lcm.doctorwho.common.capabilities.CapabilityTileTardis;
import com.lcm.doctorwho.common.capabilities.interfaces.ITardisTile;
import com.lcm.doctorwho.common.tiles.tardis.TileEntityTardis;
import com.lcm.doctorwho.events.ATGClientProxy;
import com.lcm.doctorwho.utils.ATGUtils;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderTileTardis extends TileEntitySpecialRenderer<TileEntityTardis> {
	
	private ITardisModel MODEL = null;
	
	public RenderTileTardis() {
		
	}
	
	@Override
	public void render(TileEntityTardis tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		ITardisTile capa = tile.getCapability(CapabilityTileTardis.TARDIS, null);
		if (capa == null) throw new Error("TARDIS does not have capability");
		if (capa.getModelID() <= ATGClientProxy.TARDIS_MODELS.size()) {
			MODEL = ATGClientProxy.TARDIS_MODELS.get(capa.getModelID());
		}
		
		if (MODEL == null) {
			MODEL = ATGClientProxy.TARDIS_MODELS.get(0);
		}

		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GlStateManager.rotate(180, 0.0F, 0.0F, 1.0F);
		MODEL.setDoorOpen(capa.isDoorOpen());
		MODEL.setLampOn(new Random().nextBoolean());

		if(MODEL.getTexture() != null) {
			ATGUtils.bindTexture(MODEL.getTexture());
		}

		MODEL.renderAll(0.0625f);
		GlStateManager.popMatrix();
	}
	
}
