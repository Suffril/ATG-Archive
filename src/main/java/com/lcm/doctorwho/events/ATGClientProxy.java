package com.lcm.doctorwho.events;

import com.lcm.doctorwho.client.models.entity.ModelWeepingAngel;
import com.lcm.doctorwho.client.models.interfaces.ITardisModel;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelHartnellTardis;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelPertweeTARDIS;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelTTCapsuleHellbent;
import com.lcm.doctorwho.client.render.entity.RenderEntityBase;
import com.lcm.doctorwho.client.render.entity.layers.RenderLayerHat;
import com.lcm.doctorwho.client.render.tiles.tardis.RenderTileTardis;
import com.lcm.doctorwho.common.tiles.TileEntityTardis;
import com.lcm.doctorwho.common.mobs.EntityWeepingAngel;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageAngelSeen;

import com.lcm.doctorwho.utils.ATGUtils;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ATGClientProxy extends ATGCommonProxy {

	public static final Map<Integer, ITardisModel> TARDIS_MODELS = new HashMap<>();

    private ArrayList<EntityPlayer> layersAddedTo = new ArrayList<>();

	@Override
	public void init(FMLInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityWeepingAngel.class, new RenderEntityBase<>(new ModelWeepingAngel(), "weeping_angel", 1.0F));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTardis.class, new RenderTileTardis());
        setupTardisModels();
	}
	
	@SubscribeEvent
	public void renderAngels(RenderLivingEvent.Post<EntityWeepingAngel> e) {
		EntityLivingBase entity = e.getEntity();
		if (entity instanceof EntityWeepingAngel) {
			EntityWeepingAngel angel = (EntityWeepingAngel) entity;
			if(!angel.isSeen()) ATGNetwork.INSTANCE.sendToServer(new MessageAngelSeen(angel.getEntityId()));
		}
	}

    @SubscribeEvent
    public void onRenderPlayerPost(RenderPlayerEvent.Post e) {
        if (!layersAddedTo.contains(e.getEntityPlayer())) {
            layersAddedTo.add(e.getEntityPlayer());
            e.getRenderer().addLayer(new RenderLayerHat());
        }
    }


        private static void setupTardisModels()
	{
	    TARDIS_MODELS.clear();
		TARDIS_MODELS.put(0, new ModelTTCapsuleHellbent());
		TARDIS_MODELS.put(1, new ModelHartnellTardis());
		TARDIS_MODELS.put(2, new ModelPertweeTARDIS());
	}

}
