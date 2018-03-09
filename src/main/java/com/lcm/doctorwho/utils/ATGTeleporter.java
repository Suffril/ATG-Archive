package com.lcm.doctorwho.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

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

    public static void teleportToDimension(EntityPlayer player, int dimension, double x, double y, double z) {
        int oldDimension = player.world.provider.getDimension();
        EntityPlayerMP playerMP = (EntityPlayerMP) player;
        MinecraftServer server = playerMP.world.getMinecraftServer();
        WorldServer worldServer = server.getWorld(dimension);

        if (worldServer == null || worldServer.getMinecraftServer() == null) { //Dimension doesn't exist

            throw new IllegalArgumentException("Dimension: " + dimension + " doesn't exist!");

        }
        worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(playerMP, dimension, new ATGTeleporter(worldServer, x, y, z));
        player.setPositionAndUpdate(x, y, z);

        if (oldDimension == 1) {
            // For some reason teleporting out of the end does weird things.
            player.setPositionAndUpdate(x, y, z);
            worldServer.spawnEntity(player);
            worldServer.updateEntityWithOptionalForce(player, false);
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