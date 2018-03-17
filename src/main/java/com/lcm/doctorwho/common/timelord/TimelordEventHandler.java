package com.lcm.doctorwho.common.timelord;

import com.lcm.doctorwho.AcrossTheGalaxy;
import com.lcm.doctorwho.common.capabilities.interfaces.ITimelordCapability;
import com.lcm.doctorwho.common.timelord.capability.CapabilityTimelord;
import com.lcm.doctorwho.common.timelord.events.RegenerationEvent;
import com.lcm.doctorwho.common.timelord.events.RegenerationFinishEvent;
import com.lcm.doctorwho.common.timelord.events.RegenerationStartEvent;
import com.lcm.doctorwho.events.ATGObjects;
import com.lcm.doctorwho.utils.ATGConfig;
import com.lcm.doctorwho.utils.ATGUtils;
import com.lcm.doctorwho.utils.DebugCommand;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.block.BlockFire;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * Created by Nictogen on 3/16/18.
 */
public class TimelordEventHandler {

	@SubscribeEvent public void onWorldTick(TickEvent.PlayerTickEvent event) {
		if (event.phase.equals(TickEvent.Phase.END) || !event.player.hasCapability(CapabilityTimelord.TIMELORD_CAP, null))
			return;
		ITimelordCapability handler = event.player.getCapability(CapabilityTimelord.TIMELORD_CAP, null);
		handler.update();
	}

	@SubscribeEvent public void onRegeneration(RegenerationEvent event) {
		event.getEntityPlayer().extinguish();
		event.getEntityPlayer().setArrowCountInEntity(0);
	}

	@SubscribeEvent public void onRegenerationExplosion(RegenerationEvent.RegenerationExplosionEvent event) {
		EntityPlayer player = event.getEntityPlayer();
		if (player.world.isRemote)
			return;

		if (player.world.getBlockState(player.getPosition()).getBlock() instanceof BlockFire)
			player.world.setBlockToAir(player.getPosition());
		double x = player.posX + player.getRNG().nextGaussian() * 2;
		double y = player.posY + 0.5 + player.getRNG().nextGaussian() * 2;
		double z = player.posZ + player.getRNG().nextGaussian() * 2;

		player.world.newExplosion(player, x, y, z, 1, ATGConfig.fieryRegen, false);
		for (BlockPos bs : BlockPos.getAllInBox(player.getPosition().north().west(), player.getPosition().south().east()))
			if (player.world.getBlockState(bs).getBlock() instanceof BlockFire)
				player.world.setBlockToAir(bs);
	}

