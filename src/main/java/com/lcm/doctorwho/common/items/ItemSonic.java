package com.lcm.doctorwho.common.items;

import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ItemSonic extends Item {

    private SoundEvent sound = null;

    public ItemSonic(String name, SoundEvent sonicSound)
    {
        setRegistryName(name);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        sound = sonicSound;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        ATGUtils.playSound(entityLiving, sound);
    }
}
