package com.lcm.doctorwho.common.tiles.tardis.tardis_1963;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntity1963Rotor extends TileEntity {

	@Override @SideOnly(Side.CLIENT) public AxisAlignedBB getRenderBoundingBox() {
		return super.getRenderBoundingBox().grow(4, 4, 4);
	}

}
