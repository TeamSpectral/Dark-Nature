package com.teamspectrial.nuclearbanana.darknature;

import com.teamspectrial.nuclearbanana.darknature.block.DarkBlock;
import com.teamspectrial.nuclearbanana.darknature.event.EnterBiomeHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = DarkNatureCore.MODID, version = DarkNatureCore.VERSION, name = "Dark Nature")
public class DarkNatureCore {
	
    public static final String MODID = "darknature";
    public static final String VERSION = "1.0";
    
    @Instance(MODID)
	public static DarkNatureCore instance;
	
	@SidedProxy(clientSide = "com.teamspectrial.nuclearbanana.darknature.DarkClient", serverSide = "com.teamspectrial.nuclearbanana.darknature.DarkServer")
	public static DarkServer proxy;
	
	public static CreativeTabs tabAnti = new DarkNatureCreativeTab(CreativeTabs.getNextID(), "dnature");
    
	// Dark Plains Blocks
	public static Block DarkGrass = new DarkBlock(Material.grass).setBlockName("DarkGrass").setBlockTextureName(MODID+":DarkGrassSide").setHardness(0.7F);
	public static Block DarkDirt = new DarkBlock(Material.ground).setBlockName("DarkDirt").setBlockTextureName(MODID+":DarkDirt").setHardness(0.6F);
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.renderInformation();
    	DarkNatureBiomes.init();
    	FMLCommonHandler.instance().bus().register(new EnterBiomeHandler());
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	registerBlock(DarkGrass, "Dark Grass");
    	registerBlock(DarkDirt, "Dark Dirt");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	System.out.println("Dark Nature v"+VERSION+" loaded!");
    }
    
    @EventHandler
	public void loadServer(FMLServerStartingEvent ServerEvent) {
		// ServerEvent.registerServerCommand(new CommandNew());
	}
    
    public static void registerBlock(Block block, String name) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(block, name);
	}

	public static void registerItem(Item item, String name) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(item, name);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour) {
		
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, DarkNatureCore.instance, 64, 1, true);
		createEgg(randomId, solidColour, spotColour);
	}

	private static void createEgg(int randomId, int solidColour, int spotColour) {
		
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColour, spotColour));
	}
}
