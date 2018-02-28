package com.lcm.doctorwho.client.models;

import com.lcm.regeneration.util.RegenRequires;

import net.minecraftforge.common.model.IModelState;

@RegenRequires
public interface ItemModelBase {
	
	void renderModel(float scale);
	
	IModelState getTransforms();
}
