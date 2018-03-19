package com.lcm.doctorwho.client.boti;

import com.lcm.doctorwho.networking.packets.MessageRequestChunks;
import net.minecraft.util.math.Vec3d;

/**
 * Created by Nictogen on 3/19/18.
 */
public interface ICameraInterface {

	int getCameraID();

	void setCameraID(int id);

	int getRenderDimension();

	MessageRequestChunks requestChunks();

	boolean isChunkEmpty(FakeWorld world);

	Vec3d getCameraSpawnPos();

}
