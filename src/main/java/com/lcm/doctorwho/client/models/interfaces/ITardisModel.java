package com.lcm.doctorwho.client.models.interfaces;

import net.minecraft.util.ResourceLocation;

public interface ITardisModel {
    void renderRightDoor(float scale);
    void renderLeftDoor(float scale);
    void renderShell(float scale);
    void renderLamp(float scale);
    void renderText(float scale);
    void other(float scale);
    void renderAll(float scale);
    boolean isDoorOpen();
    boolean isLampOn();
    void setLampOn(boolean on);
    void setDoorOpen(boolean open);
    ResourceLocation getTexture();
    String getExteriorName();
}
