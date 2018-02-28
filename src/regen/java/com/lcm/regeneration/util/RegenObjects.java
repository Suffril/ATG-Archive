package com.lcm.regeneration.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.utils.ATGSoundEvent;
import com.lcm.regeneration.ItemChameleonArch;
import com.lcm.regeneration.client.models.RenderItemFobwatch;
import com.lcm.regeneration.superpower.TimelordSuperpower;
import com.lcm.regeneration.traits.negative.TraitClumsy;
import com.lcm.regeneration.traits.negative.TraitDumb;
import com.lcm.regeneration.traits.negative.TraitFlimsy;
import com.lcm.regeneration.traits.negative.TraitFrail;
import com.lcm.regeneration.traits.negative.TraitObvious;
import com.lcm.regeneration.traits.negative.TraitRigid;
import com.lcm.regeneration.traits.negative.TraitSlow;
import com.lcm.regeneration.traits.negative.TraitUnhealthy;
import com.lcm.regeneration.traits.negative.TraitUnlucky;
import com.lcm.regeneration.traits.negative.TraitWeak;
import com.lcm.regeneration.traits.positive.TraitBouncy;
import com.lcm.regeneration.traits.positive.TraitLucky;
import com.lcm.regeneration.traits.positive.TraitQuick;
import com.lcm.regeneration.traits.positive.TraitSmart;
import com.lcm.regeneration.traits.positive.TraitSneaky;
import com.lcm.regeneration.traits.positive.TraitSpry;
import com.lcm.regeneration.traits.positive.TraitStrong;
import com.lcm.regeneration.traits.positive.TraitSturdy;
import com.lcm.regeneration.traits.positive.TraitThickSkinned;
import com.lcm.regeneration.traits.positive.TraitTough;

import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability.AbilityEntry;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
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

/**
 * Created by Nictogen on 2/18/18
 */
@Mod.EventBusSubscriber
public class RegenObjects {
	
	public static class Items {
		public static final Item chameleonArch = new ItemChameleonArch();
	}
	
	public static class SoundEvents {
		public static final SoundEvent REGENERATION = new ATGSoundEvent("regeneration");
		public static final SoundEvent TIMEY_WIMEY = new ATGSoundEvent("timey_wimey");
	}
	
	public static class Superpowers {
		public static final TimelordSuperpower timelord = TimelordSuperpower.INSTANCE;
	}
	
	public static class AbilityEntries {
		public static final AbilityEntry bouncy = newAbilityEntry(TraitBouncy.class, "bouncy");
		public static final AbilityEntry lucky = newAbilityEntry(TraitLucky.class, "lucky");
		public static final AbilityEntry quick = newAbilityEntry(TraitQuick.class, "quick");
		public static final AbilityEntry spry = newAbilityEntry(TraitSpry.class, "spry");
		public static final AbilityEntry strong = newAbilityEntry(TraitStrong.class, "strong");
		public static final AbilityEntry sturdy = newAbilityEntry(TraitSturdy.class, "sturdy");
		public static final AbilityEntry thickSkinned = newAbilityEntry(TraitThickSkinned.class, "thickskinned");
		public static final AbilityEntry tough = newAbilityEntry(TraitTough.class, "tough");
		public static final AbilityEntry smart = newAbilityEntry(TraitSmart.class, "smart");
		public static final AbilityEntry sneaky = newAbilityEntry(TraitSneaky.class, "sneaky");
		public static final AbilityEntry clumsy = newAbilityEntry(TraitClumsy.class, "clumsy");
		public static final AbilityEntry flimsy = newAbilityEntry(TraitFlimsy.class, "flimsy");
		public static final AbilityEntry frail = newAbilityEntry(TraitFrail.class, "frail");
		public static final AbilityEntry rigid = newAbilityEntry(TraitRigid.class, "rigid");
		public static final AbilityEntry slow = newAbilityEntry(TraitSlow.class, "slow");
		public static final AbilityEntry unhealthy = newAbilityEntry(TraitUnhealthy.class, "unhealthy");
		public static final AbilityEntry unlucky = newAbilityEntry(TraitUnlucky.class, "unlucky");
		public static final AbilityEntry weak = newAbilityEntry(TraitWeak.class, "weak");
		public static final AbilityEntry dumb = newAbilityEntry(TraitDumb.class, "dumb");
		public static final AbilityEntry obvious = newAbilityEntry(TraitObvious.class, "obvious");

		private static Ability.AbilityEntry newAbilityEntry(Class<? extends Ability> ability, String name) {
			return new Ability.AbilityEntry(ability, new ResourceLocation(AcrossTheGalaxy.MODID, name)); //FIXME modid
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SubscribeEvent
	public static void registerObjects(RegistryEvent event) {
		if (!(event instanceof RegistryEvent.Register)) return;
		IForgeRegistry registry = ((RegistryEvent.Register) event).getRegistry();
		
		for (Class<?> subClass : RegenObjects.class.getDeclaredClasses()) {
			if (Arrays.stream(subClass.getDeclaredFields()).noneMatch(field -> registry.getRegistrySuperType().isAssignableFrom(field.getType()))) continue;
			ArrayList<IForgeRegistryEntry> entries = new ArrayList<>();
			
			for (Field field : subClass.getDeclaredFields()) {
				try {
					entries.add((IForgeRegistryEntry)field.get(null));
				} catch (IllegalAccessException | ClassCastException e) {
					throw new RuntimeException("Incorrect field in object sub-class", e);
				}
			}
			entries.forEach(registry::register);
		}
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent ev) {// throws ReflectiveOperationException {
		for (Field f : Items.class.getDeclaredFields()) {
			try {
				Item item = (Item) f.get(null);
				ModelResourceLocation loc = new ModelResourceLocation(item.getRegistryName(), "inventory");
				ModelLoader.setCustomModelResourceLocation(item, 0, loc);
			} catch (IllegalAccessException | ClassCastException e) {
				throw new RuntimeException("Incorrect field in item-object class", e);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onModelBake(ModelBakeEvent e) {
		for (ModelResourceLocation loc : e.getModelRegistry().getKeys()) {
			
			if (loc.getResourcePath().equalsIgnoreCase("chameleonarch") && loc.getResourceDomain().equalsIgnoreCase(AcrossTheGalaxy.MODID)) { //FIXME modid
				e.getModelRegistry().putObject(loc, new RenderItemFobwatch());
			}
			
		}
	}
	
}
