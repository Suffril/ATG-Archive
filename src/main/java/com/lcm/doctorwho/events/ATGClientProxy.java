package com.lcm.doctorwho.events;

import com.lcm.doctorwho.client.gui.GuiRegenCustomizer;
import com.lcm.doctorwho.client.models.clothing.canon.body.Model13thCoatSteve;
import com.lcm.doctorwho.client.models.clothing.canon.hats.ModelFez;
import com.lcm.doctorwho.client.models.clothing.canon.hats.ModelFirstDocHat;
import com.lcm.doctorwho.client.models.clothing.canon.hats.ModelFourthDoctorHat;
import com.lcm.doctorwho.client.models.interfaces.ITardisModel;
import com.lcm.doctorwho.client.models.tardis.decoration.Model1963ChairSmall;
import com.lcm.doctorwho.client.models.tardis.decoration.Model1963Rotor;
import com.lcm.doctorwho.client.models.tardis.decoration.ModelMonitor;
import com.lcm.doctorwho.client.models.tardis.decoration.ModelMonitorToyota;
import com.lcm.doctorwho.client.models.tardis.exteriors.*;
import com.lcm.doctorwho.client.render.RenderMobsInit;
import com.lcm.doctorwho.client.render.entity.layers.RenderLayerHat;
import com.lcm.doctorwho.client.render.tiles.tardis.RenderTileBase;
import com.lcm.doctorwho.client.render.tiles.tardis.RenderTileInteriorDoor;
import com.lcm.doctorwho.client.render.tiles.tardis.RenderTileMonitor;
import com.lcm.doctorwho.client.render.tiles.tardis.RenderTileTardis;
import com.lcm.doctorwho.common.capabilities.timelord.TimelordClientEventHandler;
import com.lcm.doctorwho.common.entity.hostile.EntityWeepingAngel;
import com.lcm.doctorwho.common.tiles.tardis.TileEntityInteriorDoor;
import com.lcm.doctorwho.common.tiles.tardis.monitors.TileEntityMonitor;
import com.lcm.doctorwho.common.tiles.tardis.TileEntityTardis;
import com.lcm.doctorwho.common.tiles.tardis.monitors.TileEntityToyotaMonitor;
import com.lcm.doctorwho.common.tiles.tardis.tardis_1963.TileEntity1963Chair;
import com.lcm.doctorwho.common.tiles.tardis.tardis_1963.TileEntity1963Rotor;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageAngelSeen;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
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

    private ArrayList<EntityPlayer> LAYERED_PLAYERS = new ArrayList<>();

	@Override public void preInit(FMLPreInitializationEvent ev) {
		RenderMobsInit.init();
	}

	@Override public void init(FMLInitializationEvent event) {
	    setupATGMusicTypes();
		super.init(event);
		MinecraftForge.EVENT_BUS.register(new TimelordClientEventHandler());
	}

	@Override public void postInit(FMLPostInitializationEvent ev) {
		setupTardisModels();
		setupClothingModels();
		setupTileRendering();
		ClientCommandHandler.instance.registerCommand(new GuiRegenCustomizer.CustomizeCommand());
	}

	@SubscribeEvent public static void renderAngels(RenderLivingEvent.Post<EntityWeepingAngel> e) {
		EntityLivingBase entity = e.getEntity();
		if (entity instanceof EntityWeepingAngel) {
			EntityWeepingAngel angel = (EntityWeepingAngel) entity;
			if (!angel.isSeen())
				ATGNetwork.INSTANCE.sendToServer(new MessageAngelSeen(angel.getEntityId()));
		}
	}

	@SubscribeEvent public void onRenderPlayerPost(RenderPlayerEvent.Post e) {
		if (!LAYERED_PLAYERS.contains(e.getEntityPlayer())) {
			LAYERED_PLAYERS.add(e.getEntityPlayer());
			e.getRenderer().addLayer(new RenderLayerHat());
		}
	}

	@SideOnly(Side.CLIENT) private static void setupTardisModels() {
		TARDIS_MODELS.clear();
		TARDIS_MODELS.put(0, new ModelTTCapsuleHellbent());
		TARDIS_MODELS.put(1, new ModelHartnellTardis());
		TARDIS_MODELS.put(2, new ModelPertweeTARDIS());
		TARDIS_MODELS.put(3, new ModelMasqueTardis());
        TARDIS_MODELS.put(4, new ModelDavisonTardis());
        TARDIS_MODELS.put(5, new ModelMovie1998Tardis());
	}

	@SideOnly(Side.CLIENT) private static void setupClothingModels() {
		CLOTHING.clear();
		CLOTHING.put(ATGObjects.Items.fez, new ModelFez());
		CLOTHING.put(ATGObjects.Items.firstDocHat, new ModelFirstDocHat());
		CLOTHING.put(ATGObjects.Items.fourthDocHat, new ModelFourthDoctorHat());
		CLOTHING.put(ATGObjects.Items.thirtenthDocCoat, new Model13thCoatSteve());
	}

	@SideOnly(Side.CLIENT) private static void setupTileRendering() {
		addTileRender(TileEntityTardis.class, new RenderTileTardis());
		addTileRender(TileEntityInteriorDoor.class, new RenderTileInteriorDoor());
		addTileRender(TileEntityMonitor.class, new RenderTileMonitor(new ModelMonitor()));
		addTileRender(TileEntityToyotaMonitor.class, new RenderTileMonitor(new ModelMonitorToyota()));
		addTileRender(TileEntity1963Rotor.class, new RenderTileBase(new Model1963Rotor()));
		addTileRender(TileEntity1963Chair.class, new RenderTileBase(new Model1963ChairSmall()));
	}

    @SideOnly(Side.CLIENT) private static void setupATGMusicTypes() {
       EnumHelperClient.addMusicType("TARDIS_HUM", ATGObjects.SoundEvents.interiorHum, 0, 49);
    }

	private static <T extends TileEntity> void addTileRender(Class<T> tileEntity, TileEntitySpecialRenderer<? super T> specialRenderer)
	{
		ClientRegistry.bindTileEntitySpecialRenderer(tileEntity,specialRenderer);
	}


}
