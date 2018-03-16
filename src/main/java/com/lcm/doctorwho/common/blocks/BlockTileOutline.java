package com.lcm.doctorwho.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockTileOutline extends BlockContainer implements ITileEntityProvider {

	private Class<? extends TileEntity> tileEntity;

	public BlockTileOutline(Material material, String name, Class<? extends TileEntity> tileEntity) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.tileEntity = tileEntity;
		this.translucent = true;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	@Override public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT) public float getAmbientOcclusionLightValue(IBlockState state) {
		return 1.0F;
	}

	/**
	 * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only, LIQUID for vanilla liquids, INVISIBLE to skip all rendering
	 */
	@Deprecated @Override public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Nullable @Override public TileEntity createNewTileEntity(World worldIn, int meta) {
		try {
			return tileEntity.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

}
