package com.lcm.doctorwho.utils;

import net.minecraftforge.common.config.Configuration;

public class ATGConfig {
	public static boolean angelTeleporting;
	
	public static void init(Configuration cfg) {
		cfg.load();
		
		cfg.setCategoryComment("Weeping Angel", "These options are used to edit Weeping angel behaviour");
		angelTeleporting = cfg.getBoolean("angelTeleporting", "Weeping Angel", false, "If this is true, angels have a chance of teleporting you on collision with them");
		
		cfg.save();
	}
}
