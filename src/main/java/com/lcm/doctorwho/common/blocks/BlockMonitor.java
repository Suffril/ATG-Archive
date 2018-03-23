package com.lcm.doctorwho.common.blocks;

import com.lcm.doctorwho.common.tiles.tardis.TileEntityMonitor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Nictogen on 3/19/18.
 */
public class BlockMonitor extends BlockTileOutline {
	public BlockMonitor() {
		super(Material.CIRCUITS, "monitor", TileEntityMonitor.class);
	}

	@Override public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		//		TileEntityMonitor monitor = (TileEntityMonitor) worldIn.getTileEntity(pos);
		//
		//		if (!worldIn.isRemote) {
		//
		//			MinecraftServer server = placer.world.getMinecraftServer();
		//			WorldServer tardis_dim = server.getWorld(0);
		//			monitor.markDirty();
		//			worldIn.notifyBlockUpdate(pos, state, state, 3);
		//		}
	}
}
