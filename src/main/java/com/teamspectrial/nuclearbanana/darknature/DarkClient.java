package com.teamspectrial.nuclearbanana.darknature;

import net.minecraft.client.model.ModelZombie;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class DarkClient extends DarkServer {
	
	public void renderInformation() {
	}
	
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
