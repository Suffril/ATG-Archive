package com.lcm.doctorwho.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockTileOutline extends BlockOutline {

    TileEntity tile = null;

    public BlockTileOutline(Material material, MapColor color, String name, TileEntity tile) {
        super(material, color, name);
        this.tile = tile;
    }

    public BlockTileOutline(Material material, String name, TileEntity tile) {
        super(material, name);
        this.tile = tile;
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
        return tile;
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
