package com.lcm.doctorwho.common.blocks;

import com.lcm.doctorwho.common.TileEntityTardis;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockTardis extends BlockOutline {
    public BlockTardis(Material material, MapColor color, String name) {
        super(material, color, name);
    }

    public BlockTardis(Material material, String name) {
        super(material, name);
    }

    /**
     * Called throughout the code as a replacement for block instanceof
     * BlockContainer Moving this to the Block base class allows for mods that wish
     * to extend vanilla blocks, and also want to have a tile entity on that block,
     * may.
     *
     * Return true from this function to specify this block has a tile entity.
     *
     * @param state
     *            State of the current block
     * @return True if block has a tile entity, false otherwise
     */
    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    /**
     * Called throughout the code as a replacement for
     * ITileEntityProvider.createNewTileEntity Return the same thing you would from
     * that function. This will fall back to
     * ITileEntityProvider.createNewTileEntity(World) if this block is a
     * ITileEntityProvider
     *
     * @param state
     *            The state of the current block
     * @return A instance of a class extending TileEntity
     */
    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityTardis();
    }

    /**
     * The type of render function called. MODEL for mixed tesr and static model,
     * MODELBLOCK_ANIMATED for TESR-only, LIQUID for vanilla liquids, INVISIBLE to
     * skip all rendering
     */
    @Deprecated
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

}
