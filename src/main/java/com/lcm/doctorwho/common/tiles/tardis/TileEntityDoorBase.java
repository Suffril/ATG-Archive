package com.lcm.doctorwho.common.tiles.tardis;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityDoorBase extends TileEntity implements ITickable {

	@Override @SideOnly(Side.CLIENT) public AxisAlignedBB getRenderBoundingBox() {
		return super.getRenderBoundingBox().grow(8, 8, 8);
	}

	/**
	 * Like the old updateEntity(), except more generic.
	 */
	@Override public void update() {

	}
}
