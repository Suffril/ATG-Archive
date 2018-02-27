package com.lcm.doctorwho.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LeavesOutline extends BlockOutline {
	
	public LeavesOutline(Material material, MapColor color, String name) {
		super(material, color, name);
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
}
