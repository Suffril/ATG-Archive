package com.lcm.doctorwho.client.render.tiles.tardis;

import com.lcm.doctorwho.client.models.interfaces.iTardisModel;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelHartnellTardis;
import com.lcm.doctorwho.common.capabilities.CapabilityTileTardis;
import com.lcm.doctorwho.common.tiles.TileEntityTardis;
import com.lcm.doctorwho.events.ATGClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


public class RenderTileTardis extends TileEntitySpecialRenderer<TileEntityTardis> {

    private iTardisModel MODEL = null;
    private ResourceLocation TEXTURE = null;

    public RenderTileTardis() {

    }

    @Override
    public void render(TileEntityTardis tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {

        if (MODEL == null) {
            MODEL = ATGClientProxy.TARDIS_MODELS.get(tile.getCapability(CapabilityTileTardis.TARDIS, null).getModelID());
            TEXTURE = MODEL.getTexture();
        }

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
        MODEL.setDoorOpen(tile.getUpdateTag().getBoolean("doorOpen"));
        //System.out.println("WHY " + tile.getUpdateTag().getBoolean("doorOpen"));
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        MODEL.renderAll(0.0625f);
        GL11.glPopMatrix();
    }

}