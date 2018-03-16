package com.lcm.doctorwho.common.dimension;

import com.lcm.doctorwho.common.dimension.tardis.WorldProviderTardisDim;
import com.lcm.doctorwho.utils.ATGConfig;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ATGDims {

	public static DimensionType tardisDim = DimensionType.register("TARDIS", "_tardis", ATGConfig.tardisDIM, WorldProviderTardisDim.class, false);

	public static void dimSetup() {

		DimensionManager.registerDimension(ATGConfig.tardisDIM, tardisDim);
	}

}
