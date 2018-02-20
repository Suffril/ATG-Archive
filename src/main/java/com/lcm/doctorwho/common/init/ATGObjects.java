package com.lcm.doctorwho.common.init;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.client.ATGTabs;
import com.lcm.doctorwho.client.models.ModelTest;
import com.lcm.doctorwho.client.models.items.Model4thDoctorScrewdriver;
import com.lcm.doctorwho.client.render.RenderItemModelBase;
import com.lcm.doctorwho.common.items.ItemChameleonArch;
import com.lcm.doctorwho.common.items.ItemOutline;
import com.lcm.doctorwho.common.items.ItemSonic;
import com.lcm.doctorwho.common.superpower.TimelordSuperpower;
import com.lcm.doctorwho.common.traits.negative.TraitClumsy;
import com.lcm.doctorwho.common.traits.negative.TraitDumb;
import com.lcm.doctorwho.common.traits.negative.TraitFlimsy;
import com.lcm.doctorwho.common.traits.negative.TraitFrail;
import com.lcm.doctorwho.common.traits.negative.TraitObvious;
import com.lcm.doctorwho.common.traits.negative.TraitRigid;
import com.lcm.doctorwho.common.traits.negative.TraitSlow;
import com.lcm.doctorwho.common.traits.negative.TraitUnhealthy;
import com.lcm.doctorwho.common.traits.negative.TraitUnlucky;
import com.lcm.doctorwho.common.traits.negative.TraitWeak;
import com.lcm.doctorwho.common.traits.positive.TraitBouncy;
import com.lcm.doctorwho.common.traits.positive.TraitLucky;
import com.lcm.doctorwho.common.traits.positive.TraitQuick;
import com.lcm.doctorwho.common.traits.positive.TraitSmart;
import com.lcm.doctorwho.common.traits.positive.TraitSneaky;
import com.lcm.doctorwho.common.traits.positive.TraitSpry;
import com.lcm.doctorwho.common.traits.positive.TraitStrong;
import com.lcm.doctorwho.common.traits.positive.TraitSturdy;
import com.lcm.doctorwho.common.traits.positive.TraitThickSkinned;
import com.lcm.doctorwho.common.traits.positive.TraitTough;

import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber
public class ATGObjects {

	public static class Items {
		public static final ItemChameleonArch chameleonArch = new ItemChameleonArch();
		public static final Item fourthDocSonic = new ItemSonic("fourthdocsonic", SoundEvents.REGENERATION).setCreativeTab(ATGTabs.TABS_ITEMS_SONICS);
		}

		public static class Blocks {

		}

		public static class SoundEvents {
			public static final SoundEvent REGENERATION = new SoundEvent(new ResourceLocation(AcrossTheGalaxy.MODID, "regeneration")).setRegistryName(AcrossTheGalaxy.MODID, "regeneration");
			public static final SoundEvent TIMEY_WIMEY = new SoundEvent(new ResourceLocation(AcrossTheGalaxy.MODID, "timey_wimey")).setRegistryName(AcrossTheGalaxy.MODID, "timey_wimey");
		}

		public static class EntityEntries {
			// public static final EntityEntry example = EntityEntryBuilder.create().id(new ResourceLocation(AcrossTheGalaxy.MODID, "NAME"), ID_NUMBER).name("NAME");
			// public static final EntityEntry example = EntityEntryBuilder.create().id(new ResourceLocation(AcrossTheGalaxy.MODID, "NAME"), ID_NUMBER).name("NAME");
		}

		public static class Superpowers {
			public static final TimelordSuperpower timelord = TimelordSuperpower.INSTANCE;
		}

		public static class AbilityEntries {
			public static final Ability.AbilityEntry bouncy = newAbilityEntry(TraitBouncy.class, "bouncy");
			public static final Ability.AbilityEntry lucky = newAbilityEntry(TraitLucky.class, "lucky");
			public static final Ability.AbilityEntry quick = newAbilityEntry(TraitQuick.class, "quick");
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
			public static final Ability.AbilityEntry slow = newAbilityEntry(TraitSlow.class, "slow");
			public static final Ability.AbilityEntry unhealthy = newAbilityEntry(TraitUnhealthy.class, "unhealthy");
			public static final Ability.AbilityEntry unlucky = newAbilityEntry(TraitUnlucky.class, "unlucky");
			public static final Ability.AbilityEntry weak = newAbilityEntry(TraitWeak.class, "weak");
			public static final Ability.AbilityEntry dumb = newAbilityEntry(TraitDumb.class, "dumb");
			public static final Ability.AbilityEntry obvious = newAbilityEntry(TraitObvious.class, "obvious");
		}

		@SuppressWarnings({"rawtypes", "unchecked"})
		@SubscribeEvent
		public static void registerObjects(RegistryEvent event) throws Exception {
			if (event instanceof RegistryEvent.Register) {
				IForgeRegistry registry = ((RegistryEvent.Register) event).getRegistry();

				for (Class<?> aClass : ATGObjects.class.getDeclaredClasses()) {
					if (Arrays.stream(aClass.getDeclaredFields()).anyMatch(field -> registry.getRegistrySuperType().isAssignableFrom(field.getType()))) {
						ArrayList<IForgeRegistryEntry> entries = new ArrayList<>();

						for (Field field : aClass.getDeclaredFields()) {
							try {
								entries.add((IForgeRegistryEntry) field.get(null));
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							}
						}

						if (aClass.isAssignableFrom(Item.class)) {
							for (Field f : Blocks.class.getDeclaredFields()) {
								Block block = (Block) f.get(null);
								entries.add(new ItemBlock(block).setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getUnlocalizedName()));
							}
						}
						entries.forEach(registry::register);
					}

				}
			}
		}

		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent e) throws ReflectiveOperationException {
			for (Field f : Items.class.getDeclaredFields()) {
				Item item = (Item) f.get(null);
				ModelResourceLocation loc = new ModelResourceLocation(item.getRegistryName(), "inventory");
				ModelLoader.setCustomModelResourceLocation(item, 0, loc);
			}

			for (Field f : Blocks.class.getDeclaredFields()) {
				Block block = (Block) f.get(null);
				Item item = Item.getItemFromBlock(block);
				ModelResourceLocation loc = new ModelResourceLocation(item.getRegistryName(), "inventory");
				ModelLoader.setCustomModelResourceLocation(item, 0, loc);
			}
		}

		private static Ability.AbilityEntry newAbilityEntry(Class<? extends Ability> ability, String name) {
			return new Ability.AbilityEntry(ability, new ResourceLocation(AcrossTheGalaxy.MODID, name));
		}

		@SideOnly(Side.CLIENT)
		@SubscribeEvent
		public static void onModelBake(ModelBakeEvent e) {
			for (ModelResourceLocation loc : e.getModelRegistry().getKeys()) {
				if (loc.getResourceDomain().equalsIgnoreCase(AcrossTheGalaxy.MODID) && loc.getResourcePath().equalsIgnoreCase("fourthdocsonic"))
					e.getModelRegistry().putObject(loc, new RenderItemModelBase(null, new Model4thDoctorScrewdriver(), new ResourceLocation(AcrossTheGalaxy.MODID, "textures/items/sonics/4th_sonic.png")) {
					});
			}
		}
}