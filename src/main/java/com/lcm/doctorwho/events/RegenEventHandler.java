package com.lcm.doctorwho.events;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.superpower.TimelordSuperpower;
import com.lcm.doctorwho.common.superpower.TimelordSuperpowerHandler;
import com.lcm.doctorwho.utils.ATGConfig;
import com.lcm.doctorwho.utils.DebugCommand.NoRegenDamageSource;
import com.lcm.doctorwho.utils.DebugCommand.QuickRegenDamageSource;
import com.lcm.doctorwho.utils.ExplosionUtil;

import lucraft.mods.lucraftcore.superpowers.SuperpowerHandler;
import lucraft.mods.lucraftcore.superpowers.capabilities.CapabilitySuperpower;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber
public class RegenEventHandler { // NO_UCD (unused code)

	@SubscribeEvent
	public static void registerLoot(LootTableLoadEvent e) { //CHECK can this loot table actually be overriden in resource packs?
		if (!e.getName().toString().toLowerCase().matches(ATGConfig.lootRegex) || ATGConfig.disableArch) return;
		
		LootCondition[] condAlways = new LootCondition[] { new RandomChance(1F) };
		LootEntry entry = new LootEntryTable(new ResourceLocation(AcrossTheGalaxy.MODID, "inject/arch_loot"), 1, 1, condAlways, "lcm-regen:arch-entry");
		LootPool lootPool = new LootPool(new LootEntry[] { entry }, condAlways, new RandomValueRange(1), new RandomValueRange(1), "lcm-regen:arch-pool");
		e.getTable().addPool(lootPool);
	}
	
	@SubscribeEvent
	public static void onAttacked(LivingAttackEvent e) {
		if (!(e.getEntity() instanceof EntityPlayer) || !SuperpowerHandler.hasSuperpower((EntityPlayer) e.getEntity(), TimelordSuperpower.INSTANCE)) return;
		EntityPlayer player = (EntityPlayer) e.getEntity();
		if (player.getHealth() - e.getAmount() < 0 && SuperpowerHandler.getSpecificSuperpowerPlayerHandler(player, TimelordSuperpowerHandler.class).regenerating && player.world.isRemote && Minecraft.getMinecraft().player.getUniqueID() == player.getUniqueID()) Minecraft.getMinecraft().gameSettings.thirdPersonView = 0;
	}
	
	@SubscribeEvent
	public static void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getSide() == Side.CLIENT || !SuperpowerHandler.hasSuperpower(e.getEntityPlayer(), TimelordSuperpower.INSTANCE)) return;
		if (SuperpowerHandler.getSpecificSuperpowerPlayerHandler(e.getEntityPlayer(), TimelordSuperpowerHandler.class).regenerating) e.setCanceled(true);
	}
	
	@SubscribeEvent
	public static void onKnockback(LivingKnockBackEvent e) {
		if (!(e.getEntity() instanceof EntityPlayer)) return;
		EntityPlayer player = ((EntityPlayer) e.getEntity());
		if (!SuperpowerHandler.hasSuperpower(player, TimelordSuperpower.INSTANCE)) return;
		if (SuperpowerHandler.getSpecificSuperpowerPlayerHandler(player, TimelordSuperpowerHandler.class).regenerating) e.setCanceled(true);
	}
	
	@SubscribeEvent
	public static void onLogin(PlayerEvent.PlayerLoggedInEvent e) {
		if (!ATGConfig.startAsTimelord || !e.player.world.isRemote) return;
		
		NBTTagCompound nbt = e.player.getEntityData();
		boolean loggedInBefore = nbt.getBoolean("loggedInBefore");
		if (!loggedInBefore) {
			e.player.inventory.addItemStackToInventory(new ItemStack(ATGObjects.Items.chameleonArch));
			nbt.setBoolean("loggedInBefore", true);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void onHurt(LivingHurtEvent e) {
		if (!(e.getEntity() instanceof EntityPlayer)) return;
		
		EntityPlayer player = (EntityPlayer) e.getEntity();
		if (player.getHealth() + player.getAbsorptionAmount() - e.getAmount() > 0 || !SuperpowerHandler.hasSuperpower(player, TimelordSuperpower.INSTANCE)) return;
		
		TimelordSuperpowerHandler handler = SuperpowerHandler.getSpecificSuperpowerPlayerHandler(player, TimelordSuperpowerHandler.class);
		
		if ((handler.regenerating || player.posY < 0 || handler.regenerationsLeft == 0 || e.getSource() instanceof NoRegenDamageSource) && !ATGConfig.dontLoseUponDeath) {
			SuperpowerHandler.removeSuperpower(player);
			((CapabilitySuperpower) player.getCapability(CapabilitySuperpower.SUPERPOWER_CAP, null)).superpowerData.removeTag(TimelordSuperpower.INSTANCE.getRegistryName().toString());
		} else if (handler.regenerationsLeft > 0 || handler.regenerationsLeft == -1) { // initiate regeneration
			e.setCanceled(true);
			handler.regenerating = true;
			SuperpowerHandler.syncToAll(player);
			
			player.setHealth(.5f);
			player.setAbsorptionAmount(ATGConfig.absorbtionLevel);
			if (ATGConfig.resetOxygen) player.setAir(300);
			if (ATGConfig.resetHunger) player.getFoodStats().setFoodLevel(20);
			player.clearActivePotions();
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 10 * 20, ATGConfig.regenerationLevel, false, false)); // 10 seconds of 20 ticks of Regeneration 2
			player.extinguish();
			
			String time = "" + (handler.timesRegenerated + 1);
			int lastDigit = handler.timesRegenerated;
			if (lastDigit > 20) while (lastDigit > 10)
				lastDigit -= 10;
			
			if (lastDigit < 3)
				time = time + StringHelper.translateToLocal("lcm-atg.messages.numsuffix." + lastDigit);
			else
				time = time + StringHelper.translateToLocal("lcm-atg.messages.numsuffix.ext");
			
			if (handler.regenerationsLeft != -1) player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.regenLeftExt", time, (handler.regenerationsLeft - 1))), true);
			player.world.playSound(null, player.posX, player.posY, player.posZ, ATGObjects.SoundEvents.regeneration, SoundCategory.PLAYERS, 1.0F, 1.0F);
			ExplosionUtil.regenerationExplosion(player);
			if (e.getSource() instanceof QuickRegenDamageSource) handler.regenTicks = 201;
		}
	}
	
}
