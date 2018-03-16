package com.lcm.doctorwho.client.render;

import com.lcm.doctorwho.client.models.entity.hostile.angels.ModelWeepingAngel;
import com.lcm.doctorwho.client.models.entity.hostile.cybermen.ModelCyberTenthPlanet;
import com.lcm.doctorwho.client.render.entity.RenderCybermen;
import com.lcm.doctorwho.client.render.entity.RenderEntityBase;
import com.lcm.doctorwho.client.render.entity.RenderEntityBaseProjectile;
import com.lcm.doctorwho.common.mobs.hostile.EntityCybermen;
import com.lcm.doctorwho.common.mobs.hostile.EntityWeepingAngel;
import com.lcm.doctorwho.common.mobs.projectile.EntityProjectile;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import java.util.HashMap;
import java.util.Map;

public class RenderMobsInit {

	public static final Map<EntityCybermen.CyberType, ModelBiped> CYBERS = new HashMap<>();

	public static void init() {
		RenderingRegistry.registerEntityRenderingHandler(EntityWeepingAngel.class, new RenderEntityBase<>(new ModelWeepingAngel(), "weeping_angel", 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityProjectile.class, new RenderEntityBaseProjectile());
		RenderingRegistry.registerEntityRenderingHandler(EntityCybermen.class, new RenderCybermen(new ModelCyberTenthPlanet()));
		cyberModels();
	}

	private static void cyberModels() {
		CYBERS.put(EntityCybermen.CyberType.TENTH_PLANET, new ModelCyberTenthPlanet());
	}

}
