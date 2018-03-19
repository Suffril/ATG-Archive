package com.lcm.doctorwho.events;

import com.lcm.doctorwho.client.gui.GuiRegenCustomizer;
import com.lcm.doctorwho.client.models.clothing.canon.hats.ModelFez;
import com.lcm.doctorwho.client.models.clothing.canon.hats.ModelFirstDocHat;
import com.lcm.doctorwho.client.models.interfaces.ITardisModel;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelHartnellTardis;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelMasqueTardis;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelPertweeTARDIS;
import com.lcm.doctorwho.client.models.tardis.exteriors.ModelTTCapsuleHellbent;
import com.lcm.doctorwho.client.render.RenderMobsInit;
import com.lcm.doctorwho.client.render.entity.layers.RenderLayerHat;
import com.lcm.doctorwho.client.render.tiles.tardis.RenderTileInteriorDoor;
import com.lcm.doctorwho.client.render.tiles.tardis.RenderTileTardis;
import com.lcm.doctorwho.common.capabilities.timelord.TimelordClientEventHandler;
import com.lcm.doctorwho.common.entity.hostile.EntityWeepingAngel;
import com.lcm.doctorwho.common.tiles.tardis.TileEntityInteriorDoor;
import com.lcm.doctorwho.common.tiles.tardis.TileEntityTardis;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageAngelSeen;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ATGClientProxy extends ATGCommonProxy {

	public static final Map<Integer, ITardisModel> TARDIS_MODELS = new HashMap<>();
	public static final Map<Item, ModelBiped> CLOTHING = new HashMap<>();

	private ArrayList<EntityPlayer> layersAddedTo = new ArrayList<>();

	@Override public void preInit(FMLPreInitializationEvent ev) {
		RenderMobsInit.init();
	}

	@Override public void init(FMLInitializationEvent event) {
		super.init(event);
		MinecraftForge.EVENT_BUS.register(new TimelordClientEventHandler());
	}

	@Override public void postInit(FMLPostInitializationEvent ev) {
		setupTardisModels();
		setupClothingModels();
		setupTileRendering();
		ClientCommandHandler.instance.registerCommand(new GuiRegenCustomizer.CustomizeCommand());
	}

	@SubscribeEvent public void renderAngels(RenderLivingEvent.Post<EntityWeepingAngel> e) {
		EntityLivingBase entity = e.getEntity();
		if (entity instanceof EntityWeepingAngel) {
			EntityWeepingAngel angel = (EntityWeepingAngel) entity;
			if (!angel.isSeen())
				ATGNetwork.INSTANCE.sendToServer(new MessageAngelSeen(angel.getEntityId()));
		}
	}

	@SubscribeEvent public void onRenderPlayerPost(RenderPlayerEvent.Post e) {
		if (!layersAddedTo.contains(e.getEntityPlayer())) {
			layersAddedTo.add(e.getEntityPlayer());
			e.getRenderer().addLayer(new RenderLayerHat());
		}
	}

	@SideOnly(Side.CLIENT) private static void setupTardisModels() {
		TARDIS_MODELS.clear();
		TARDIS_MODELS.put(0, new ModelTTCapsuleHellbent());
		TARDIS_MODELS.put(1, new ModelHartnellTardis());
		TARDIS_MODELS.put(2, new ModelPertweeTARDIS());
		TARDIS_MODELS.put(3, new ModelMasqueTardis());
	}

	@SideOnly(Side.CLIENT) private static void setupClothingModels() {
		CLOTHING.clear();
		CLOTHING.put(ATGObjects.Items.fez, new ModelFez());
		CLOTHING.put(ATGObjects.Items.firstDocHat, new ModelFirstDocHat());
	}

	@SideOnly(Side.CLIENT) private static void setupTileRendering() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTardis.class, new RenderTileTardis());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInteriorDoor.class, new RenderTileInteriorDoor());
	}

}
