package com.lcm.doctorwho.client.render.tiles.tardis;

import com.lcm.doctorwho.client.models.interfaces.ITardisModel;
import com.lcm.doctorwho.common.capabilities.CapabilityTileTardis;
import com.lcm.doctorwho.common.capabilities.ITardis;
import com.lcm.doctorwho.common.tiles.TileEntityTardis;
import com.lcm.doctorwho.events.ATGClientProxy;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Random;


public class RenderTileTardis extends TileEntitySpecialRenderer<TileEntityTardis> {

    private ITardisModel MODEL = null;
    private ResourceLocation TEXTURE = null;

    public RenderTileTardis() {

    }

    @Override
    public void render(TileEntityTardis tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {

            ITardis capa = tile.getCapability(CapabilityTileTardis.TARDIS, null);
           if(capa != null){
               MODEL = ATGClientProxy.TARDIS_MODELS.get(capa.getModelID());
               TEXTURE = MODEL.getTexture();
           } else
               {
                   System.out.println("We have a problem...");
                   MODEL = ATGClientProxy.TARDIS_MODELS.get(0);
                   TEXTURE = MODEL.getTexture();
               }

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
        MODEL.setDoorOpen(capa.isDoorOpen());
        MODEL.setLampOn(new Random().nextBoolean());
        ATGUtils.bindTexture(TEXTURE);
        MODEL.renderAll(0.0625f);
        GL11.glPopMatrix();
    }

}