package com.lcm.doctorwho.common.blocks;

import com.lcm.doctorwho.common.tiles.tardis.TileEntityTardis;
import com.lcm.doctorwho.events.ATGObjects;
import com.lcm.doctorwho.utils.ATGConfig;
import com.lcm.doctorwho.utils.ATGUtils;
import com.lcm.doctorwho.utils.WorldJsonUtils;
import com.sun.javafx.geom.Vec2d;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import javax.annotation.Nullable;

public class BlockTardis extends BlockOutline {

	protected static final AxisAlignedBB AABB = new AxisAlignedBB(-0.25, 0, 0.1, 1.25, 3,1.25);

	public BlockTardis(Material material, String name) {
		super(material, name);
		setLightLevel(1.0F);
	}

	/**
	 * Called by ItemBlocks after a block is set in the world, to allow post-place logic
	 */
	@Override public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		TileEntityTardis tardis = (TileEntityTardis) worldIn.getTileEntity(pos);

		if (!worldIn.isRemote) {
			tardis.ownerUUID = placer.getUniqueID().toString();

			MinecraftServer server = placer.world.getMinecraftServer();
			WorldServer tardis_dim = server.getWorld(ATGConfig.tardisDIM);
			Vec2d chunk = TileEntityTardis.TardisWorldData.get(tardis_dim).getNewChunkCoordinates();
			tardis.interiorPos = new BlockPos(chunk.x, 0, chunk.y);
			tardis.markDirty();
			worldIn.notifyBlockUpdate(pos, state, state, 3);
			BlockPos iPos = tardis.getInteriorDoorPos();
			WorldJsonUtils.INSTANCE.fromJson(tardis_dim, iPos.getX() >> 4, iPos.getY() >> 4, iPos.getZ() >> 4, "default_interior", true);
		}
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
	 * Determines if an entity can path through this block
	 */
	@Override public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	/**
	 * Called when the block is right clicked by a player.
	 */
	@Override public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntityTardis tardis = (TileEntityTardis) worldIn.getTileEntity(pos);

		if (playerIn.getUniqueID().toString().equalsIgnoreCase(tardis.ownerUUID)) {
			tardis.doorOpen = !tardis.doorOpen;
			SoundEvent sound = tardis.doorOpen ? ATGObjects.SoundEvents.tardis_pb_open : ATGObjects.SoundEvents.tardis_pb_close;
			ATGUtils.playSound(playerIn, sound);

			if (!worldIn.isRemote) {
				tardis.markDirty();
				worldIn.notifyBlockUpdate(pos, state, state, 3);
			}
		} else ATGUtils.sendPlayerMessage(playerIn, "This is not your TARDIS!");
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
		return new TileEntityTardis();
	}

	/**
	 * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only, LIQUID for vanilla liquids, INVISIBLE to skip all rendering
	 */
	@Deprecated @Override public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}
}
