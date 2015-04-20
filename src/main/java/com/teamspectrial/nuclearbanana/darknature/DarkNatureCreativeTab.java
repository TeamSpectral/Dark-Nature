package com.teamspectrial.nuclearbanana.darknature;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class DarkNatureCreativeTab extends CreativeTabs {

	public DarkNatureCreativeTab(int id, String unlocalizedName)
	  {
	    super(id, unlocalizedName);
	    this.setNoTitle();
		this.setBackgroundImageName("dnature.png");
	  }

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(Items.ender_eye);
	}

	@Override
	public Item getTabIconItem() {
		return getIconItemStack().getItem();
	}

	@SideOnly(Side.CLIENT)
    public void displayAllReleventItems(List itemList) {
		itemList.add(new ItemStack(DarkNatureCore.DarkGrass));
		itemList.add(new ItemStack(DarkNatureCore.DarkDirt));
		itemList.add(new ItemStack(DarkNatureCore.DarkLog));
		itemList.add(new ItemStack(DarkNatureCore.DarkLeaves));
		itemList.add(new ItemStack(DarkNatureCore.DarkSapling));
		itemList.add(new ItemStack(DarkNatureCore.DarkTallGrass));
	}
}
