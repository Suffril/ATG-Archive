package com.lcm.doctorwho.client.models.interfaces;

import net.minecraftforge.common.model.IModelState;

public interface ItemModelBase {
	
	void renderModel(float scale);
	
	IModelState getTransforms();
}
