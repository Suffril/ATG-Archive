package com.lcm.doctorwho.networking;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.networking.packets.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ATGNetwork {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(AcrossTheGalaxy.MODID);

	public static void init() {
		INSTANCE.registerMessage(MessageAngelSeen.AngelSeenHandler.class, MessageAngelSeen.class, 0, Side.SERVER);
		INSTANCE.registerMessage(MessageChunkData.Handler.class, MessageChunkData.class, 1, Side.CLIENT);
		INSTANCE.registerMessage(MessageRequestChunks.Handler.class, MessageRequestChunks.class, 2, Side.SERVER);
		INSTANCE.registerMessage(MessageChangeRegenState.Handler.class, MessageChangeRegenState.class, 3, Side.CLIENT);
		INSTANCE.registerMessage(MessageSyncTimelordData.Handler.class, MessageSyncTimelordData.class, 4, Side.CLIENT);
		INSTANCE.registerMessage(MessageRegenerationStyle.Handler.class, MessageRegenerationStyle.class, 5, Side.SERVER);
	}

}
