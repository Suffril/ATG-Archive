package com.lcm.doctorwho.common.mobs.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityProjectile extends EntityThrowable {
	
	private static DataParameter<Float> DAMAGE = EntityDataManager.createKey(EntityProjectile.class, DataSerializers.FLOAT);
	DamageSource source = DamageSource.MAGIC;
	
	public EntityProjectile(World worldIn) {
		super(worldIn);
	}
	
	public EntityProjectile(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}
	
	public EntityProjectile(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		getDataManager().register(DAMAGE, 1.0F);
	}
	
	public void setDamage(float damage) {
		getDataManager().set(DAMAGE, damage);
	}
	
	public Float getDamage() {
		return getDataManager().get(DAMAGE);
	}
	
	public void setDamageSource(DamageSource damageSource) {
		this.source = damageSource;
	}
	
	public DamageSource getDamageSource() {
		return source;
	}
	
	public static void registerFixesProjectile(DataFixer fixer) {
		EntityThrowable.registerFixesThrowable(fixer, "projectile");
	}
	
	/**
	 * Called when this EntityThrowable hits a block or entity.
	 *
	 * @param result
	 */
	@Override
	protected void onImpact(RayTraceResult result) {
		
		if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
			Entity entity = result.entityHit;
			entity.attackEntityFrom(getDamageSource(), getDamage());
			setDead();
		}
		
		if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
			setDead();
		}
		
		if (result.typeOfHit == RayTraceResult.Type.MISS)
			
			if (onGround) {
			setDead();
			}
	}
}
