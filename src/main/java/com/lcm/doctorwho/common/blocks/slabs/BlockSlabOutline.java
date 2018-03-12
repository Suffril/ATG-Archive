package com.lcm.doctorwho.common.blocks.slabs;

import java.util.Random;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockSlabOutline extends BlockSlab
{

    Item droppedItem;
    boolean isDouble;

    public BlockSlabOutline(String name, Item item, boolean isDouble)
    {
        super(Material.WOOD);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(3F);
        setResistance(15F);

        this.isDouble = isDouble;

        IBlockState state = this.blockState.getBaseState();

        if(!isDouble())
        {
            state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
        } else
            {
                state = state.withProperty(HALF, EnumBlockHalf.TOP);
            }

        setDefaultState(state);
        this.useNeighborBrightness = true;
        this.droppedItem = item;
    }



    @Override
    public String getUnlocalizedName(int meta)
    {
        return this.getUnlocalizedName();
    }

    @Override
    public IProperty<?> getVariantProperty()
    {
        return HALF;
    }

    @Override
    public boolean isDouble()
    {
        return isDouble;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        if(!isDouble())
        {
            return EnumBlockHalf.BOTTOM;
        }

        return EnumBlockHalf.TOP;
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        if(!this.isDouble())
        {
            return this.getDefaultState().withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
        }
        return this.getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        if(!this.isDouble())
        {
            return 0;
        }
        return state.getValue(HALF).ordinal() + 1;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return droppedItem;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {HALF});
    }
}