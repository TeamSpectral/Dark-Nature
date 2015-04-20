package com.teamspectrial.nuclearbanana.darknature;

import net.minecraft.client.model.ModelZombie;

import com.teamspectrial.nuclearbanana.darknature.mobs.EntityDarkZombie;
import com.teamspectrial.nuclearbanana.darknature.mobs.RenderDarkZombie;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class DarkClient extends DarkServer {
	
	public void renderInformation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkZombie.class, new RenderDarkZombie(new ModelZombie(), 0));
	}
	
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
