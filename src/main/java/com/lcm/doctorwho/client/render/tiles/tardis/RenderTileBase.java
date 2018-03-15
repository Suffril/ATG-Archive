package com.lcm.doctorwho.client.render.tiles.tardis;

import com.lcm.doctorwho.client.models.interfaces.ITileModel;
import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class RenderTileBase extends TileEntitySpecialRenderer<TileEntity> {

    private ITileModel MODEL;

    public RenderTileBase(ITileModel model)
    {
        MODEL = model;
    }

    @Override
    public void render(TileEntity tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
        super.render(tile,x,y,z,partialTicks,destroyStage,alpha);
        ATGUtils.bindTexture(MODEL.getTexture());
        MODEL.render(0.0625f);
        GL11.glPopMatrix();
    }

}
