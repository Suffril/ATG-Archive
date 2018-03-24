package com.lcm.doctorwho.common.blocks;

import com.lcm.doctorwho.common.entity.EntityMountable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

    public class BlockSittableOutline extends BlockTileOutline {
        double yOffset;

    public BlockSittableOutline(Material material, String name, Class<? extends TileEntity> tileEntity, double yOffset) {
        super(material, name, tileEntity);
        this.yOffset = yOffset;
    }

    /**
     * Called when the block is right clicked by a player.
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        EntityMountable chair = new EntityMountable(worldIn, pos.getX(), pos.getY(), pos.getZ(), this.yOffset);
        worldIn.spawnEntity(chair);
        playerIn.startRiding(chair);
        return true;
    }

}
