package com.lcm.doctorwho.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ATGTeleporter extends Teleporter {

	private final WorldServer worldServer;
	private double x;
	private double y;
	private double z;

	public ATGTeleporter(WorldServer worldServer, double x, double y, double z) {
		super(worldServer);
		this.worldServer = worldServer;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void changeDim(Entity entity, int dimension, double x, double y, double z) {
		int oldDimension = entity.world.provider.getDimension();
		MinecraftServer server = entity.world.getMinecraftServer();
		WorldServer worldServer = server.getWorld(dimension);

		if (worldServer == null || worldServer.getMinecraftServer() == null) { // Dimension doesn't exist
			throw new IllegalArgumentException("Dimension: " + dimension + " doesn't exist!");
		}

		if (entity instanceof EntityPlayerMP) {
			EntityPlayerMP p = (EntityPlayerMP) entity;
			FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().transferPlayerToDimension(p, dimension, new ATGTeleporter(p.getServerWorld(), x, y, z));
			entity.setPositionAndUpdate(x, y, z);
		} else {
			//entity.setPositionAndUpdate(x, y, z);
			//	worldServer.spawnEntity(entity);
			//	worldServer.updateEntityWithOptionalForce(entity, false);
		}
		//entity.setPositionAndUpdate(x, y, z);

		if (oldDimension == 1) {
			entity.setPositionAndUpdate(x, y, z);
			worldServer.spawnEntity(entity);
			worldServer.updateEntityWithOptionalForce(entity, false);
		}
	}

	@Override public void placeInPortal(Entity entityIn, float rotationYaw) {
		this.worldServer.getBlockState(new BlockPos((int) this.x, (int) this.y, (int) this.z));
		entityIn.setPosition(this.x, this.y, this.z);
		entityIn.motionX = 0.0f;
		entityIn.motionY = 0.0f;
		entityIn.motionZ = 0.0f;
	}
}
