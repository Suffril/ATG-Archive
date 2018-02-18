package com.lcm.doctorwho.utils;

import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.relauncher.Side;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ATGConfig
{
	public static boolean disableTraits, lockMouse, resetHunger, resetOxygen, dontLoseUponDeath, startAsTimelord, disableArch;
	public static int regenerativeKillRange, regenerativeKnockbackRange, regenCapacity, regenerationLevel, postRegenerationLevel, postRegenerationDuration;
	public static float regenerativeKnockback, absorbtionLevel;
	public static ArrayList<String> lockedKeys = new ArrayList<>();
	public static String lootRegex;
	
	public static void init(Configuration cfg, Side side) {
		cfg.load();
		
		disableTraits = !cfg.getBoolean("enableTraits", "traits", true, "Enable the trait system. If this is false all trait effects are disabled");
		lootRegex = cfg.getString("lootRegex", "loot", "minecraft:chests\\/.*", "The loot pool for chameleon arch's will only be added to loot tables whose name matches this regular expression");
		
		regenCapacity = cfg.getInt("maxRegenCapacity", "superpower", 12, 0, Integer.MAX_VALUE, "The maximum regeneration capacity. This affects the durability of a Chameleon Arch and the amount of regenerations in a full cycle. Use 0 for infinite regenerations, the chameleon arch will grant the timelord ability and give you infinite regenerations. If you die while regenerating you'll lose your ability (unless dontLosePower is set to true)");
		dontLoseUponDeath = cfg.getBoolean("dontLosePower", "superpower", false, "If this is true you won't lose your timelord power if you get killed during regeneration");
		startAsTimelord = cfg.getBoolean("startAsTimelord", "superpower", false, "If this is true you'll be granted the timelord power when you first join your world");
		disableArch = cfg.getBoolean("disableArch", "superpower", false, "If this is true the chameleon arch item won't spawn naturally. Useful when combining all the other options in this category to create a seamless immortal experience");
		cfg.setCategoryComment("superpower", "These options can be used to tweak the amount of immortality");
		
		absorbtionLevel = cfg.getFloat("absorbtionAmount", "regeneration", 10, 0, Float.MAX_VALUE, "The amount of absorbtion hearts you get when regenerating") * 2;
		resetHunger = cfg.getBoolean("resetHunger", "regeneration", true, "Regenerate hunger bars");
		resetOxygen = cfg.getBoolean("resetOxygen", "regeneration", true, "Reset oxygen level when underwater");
		regenerationLevel = cfg.getInt("regenerationEffectLevel", "regeneration", 2, 0, 127, "The level of the regeneration status effect active while regenerating") - 1;
		postRegenerationLevel = cfg.getInt("postRegenerationEffectLevel", "regeneration", 4, 0, 127, "The level of the regeneration status effect granted upon regeneration finish") - 1;
		postRegenerationDuration = cfg.getInt("postRegenerationEffectDuration", "regeneration", 180, 0, Integer.MAX_VALUE, "Amount of seconds the post-regeneration effect lasts") * 20;
		
		regenerativeKillRange = cfg.getInt("immediateKillRange", "regeneration", 4, 0, Integer.MAX_VALUE, "Upon regeneration every mob inside of this radius is immediately killed. Keep in mind that you should round up to accomodate for mobs that aren't standing in the center of a block");
		regenerativeKnockbackRange = cfg.getInt("knockbackRange", "regeneration", 7, 0, 30000000, "Range wherein every mob is knocked back upon regeneration");
		regenerativeKnockback = cfg.getFloat("knockback", "regeneration", 2.5F, 0, Float.MAX_VALUE, "The amount of knockback every mob inside of the knock back radius gets");
		
		if (side == Side.CLIENT) { //this information is not required on the server side as it can't lock keys
			Collections.addAll(lockedKeys, cfg.getStringList("lockedActions", "keylocks", new String[] { "forward", "left", "right", "back", "jump", "sneak", "drop", "attack", "inventory", "sprint", "swapHands", "togglePerspective", "useItem" }, "When regenerating these keybindings are unbound", validKeybindings()));
			lockMouse = cfg.getBoolean("lockMouse", "keylocks", true, "Lock the mouse while regenerating");
			cfg.setCategoryComment("keylocks", "Actions that can be locked (case sensitive): "+Arrays.toString(validKeybindings()));
		}
		
		cfg.save();
	}

	private static String[] validKeybindings() {
		ArrayList<String> kbs = new ArrayList<>();
		for (Field f : GameSettings.class.getFields())
			if (f.getName().startsWith("keyBind")) kbs.add(f.getName().substring(0, 1).toLowerCase() + f.getName().substring(1));
		return kbs.toArray(new String[0]);
	}
}
