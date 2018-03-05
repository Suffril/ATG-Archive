package com.lcm.doctorwho.client.render.tiles.tardis;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelHartnellTardis;
import com.lcm.doctorwho.common.TileEntityTardis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


public class RenderTileTardis extends TileEntitySpecialRenderer<TileEntityTardis> {

    private ModelHartnellTardis modelTemp = new ModelHartnellTardis();
    private ResourceLocation tempTexture = new ResourceLocation(AcrossTheGalaxy.MODID, "textures/models/tardis/tardis_hartnell.png");

    public RenderTileTardis() {

    }

    @Override
    public void render(TileEntityTardis tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
        Minecraft.getMinecraft().renderEngine.bindTexture(tempTexture);
        modelTemp.renderTardis(0.0625f);
        GL11.glPopMatrix();
    }

}