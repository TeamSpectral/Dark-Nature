package com.teamspectrial.nuclearbanana.darknature.event;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.teamspectrial.nuclearbanana.darknature.DarkNatureBiomes;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EnterBiomeHandler {

	// Ne radi bas u potpunosti ali radi na neki nacin
	// Kinda works
	@SubscribeEvent
	public void enterBiome(PlayerEvent event) {
		//Item item = event.player.getHeldItem().getItem();
		World world = event.player.worldObj;
		EntityPlayer player = event.player;
		int x = (int) player.posX;
		int z = (int) player.posZ;
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
		
		if(player instanceof EntityPlayer && biome == DarkNatureBiomes.dark_plains) {
			System.out.println("works!");
			player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_PURPLE + "You entered the Dark Plains biome"));
			
		}
	}
	
}
