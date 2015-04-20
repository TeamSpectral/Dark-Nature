package com.teamspectrial.nuclearbanana.darknature.block;

import java.util.Random;

import com.teamspectrial.nuclearbanana.darknature.DarkNatureCore;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DarkLeaves extends BlockLeaves
{
    public static final String[][] leaf_names = new String[][] {{"DarkLeavesTrans"}, {"DarkLeaves"}};
    public static final String[] leaf_types = new String[] {"Dark"};
    protected IIcon[][] icon = new IIcon[2][];
    
    public DarkLeaves()
    { 
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setStepSound(soundTypeGrass);
        this.setTickRandomly(true);
        this.setCreativeTab(null);
    }
    
    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
     
        return 5443186;
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int i)
    {
        return 5443186;
    }
    
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        return 5443186;  //change this
    }
    
    protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_)
    {
        if ((p_150124_5_ & 3) == 0 && p_150124_1_.rand.nextInt(p_150124_6_) == 0 || p_150124_1_.rand.nextInt(p_150124_6_) == 1 || p_150124_1_.rand.nextInt(p_150124_6_) == 2)
        {
            //this.dropBlockAsItem(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(AntiCraft.Triphophyllite, 1, 0));
        }
    }

    protected int func_150123_b(int par1)
    {
        int j = super.func_150123_b(par1);

        if ((par1 & 3) == 3)
        {
            j = 40;
        }

        return j;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
    	this.setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
    	
        return (par2 & 3) == 2 ? this.icon[this.field_150127_b][1] : ((par2 & 3) == 3 ? this.icon[this.field_150127_b][3] : ((par2 & 3) == 2 ? this.icon[this.field_150127_b][2] : this.icon[this.field_150127_b][0]));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1)
    {
    	setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
    	for (int i = 0; i < leaf_names.length; ++i)
        {
            this.icon[i] = new IIcon[leaf_names[i].length];

            for (int j = 0; j < leaf_names[i].length; ++j)
            {
                this.icon[i][j] = par1.registerIcon(DarkNatureCore.MODID + ":" + leaf_names[i][j]);
            }
        }
    }

    public String[] func_150125_e()
    {
        return leaf_types;
    }
    
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
   /* @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item par1, CreativeTabs par2, List par3)
    {
        par3.add(new ItemStack(par1, 1, 0));
        par3.add(new ItemStack(par1, 1, 1));
    }*/

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(this, 1, par1 & 3);
    }
    
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
    	return false;
    }
    
    public int quantityDropped(Random p_149745_1_)
    {
        return p_149745_1_.nextInt(20) == 0 ? 1 : 0;
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(DarkNatureCore.DarkSapling);
    }

}