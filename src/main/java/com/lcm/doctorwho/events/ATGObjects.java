package com.lcm.doctorwho.events;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.models.items.ModelFirstDoctorCane;
import com.lcm.doctorwho.client.models.items.sonics.Model11thDocScrewdriver;
import com.lcm.doctorwho.client.render.item.RenderItemFobwatch;
import com.lcm.doctorwho.client.render.item.RenderItemModelBase;
import com.lcm.doctorwho.common.ATGTabs;
import com.lcm.doctorwho.common.blocks.*;
import com.lcm.doctorwho.common.blocks.BlockSlabOutline;
import com.lcm.doctorwho.common.capabilities.CapabilityTileTardis;
import com.lcm.doctorwho.common.capabilities.interfaces.ITardisTile;
import com.lcm.doctorwho.common.items.*;
import com.lcm.doctorwho.common.items.outlines.ItemClothingOutline;
import com.lcm.doctorwho.common.items.outlines.ItemOutline;
import com.lcm.doctorwho.common.items.outlines.ItemSonic;
import com.lcm.doctorwho.common.mobs.hostile.EntityCybermen;
import com.lcm.doctorwho.common.mobs.hostile.EntityWeepingAngel;
import com.lcm.doctorwho.common.mobs.projectile.EntityProjectile;
import com.lcm.doctorwho.common.superpower.TimelordSuperpower;
import com.lcm.doctorwho.common.tiles.tardis.TileEntityTardis;
import com.lcm.doctorwho.common.tiles.tardis.tardis_1963.TileEntity1963Chair;
import com.lcm.doctorwho.common.tiles.tardis.tardis_1963.TileEntity1963Rotor;
import com.lcm.doctorwho.common.traits.negative.TraitClumsy;
import com.lcm.doctorwho.common.traits.negative.TraitDumb;
import com.lcm.doctorwho.common.traits.negative.TraitFlimsy;
import com.lcm.doctorwho.common.traits.negative.TraitFrail;
import com.lcm.doctorwho.common.traits.negative.TraitObvious;
import com.lcm.doctorwho.common.traits.negative.TraitRigid;
import com.lcm.doctorwho.common.traits.negative.TraitUnhealthy;
import com.lcm.doctorwho.common.traits.negative.TraitUnlucky;
import com.lcm.doctorwho.common.traits.negative.TraitWeak;
import com.lcm.doctorwho.common.traits.positive.TraitBouncy;
import com.lcm.doctorwho.common.traits.positive.TraitLucky;
import com.lcm.doctorwho.common.traits.positive.TraitSmart;
import com.lcm.doctorwho.common.traits.positive.TraitSneaky;
import com.lcm.doctorwho.common.traits.positive.TraitSpry;
import com.lcm.doctorwho.common.traits.positive.TraitStrong;
import com.lcm.doctorwho.common.traits.positive.TraitSturdy;
import com.lcm.doctorwho.common.traits.positive.TraitThickSkinned;
import com.lcm.doctorwho.common.traits.positive.TraitTough;
import com.lcm.doctorwho.utils.ATGUtils;

import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

/**
 * Created by Nictogen on 2/18/18
 */
@Mod.EventBusSubscriber
public class ATGObjects {

	public static class Blocks {

