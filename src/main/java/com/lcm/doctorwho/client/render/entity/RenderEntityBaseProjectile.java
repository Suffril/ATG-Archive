package com.lcm.doctorwho.client.render.entity;

import com.lcm.doctorwho.client.models.entity.projectile.ModelProjectile;
import com.lcm.doctorwho.common.entity.projectile.EntityProjectile;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;

public class RenderEntityBaseProjectile extends RenderSnowball<EntityProjectile> {

	private ModelProjectile laser = new ModelProjectile();

	public RenderEntityBaseProjectile(RenderManager manager) {
		super(manager, Items.AIR, null);
	}

	@Override public void doRender(EntityProjectile entity, double x, double y, double z, float entityYaw, float partialTicks) {
		laser.render(entity, 0.0625f);
	}

}
