package com.lcm.doctorwho.networking;

import com.lcm.doctorwho.networking.packets.MessageAngelSeen;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ATGNetwork {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("lcm-atg");

    public static void init()
    {
        INSTANCE.registerMessage(MessageAngelSeen.AngelSeenHandler.class, MessageAngelSeen.class, 0, Side.SERVER);
    }
}
