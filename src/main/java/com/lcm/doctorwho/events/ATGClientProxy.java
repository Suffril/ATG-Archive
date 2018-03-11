package com.lcm.doctorwho.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.lcm.doctorwho.client.models.clothing.canon.body.Model13thCoatSteve;
import com.lcm.doctorwho.client.models.clothing.canon.hats.ModelFez;
import com.lcm.doctorwho.client.models.clothing.canon.hats.ModelFirstDocHat;
import com.lcm.doctorwho.client.models.interfaces.ITardisModel;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelHartnellTardis;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelMasqueTardis;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelPertweeTARDIS;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelTTCapsuleHellbent;
import com.lcm.doctorwho.client.render.RenderMobsInit;
import com.lcm.doctorwho.client.render.entity.layers.RenderLayerClothing;
import com.lcm.doctorwho.client.render.tiles.tardis.RenderTileTardis;
import com.lcm.doctorwho.common.mobs.hostile.EntityWeepingAngel;
import com.lcm.doctorwho.common.tiles.TileEntityTardis;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageAngelSeen;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ATGClientProxy extends ATGCommonProxy {

	public static final Map<Integer, ITardisModel> TARDIS_MODELS = new HashMap<>();
	public static final Map<Item, ModelBiped> CLOTHING = new HashMap<>();

	private ArrayList<EntityPlayer> layersAddedTo = new ArrayList<>();

	@Override
	public void init(FMLInitializationEvent event) {
		RenderMobsInit.init();
	}

	@Override
	public void postInit(FMLPostInitializationEvent ev) {
		setupTardisModels();
		setupClothingModels();
		setupTileRendering();
	}

	@SubscribeEvent
	public void renderAngels(RenderLivingEvent.Post<EntityWeepingAngel> e) {
		EntityLivingBase entity = e.getEntity();
		if (entity instanceof EntityWeepingAngel) {
			EntityWeepingAngel angel = (EntityWeepingAngel) entity;
			if (!angel.isSeen()) ATGNetwork.INSTANCE.sendToServer(new MessageAngelSeen(angel.getEntityId()));
		}
	}

	@SubscribeEvent
	public void onRenderPlayerPost(RenderPlayerEvent.Post e) {
		if (!layersAddedTo.contains(e.getEntityPlayer())) {
			layersAddedTo.add(e.getEntityPlayer());
			e.getRenderer().addLayer(new RenderLayerClothing());
		}
	}

	@SideOnly(Side.CLIENT)
	private static void setupTardisModels() {
		TARDIS_MODELS.clear();
		TARDIS_MODELS.put(0, new ModelTTCapsuleHellbent());
		TARDIS_MODELS.put(1, new ModelHartnellTardis());
		TARDIS_MODELS.put(2, new ModelPertweeTARDIS());
		TARDIS_MODELS.put(3, new ModelMasqueTardis());
	}

	@SideOnly(Side.CLIENT)
	private static void setupClothingModels() {
		CLOTHING.clear();
		CLOTHING.put(ATGObjects.Items.fez, new ModelFez());
		CLOTHING.put(ATGObjects.Items.firstDocHat, new ModelFirstDocHat());
		CLOTHING.put(ATGObjects.Items.thirtenthDocCoat, new Model13thCoatSteve());
	}

	@SideOnly(Side.CLIENT)
	private static void setupTileRendering() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTardis.class, new RenderTileTardis());
	}

}
