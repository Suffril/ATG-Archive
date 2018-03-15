package com.lcm.doctorwho.client.models.interfaces;

import net.minecraft.util.ResourceLocation;

public interface ITileModel {

    void render(float scale);

    ResourceLocation getTexture();
}
