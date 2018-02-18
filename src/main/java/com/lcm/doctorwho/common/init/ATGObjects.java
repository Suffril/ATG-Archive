package com.lcm.doctorwho.common.init;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.items.ItemChameleonArch;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nictogen on 2/18/18
 */
@Mod.EventBusSubscriber
public class ATGObjects
{
	public static class Items
	{

		public static final ItemChameleonArch chameleonArch = new ItemChameleonArch();

	}

	public static class SoundEvents
	{

		public static final SoundEvent REGENERATION = new SoundEvent(new ResourceLocation(AcrossTheGalaxy.MODID, "regeneration")).setRegistryName("regeneration");
		public static final SoundEvent TIMEY_WIMEY = new SoundEvent(new ResourceLocation(AcrossTheGalaxy.MODID, "timey_wimey")).setRegistryName("timey_wimey");

	}

	@SubscribeEvent
	public static void registerObjects(RegistryEvent event) throws Exception
	{
		if(event instanceof RegistryEvent.Register)
		{
			IForgeRegistry registry = ((RegistryEvent.Register) event).getRegistry();

			for (Class<?> aClass : ATGObjects.class.getDeclaredClasses())
			{
				if (Arrays.stream(aClass.getDeclaredFields()).anyMatch(field -> registry.getRegistrySuperType().isAssignableFrom(field.getType())))
				{
					ArrayList<IForgeRegistryEntry> entries = new ArrayList<>();

					for (Field field : aClass.getDeclaredFields())
					{
						try
						{
							entries.add((IForgeRegistryEntry) field.get(null));
						}
						catch (IllegalAccessException e)
						{
							e.printStackTrace();
						}
					}
					entries.forEach(registry::register);
				}

			}
		}
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent e) throws ReflectiveOperationException
	{
		ModelLoader.setCustomModelResourceLocation(
				Items.chameleonArch, 0, new ModelResourceLocation(Items.chameleonArch.getRegistryName(), "inventory"));
	}
}
