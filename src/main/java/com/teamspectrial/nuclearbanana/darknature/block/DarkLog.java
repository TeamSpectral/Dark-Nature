package com.teamspectrial.nuclearbanana.darknature.block;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.teamspectrial.nuclearbanana.darknature.DarkNatureCore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DarkLog extends BlockLog
{
    public static final String[] field_150168_M = new String[] {"DarkLog"};
    private static final String __OBFID = "CL_00000281";

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    /*@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 3));
    }*/

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_150167_a = new IIcon[field_150168_M.length];
        this.field_150166_b = new IIcon[field_150168_M.length];

        for (int i = 0; i < this.field_150167_a.length; ++i)
        {
            this.field_150167_a[i] = p_149651_1_.registerIcon(DarkNatureCore.MODID + ":" + "DarkLog"); // + field_150168_M[i]
            this.field_150166_b[i] = p_149651_1_.registerIcon(DarkNatureCore.MODID + ":" + "DarkLogTop");
        }
    }
    
   /* public static void spawnZucrallas(World world, int i, int j, int k, Random random, int chance)
    {
      if (((world.func_72798_a(i, j + 1, k) == PieCraft.ZucrallaLeaves.) && (world.func_72805_g(i, j + 1, k) == 0)) || ((world.func_72798_a(i, j + 2, k) == TropicraftBlocks.tropicsLeaves.field_71990_ca) && (world.func_72805_g(i, j + 2, k) == 0)))
      {
        if ((world.func_72799_c(i + 1, j, k)) && (random.nextInt(chance) == 0)) {
          world.func_94575_c(i + 1, j, k, TropicraftBlocks.coconut.field_71990_ca);
          world.func_72921_c(i, j, k, 0, 2);
        }

        if ((world.func_72799_c(i - 1, j, k)) && (random.nextInt(chance) == 0)) {
          world.func_94575_c(i - 1, j, k, TropicraftBlocks.coconut.field_71990_ca);
          world.func_72921_c(i, j, k, 0, 2);
        }

        if ((world.func_72799_c(i, j, k - 1)) && (random.nextInt(chance) == 0)) {
          world.func_94575_c(i, j, k - 1, TropicraftBlocks.coconut.field_71990_ca);
          world.func_72921_c(i, j, k, 0, 2);
        }

        if ((world.func_72799_c(i, j, k + 1)) && (random.nextInt(chance) == 0)) {
          world.func_94575_c(i, j, k + 1, TropicraftBlocks.coconut.field_71990_ca);
          world.func_72921_c(i, j, k, 0, 2);
        }

        if ((world.func_72799_c(i, j - 1, k)) && (random.nextInt(chance) == 0)) {
          world.func_94575_c(i, j - 1, k, TropicraftBlocks.coconut.field_71990_ca);
          world.func_72921_c(i, j, k, 0, 2);
        }
      }
    }*/
    
    
}