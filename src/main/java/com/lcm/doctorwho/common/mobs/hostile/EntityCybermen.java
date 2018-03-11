package com.lcm.doctorwho.common.mobs.hostile;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityCybermen extends EntityMob implements IRangedAttackMob {

    CyberType type = CyberType.TENTH_PLANET;
    private static final DataParameter<Integer> CYBER_TYPE = EntityDataManager.<Integer>createKey(EntityCybermen.class, DataSerializers.VARINT);

    public EntityCybermen(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        applyEntityAI();
    }

    protected void applyEntityAI()
    {
        tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
        targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));

        tasks.addTask(1, new EntityAIAttackMelee(this, 0.8D, false));
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(CYBER_TYPE, 0);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("cyber_type", getTypeID());
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        setTypeID(compound.getInteger("cyber_type"));
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        setUpCyberman();

    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
    }

    public void setTypeID(int id)
    {
        this.getDataManager().set(CYBER_TYPE, id);
    }

    public int getTypeID()
    {
        return getDataManager().get(CYBER_TYPE);
    }



        /**
         * Attack the specified entity using a ranged attack.
         *
         * @param target
         * @param distanceFactor
         */
    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {

        if(type.equals(CyberType.CYBUS))
        {
            //Cybus attack
        }

        if(type.equals(CyberType.EARTHSHOCK))
        {
            //Earthshock atack
        }
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {

    }

    private void setUpCyberman()
    {
        int id = getTypeID();
        switch (getTypeID()) {
            case 0:  id = 0;
                type = CyberType.TENTH_PLANET;
                break;

            case 1:  id = 1;
                type = CyberType.EARTHSHOCK;
                break;

            case 2:  id = 2;
                type = CyberType.CYBUS;
                break;

            case 3:  id = 3;
                type = CyberType.MONDAS;
                break;
        }
    }

    public enum CyberType
    {
        TENTH_PLANET,
        EARTHSHOCK,
        CYBUS,
        MONDAS
    }
}
