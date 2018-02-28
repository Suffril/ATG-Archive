package com.lcm.doctorwho.common.blocks;

import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LeavesOutline extends BlockLeaves {

    public LeavesOutline(String name) {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.PLANT);
    }


	@Override
    public boolean isOpaqueCube(IBlockState state) {
              return false;
      }


      @SideOnly(Side.CLIENT)
      @Override
      public BlockRenderLayer getBlockLayer() {
              return BlockRenderLayer.CUTOUT_MIPPED;
  }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return null;
    }

    /**
     * Performs the shear function on this object.
     * This is called for both client, and server.
     * The object should perform all actions related to being sheared,
     * except for dropping of the items, and removal of the block.
     * As those are handled by ItemShears itself.
     * <p>
     * Returns a list of items that resulted from the shearing process.
     * <p>
     * For entities, they should trust there internal location information
     * over the values passed into this function.
     *
     * @param item    The ItemStack that is being used, may be empty.
     * @param world   The current world.
     * @param pos     If this is a block, the block's position in world.
     * @param fortune The fortune level of the shears being used.
     * @return A List containing all items from this shearing. May be empty.
     */
    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return null;
    }
}
