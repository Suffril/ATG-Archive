package com.lcm.doctorwho.client.models;

import net.minecraftforge.common.model.IModelState;

public interface ItemModelBase {
	
	public void renderModel(float scale);
	
	public IModelState getTransforms();
}