	@SubscribeEvent public void onRegenerationFinish(RegenerationFinishEvent event) {
		EntityPlayer player = event.getEntityPlayer();
		if (player.world.isRemote)
			return;

		ITimelordCapability handler = event.getHandler();
		player.setHealth(player.getMaxHealth());
		player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, ATGConfig.postRegenerationDuration, ATGConfig.postRegenerationLevel, false, false)); // 180 seconds of 20 ticks of Regeneration 4

		handler.setRegensLeft(handler.getRegensLeft() - 1);
		handler.setTimesRegenerated(handler.getTimesRegenerated() + 1);
		//		handler.randomizeTraits(); TODO
		handler.syncToAll();
	}

	@SubscribeEvent public void onRegenerationStart(RegenerationStartEvent event) {
		EntityPlayer player = event.getEntityPlayer();
		if (player.world.isRemote)
			return;

		ITimelordCapability handler = event.getHandler();
		player.setHealth(.5f);
		player.setAbsorptionAmount(ATGConfig.absorbtionLevel);
		if (ATGConfig.resetOxygen)
			player.setAir(300);
		if (ATGConfig.resetHunger)
			player.getFoodStats().setFoodLevel(20);
		player.clearActivePotions();
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 10 * 20, ATGConfig.regenerationLevel, false, false)); // 10 seconds of 20 ticks of Regeneration 2
		player.extinguish();

		String time = "" + (handler.getTimesRegenerated() + 1);
		int lastDigit = handler.getTimesRegenerated();
		if (lastDigit > 20)
			while (lastDigit > 10)
				lastDigit -= 10;

		if (lastDigit < 3)
			time = time + StringHelper.translateToLocal("lcm-atg.messages.numsuffix." + lastDigit);
		else
			time = time + StringHelper.translateToLocal("lcm-atg.messages.numsuffix.ext");

		player.sendStatusMessage(new TextComponentString(StringHelper.translateToLocal("lcm-atg.messages.regenLeftExt", time, (handler.getRegensLeft() - 1))), true);
		player.world.playSound(null, player.posX, player.posY, player.posZ, ATGObjects.SoundEvents.regeneration, SoundCategory.PLAYERS, 1.0F, 1.0F);
		ATGUtils.regenerationExplosion(player);
	}

	@SubscribeEvent public void registerLoot(LootTableLoadEvent e) { // CHECK can this loot table actually be overriden in resource packs?
		if (!e.getName().toString().toLowerCase().matches(ATGConfig.lootRegex) || ATGConfig.disableArch)
			return;

		LootCondition[] condAlways = new LootCondition[] { new RandomChance(1F) };
		LootEntry entry = new LootEntryTable(new ResourceLocation(AcrossTheGalaxy.MODID, "inject/arch_loot"), 1, 1, condAlways, "lcm-regen:arch-entry");
		LootPool lootPool = new LootPool(new LootEntry[] { entry }, condAlways, new RandomValueRange(1), new RandomValueRange(1), "lcm-regen:arch-pool");
		e.getTable().addPool(lootPool);
	}

	@SubscribeEvent public void onLogin(PlayerEvent.PlayerLoggedInEvent e) {
		if (!ATGConfig.startAsTimelord || e.player.world.isRemote)
			return;

		NBTTagCompound nbt = e.player.getEntityData();
		boolean loggedInBefore = nbt.getBoolean("loggedInBefore");
		if (!loggedInBefore) {
			e.player.inventory.addItemStackToInventory(new ItemStack(ATGObjects.Items.chameleonArch));
			nbt.setBoolean("loggedInBefore", true);
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGH) public void onHurt(LivingHurtEvent e) {
		if (!(e.getEntity() instanceof EntityPlayer))
			return;

		EntityPlayer player = (EntityPlayer) e.getEntity();
		if (player.getHealth() + player.getAbsorptionAmount() - e.getAmount() > 0 || !e.getEntity().hasCapability(CapabilityTimelord.TIMELORD_CAP, null) || !e.getEntity().getCapability(CapabilityTimelord.TIMELORD_CAP, null).isTimelord())
			return;

		ITimelordCapability handler = e.getEntity().getCapability(CapabilityTimelord.TIMELORD_CAP, null);

		if ((handler.getState() != CapabilityTimelord.RegenerationState.NONE || player.posY < 0 || handler.getRegensLeft() <= 0 || e.getSource() instanceof DebugCommand.NoRegenDamageSource) && !ATGConfig.dontLoseUponDeath) {
			handler.setTimelord(false);
			handler.setRegensLeft(0);
			handler.setRegenTicks(0);
		} else {
			e.setCanceled(true);
			handler.setRegenTicks(1);
		}
	}

	//Capability Events

	@SubscribeEvent public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (!(event.getObject() instanceof EntityPlayer) || event.getObject().hasCapability(CapabilityTimelord.TIMELORD_CAP, null))
			return;
		event.addCapability(new ResourceLocation(AcrossTheGalaxy.MODID, "timelord"), new CapabilityTimelord.CapabilityTimelordProvider(new CapabilityTimelord((EntityPlayer) event.getObject())));

	}

	@SubscribeEvent public void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event) {
		NBTTagCompound nbt = (NBTTagCompound) CapabilityTimelord.TIMELORD_CAP.getStorage().writeNBT(CapabilityTimelord.TIMELORD_CAP, event.getOriginal().getCapability(CapabilityTimelord.TIMELORD_CAP, null), null);
		CapabilityTimelord.TIMELORD_CAP.getStorage().readNBT(CapabilityTimelord.TIMELORD_CAP, event.getEntityPlayer().getCapability(CapabilityTimelord.TIMELORD_CAP, null), null, nbt);
	}
}
