package com.lcm.doctorwho.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockOutline extends Block {

	public BlockOutline(Material material, MapColor color, String name) {
		super(material, color);
		setRegistryName(name);
		setUnlocalizedName(name);
	}

	public BlockOutline(Material material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
	}
}
