package com.teamspectrial.nuclearbanana.darknature.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.teamspectrial.nuclearbanana.darknature.DarkNatureCore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DarkBlock extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;
	
	public DarkBlock(Material m) {
		super(m);
	}

	@Override
	public Item getItemDropped(int i, Random r, int j) {
		if(this == DarkNatureCore.DarkGrass)
			return Item.getItemFromBlock(DarkNatureCore.DarkDirt);
		if (this == DarkNatureCore.DarkDirt)
			return Item.getItemFromBlock(DarkNatureCore.DarkDirt);
		else return Item.getItemFromBlock(this);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister) {
		if(this == DarkNatureCore.DarkGrass) {
			this.blockIcon = iconregister.registerIcon(DarkNatureCore.MODID + ":DarkGrassSide");
			this.top = iconregister.registerIcon(DarkNatureCore.MODID + ":DarkGrassTop");
			this.bottom = iconregister.registerIcon(DarkNatureCore.MODID + ":DarkDirt");
		}
		if(this == DarkNatureCore.DarkDirt) {
			this.blockIcon = iconregister.registerIcon(DarkNatureCore.MODID + ":DarkDirt");
			this.top = iconregister.registerIcon(DarkNatureCore.MODID + ":DarkDirt");
			this.bottom = iconregister.registerIcon(DarkNatureCore.MODID + ":DarkDirt");
		}
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
	if (side == 1)
		return top;
	else if (side == 0)
		return bottom;
	else if (side != meta)
		return blockIcon;
	else
		return blockIcon;
	}

}
