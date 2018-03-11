package com.lcm.doctorwho.common.dimension;

import com.lcm.doctorwho.common.dimension.tardis.WorldProviderTardisDim;
import com.lcm.doctorwho.utils.ATGConfig;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ATGDims {
	
	public static DimensionType tardisDim;
	
	public static void dimSetup() {
		tardisDim = DimensionType.register("TARDIS", "_tardis", ATGConfig.tardisDIM, WorldProviderTardisDim.class, false);
		DimensionManager.registerDimension(ATGConfig.tardisDIM, tardisDim);
	}
	
}
