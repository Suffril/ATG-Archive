package com.lcm.doctorwho.client.render.entity;


import com.lcm.doctorwho.AcrossTheGalaxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityBase extends RenderLiving
{
    String textureName;

    public RenderEntityBase(ModelBase model, String texName, float shadowSize)
    {
        super(Minecraft.getMinecraft().getRenderManager(), model, shadowSize);
        textureName = texName;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return new ResourceLocation(AcrossTheGalaxy.MODID, "textures/entity/" + textureName + ".png");
    }

}