        // Moose
        public static final Block creamRoundel = new BlockOutline(Material.CORAL, "cream_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block creamRoundelAlt = new BlockOutline(Material.CORAL, "cream_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block whiteRoundel = new BlockOutline(Material.CORAL, "white_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block whiteRoundelAlt = new BlockOutline(Material.CORAL, "white_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block pinkRoundel = new BlockOutline(Material.CORAL, "pink_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block pinkRoundelAlt = new BlockOutline(Material.CORAL, "pink_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block blackRoundel = new BlockOutline(Material.CORAL, "black_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block blackRoundelAlt = new BlockOutline(Material.CORAL, "black_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block blueRoundel = new BlockOutline(Material.CORAL, "blue_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block blueRoundelAlt = new BlockOutline(Material.CORAL, "blue_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block brownRoundel = new BlockOutline(Material.CORAL, "brown_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block brownRoundelAlt = new BlockOutline(Material.CORAL, "brown_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block cyanRoundel = new BlockOutline(Material.CORAL, "cyan_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block cyanRoundelAlt = new BlockOutline(Material.CORAL, "cyan_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block darkGreyRoundel = new BlockOutline(Material.CORAL, "dark_grey_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block darkGreyRoundelAlt = new BlockOutline(Material.CORAL, "dark_grey_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block greenRoundel = new BlockOutline(Material.CORAL, "green_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block greenRoundelAlt = new BlockOutline(Material.CORAL, "green_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block lightBlueRoundel = new BlockOutline(Material.CORAL, "light_blue_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block lightBlueRoundelAlt = new BlockOutline(Material.CORAL, "light_blue_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block lightGreyRoundel = new BlockOutline(Material.CORAL, "light_grey_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block lightGreyRoundelAlt = new BlockOutline(Material.CORAL, "light_grey_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block limeRoundel = new BlockOutline(Material.CORAL, "lime_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block limeRoundelAlt = new BlockOutline(Material.CORAL, "lime_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block magentaRoundel = new BlockOutline(Material.CORAL, "magenta_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block magentaRoundelAlt = new BlockOutline(Material.CORAL, "magenta_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block orangeRoundel = new BlockOutline(Material.CORAL, "orange_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block orangeRoundelAlt = new BlockOutline(Material.CORAL, "orange_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block purpleRoundel = new BlockOutline(Material.CORAL, "purple_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block purpleRoundelAlt = new BlockOutline(Material.CORAL, "purple_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block redRoundel = new BlockOutline(Material.CORAL, "red_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block redRoundelAlt = new BlockOutline(Material.CORAL, "red_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block yellowRoundel = new BlockOutline(Material.CORAL, "yellow_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block yellowRoundelAlt = new BlockOutline(Material.CORAL, "yellow_roundel_alt").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block alfLog = new BlockOutline(Material.WOOD, "alf_log").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block alfLeaves = new LeavesOutline("alf_leaves").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block coralWall = new BlockOutline(Material.CORAL, "coral_wall").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);
        public static final Block coralRoundel = new BlockOutline(Material.CORAL, "coral_roundel").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);

        // Tardis
        public static final Block tardis = new BlockTardis(Material.CORAL, "tardis").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS);

        // Troughton - Fault Locator
        public static final Block tro_fault_1 = new BlockOutline(Material.CORAL, "tro_fault_1").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_fault_2 = new BlockOutline(Material.CORAL, "tro_fault_2").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_fault_3 = new BlockOutline(Material.CORAL, "tro_fault_3").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_fault_4 = new BlockOutline(Material.CORAL, "tro_fault_4").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_fault_5 = new BlockOutline(Material.CORAL, "tro_fault_5").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_fault_6 = new BlockOutline(Material.CORAL, "tro_fault_6").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_fault_7 = new BlockOutline(Material.CORAL, "tro_fault_7").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_fault_8 = new BlockOutline(Material.CORAL, "tro_fault_8").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);

        // Troughton - Flat roundels
        public static final Block tro_flatroundel_1 = new BlockOutline(Material.CORAL, "tro_flatroundel_1").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_flatroundel_2 = new BlockOutline(Material.CORAL, "tro_flatroundel_2").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_flatroundel_3 = new BlockOutline(Material.CORAL, "tro_flatroundel_3").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_flatroundel_4 = new BlockOutline(Material.CORAL, "tro_flatroundel_4").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_flatroundel_5 = new BlockOutline(Material.CORAL, "tro_flatroundel_5").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);;

        // Troughton - Roundel walls
        public static final Block tro_roundel_1 = new BlockOutline(Material.CORAL, "tro_roundel_1").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_roundel_2 = new BlockOutline(Material.CORAL, "tro_roundel_2").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_roundel_3 = new BlockOutline(Material.CORAL, "tro_roundel_3").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);;

        public static final Block tro_slab_full_1 = new BlockOutline(Material.CORAL, "tro_slab_full_1").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_slab_full_2 = new BlockOutline(Material.CORAL, "tro_slab_full_2").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_slab_1 = new BlockSlabOutline("tro_slab_1", tro_slab_full_1.getDefaultState(), Material.CORAL).setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block tro_slab_2 = new BlockSlabOutline("tro_slab_2", tro_slab_full_2.getDefaultState(), Material.CORAL).setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);

		public static final Block tro_flatroundel_slab_full_1 = new BlockOutline(Material.CORAL, "tro_flatroundel_slab_full_1").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
		public static final Block tro_flatroundel_slab_full_2 = new BlockOutline(Material.CORAL, "tro_flatroundel_slab_full_2").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
		public static final Block tro_flatroundel_slab_full_3 = new BlockOutline(Material.CORAL, "tro_flatroundel_slab_full_3").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);

		public static final Block tro_flatroundel_slab_1 = new BlockSlabOutline("tro_flatroundel_slab_1", tro_flatroundel_slab_full_1.getDefaultState(), Material.CORAL).setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
		public static final Block tro_flatroundel_slab_2 = new BlockSlabOutline("tro_flatroundel_slab_2", tro_flatroundel_slab_full_2.getDefaultState(), Material.CORAL).setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
		public static final Block tro_flatroundel_slab_3 = new BlockSlabOutline("tro_flatroundel_slab_3", tro_flatroundel_slab_full_3.getDefaultState(), Material.CORAL).setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);

		public static final Block rotor1963 = new BlockTileOutline(Material.CORAL,"rotor1963", TileEntity1963Rotor.class).setLightLevel(1.0F).setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block light = new BlockLight().setRegistryName("light").setUnlocalizedName("light").setLightLevel(1.0F);
        public static final Block chair1963 = new BlockTileOutline(Material.CORAL,"chair1963", TileEntity1963Chair.class).setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);

        public static final Block ha_tro_cons = new BlockOutline(Material.CORAL, "ha_tro_cons").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block ha_tro_floor = new BlockOutline(Material.CORAL, "ha_tro_floor").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);
        public static final Block ha_tro_roof = new BlockOutline(Material.CORAL, "ha_tro_roof").setCreativeTab(ATGTabs.TABS_BLOCKS_TARDIS_2);


    }

	public static class EntityEntries { // NO_UCD (unused code)
		public static final EntityEntry weepingAngel = EntityEntryBuilder.create().entity(EntityWeepingAngel.class).id(new ResourceLocation(AcrossTheGalaxy.MODID, "weeping_angel"), 0).egg(1, 0).name("angel").tracker(80, 3, false).build();
		public static final EntityEntry laser = EntityEntryBuilder.create().entity(EntityProjectile.class).id(new ResourceLocation(AcrossTheGalaxy.MODID, "laser"), 1).name("laser").tracker(80, 3, true).build();
		public static final EntityEntry cyberMan = EntityEntryBuilder.create().entity(EntityCybermen.class).id(new ResourceLocation(AcrossTheGalaxy.MODID, "cybermen"), 2).egg(1, 0).name("cybermen").tracker(80, 3, false).build();
	}

    public static class Items {
        public static Item eleventhDocSonic = new ItemSonic("sonic_eleventh_doc", SoundEvents.regeneration).setCreativeTab(ATGTabs.TABS_ITEMS_SONICS);
        public static Item firstDocCane = new ItemOutline("cane_first_doc").setCreativeTab(ATGTabs.TABS_ITEMS_SONICS);
        public static Item chameleonArch = new ItemChameleonArch();
        public static Item fez = new ItemClothingOutline("fez", ItemArmor.ArmorMaterial.LEATHER, EntityEquipmentSlot.HEAD);// .setCreativeTab(ATGTabs.TABS_ITEMS_CLOTHING);
        public static Item firstDocHat = new ItemClothingOutline("firstDocHat", ItemArmor.ArmorMaterial.LEATHER, EntityEquipmentSlot.HEAD);// .setCreativeTab(ATGTabs.TABS_ITEMS_CLOTHING);
        public static Item thirtenthDocCoat = new ItemClothingOutline("thirtenthDocCoat", ItemArmor.ArmorMaterial.LEATHER, EntityEquipmentSlot.CHEST);
    }

	public static class SoundEvents {
		public static final SoundEvent regeneration = new ATGUtils.ATGSoundEvent("regeneration");
		public static final SoundEvent timeyWimey = new ATGUtils.ATGSoundEvent("timey_wimey");
		public static final SoundEvent tardis_pb_open = new ATGUtils.ATGSoundEvent("tardis_pb_open");
		public static final SoundEvent tardis_pb_close = new ATGUtils.ATGSoundEvent("tardis_pb_close");
	}
	
	public static class Superpowers { // NO_UCD (unused code)
		public static final TimelordSuperpower timelord = TimelordSuperpower.INSTANCE;
	}
	
	public static class AbilityEntries { // NO_UCD (unused code)
		public static final Ability.AbilityEntry bouncy = newAbilityEntry(TraitBouncy.class, "bouncy");
		public static final Ability.AbilityEntry lucky = newAbilityEntry(TraitLucky.class, "lucky");
		public static final Ability.AbilityEntry spry = newAbilityEntry(TraitSpry.class, "spry");
		public static final Ability.AbilityEntry strong = newAbilityEntry(TraitStrong.class, "strong");
		public static final Ability.AbilityEntry sturdy = newAbilityEntry(TraitSturdy.class, "sturdy");
		public static final Ability.AbilityEntry thickSkinned = newAbilityEntry(TraitThickSkinned.class, "thickskinned");
		public static final Ability.AbilityEntry tough = newAbilityEntry(TraitTough.class, "tough");
		public static final Ability.AbilityEntry smart = newAbilityEntry(TraitSmart.class, "smart");
		public static final Ability.AbilityEntry sneaky = newAbilityEntry(TraitSneaky.class, "sneaky");
		public static final Ability.AbilityEntry clumsy = newAbilityEntry(TraitClumsy.class, "clumsy");
		public static final Ability.AbilityEntry flimsy = newAbilityEntry(TraitFlimsy.class, "flimsy");
		public static final Ability.AbilityEntry frail = newAbilityEntry(TraitFrail.class, "frail");
		public static final Ability.AbilityEntry rigid = newAbilityEntry(TraitRigid.class, "rigid");
		public static final Ability.AbilityEntry unhealthy = newAbilityEntry(TraitUnhealthy.class, "unhealthy");
		public static final Ability.AbilityEntry unlucky = newAbilityEntry(TraitUnlucky.class, "unlucky");
		public static final Ability.AbilityEntry weak = newAbilityEntry(TraitWeak.class, "weak");
		public static final Ability.AbilityEntry dumb = newAbilityEntry(TraitDumb.class, "dumb");
		public static final Ability.AbilityEntry obvious = newAbilityEntry(TraitObvious.class, "obvious");
		
		private static Ability.AbilityEntry newAbilityEntry(Class<? extends Ability> ability, String name) {
			return new Ability.AbilityEntry(ability, new ResourceLocation(AcrossTheGalaxy.MODID, name));
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SubscribeEvent
	public static void registerObjects(RegistryEvent ev) {
		if (!(ev instanceof RegistryEvent.Register)) return;
		IForgeRegistry registry = ((RegistryEvent.Register) ev).getRegistry();
		
		for (Class<?> aClass : ATGObjects.class.getDeclaredClasses()) {
			if (Arrays.stream(aClass.getDeclaredFields()).noneMatch(field -> registry.getRegistrySuperType().isAssignableFrom(field.getType()))) continue;
			ArrayList<IForgeRegistryEntry> entries = new ArrayList<>();
			
			for (Field field : aClass.getDeclaredFields())
				try {
					entries.add((IForgeRegistryEntry) field.get(null));
				} catch (IllegalAccessException | ClassCastException e) {
					throw new RuntimeException("Incorrect field in object sub-class", e);
				}
			
			if (Arrays.stream(aClass.getDeclaredFields()).anyMatch(field -> Item.class.isAssignableFrom(field.getType()))) {
				for (Field f : Blocks.class.getDeclaredFields()) {
					try {
						Block block = (Block) f.get(null);
							entries.add(new ItemBlock(block).setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getUnlocalizedName()));
					} catch (IllegalAccessException | ClassCastException e) {
						throw new RuntimeException("Incorrect field in object sub-class", e);
					}
				}
			}
			
			entries.forEach(registry::register);
		}
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent ev) {
		for (Field f : Items.class.getDeclaredFields()) {
			try {
				Item item = (Item) f.get(null);
				ModelResourceLocation loc = new ModelResourceLocation(item.getRegistryName(), "inventory");
				ModelLoader.setCustomModelResourceLocation(item, 0, loc);
			} catch (IllegalAccessException | ClassCastException e) {
				throw new RuntimeException("Incorrect field in item sub-class", e);
			}
		}
		
		for (Field f : Blocks.class.getDeclaredFields()) {
			try {
				Block block = (Block) f.get(null);
				Item item = Item.getItemFromBlock(block);
				ModelResourceLocation loc = new ModelResourceLocation(item.getRegistryName(), "inventory");
				ModelLoader.setCustomModelResourceLocation(item, 0, loc);
			} catch (IllegalAccessException | ClassCastException e) {
				throw new RuntimeException("Incorrect field in item sub-class", e);
			}
		}
	}

	public static void setUpTiles() {
		GameRegistry.registerTileEntity(TileEntityTardis.class, AcrossTheGalaxy.MODID + ":tardis");
		GameRegistry.registerTileEntity(TileEntity1963Rotor.class, AcrossTheGalaxy.MODID + ":1963rotor");
		GameRegistry.registerTileEntity(TileEntity1963Chair.class, AcrossTheGalaxy.MODID + ":1963chair");
	}

	public static void setUpCapabilities()
    {
        CapabilityManager.INSTANCE.register(ITardisTile.class, new CapabilityTileTardis.Storage(), CapabilityTileTardis.class);
    }

	@SideOnly(Side.CLIENT) // note: this means *physical* side
	@SubscribeEvent
	public static void onModelBake(ModelBakeEvent e) {
		for (ModelResourceLocation loc : e.getModelRegistry().getKeys()) {
			
			if (loc.getResourceDomain().equalsIgnoreCase(AcrossTheGalaxy.MODID)) {
				if (loc.getResourcePath().equalsIgnoreCase("sonic_eleventh_doc")) e.getModelRegistry().putObject(loc, new RenderItemModelBase(null, new Model11thDocScrewdriver(), new ResourceLocation(AcrossTheGalaxy.MODID, "textures/items/sonics/11th_sonic.png")));
				if (loc.getResourcePath().equalsIgnoreCase("cane_first_doc")) e.getModelRegistry().putObject(loc, new RenderItemModelBase(null, new ModelFirstDoctorCane(), new ResourceLocation(AcrossTheGalaxy.MODID, "textures/items/first_doc_cane.png")));
				if (loc.getResourcePath().equalsIgnoreCase("chameleonarch")) e.getModelRegistry().putObject(loc, new RenderItemFobwatch());
			}
		}
	}
}
