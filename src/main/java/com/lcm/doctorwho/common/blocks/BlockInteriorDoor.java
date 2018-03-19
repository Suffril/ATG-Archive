package com.lcm.doctorwho.common.blocks;

import com.lcm.doctorwho.common.tiles.tardis.TileEntityInteriorDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Nictogen on 3/19/18.
 */
public class BlockInteriorDoor extends BlockOutline {

	protected static final AxisAlignedBB AABB = new AxisAlignedBB(-1, 0, 0, 1, 2,0.1);

	public BlockInteriorDoor(Material material, String name) {
		super(material, name);
		setLightLevel(1.0F);
	}

	@Override public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	@Nullable public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return AABB;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	/**
	 * Determines if an entity can path through this block
	 */
	@Override public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	/**
	 * Called throughout the code as a replacement for block instanceof BlockContainer Moving this to the Block base class allows for mods that wish to extend vanilla blocks, and also want to have a tile entity on that block, may.
	 * <p>
	 * Return true from this function to specify this block has a tile entity.
	 *
	 * @param state State of the current block
	 * @return True if block has a tile entity, false otherwise
	 */
	@Override public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	/**
	 * Called throughout the code as a replacement for ITileEntityProvider.createNewTileEntity Return the same thing you would from that function. This will fall back to ITileEntityProvider.createNewTileEntity(World) if this block is a ITileEntityProvider
	 *
	 * @param state The state of the current block
	 * @return A instance of a class extending TileEntity
	 */
	@Nullable @Override public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityInteriorDoor();
	}

	/**
	 * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only, LIQUID for vanilla liquids, INVISIBLE to skip all rendering
	 */
	@Deprecated @Override public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}
}
