package com.teamspectrial.nuclearbanana.darknature.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.teamspectrial.nuclearbanana.darknature.DarkNatureCore;
import com.teamspectrial.nuclearbanana.darknature.gen.WorldGenDarkTree;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DarkSapling extends BlockBush implements IGrowable
{
    public static final String[] field_149882_a = new String[] {"DarkSapling"};
    private static final IIcon[] IconArray = new IIcon[field_149882_a.length];
    
    public DarkSapling()
    {
        float f = 0.4F;
        
        this.setBlockName("Dark Sapling");
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, x, y, z, rand);

            if (world.getBlockLightValue(x, y + 1, z) >= 9 && rand.nextInt(7) == 0)
            {
                this.markOrGrowMarked(world, x, y, z, rand);
            }
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
    	metadata &= 7;
        return IconArray[MathHelper.clamp_int(metadata, 0, 5)];
    }

    public void markOrGrowMarked(World world, int x, int y, int z, Random rand)
    {
        int l = world.getBlockMetadata(x, y, z);

        if ((l & 8) == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
        }
        else
        {
            this.growTree(world, x, y, z, rand);
        }
    }

    public void growTree(World world, int x, int y, int z, Random rand)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, x, y, z)) return;
        int l = world.getBlockMetadata(x, y, z) & 7;
        Object object = new WorldGenDarkTree(true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        Block block = Blocks.air;

        if (flag)
        {
            world.setBlock(x + i1, y, z + j1, block, 0, 10);
            world.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
            world.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
        }
        else
        {
            world.setBlock(x, y, z, block, 0, 4);
        }

        if (!((WorldGenerator)object).generate(world, rand, x + i1, y, z + j1))
        {
            if (flag)
            {
                world.setBlock(x + i1, y, z + j1, this, l, 4);
                world.setBlock(x + i1 + 1, y, z + j1, this, l, 4);
                world.setBlock(x + i1, y, z + j1 + 1, this, l, 4);
                world.setBlock(x + i1 + 1, y, z + j1 + 1, this, l, 4);
            }
            else
            {
                world.setBlock(x, y, z, this, l, 4);
            }
        }
    }

    public boolean isSameSapling(World p_149880_1_, int p_149880_2_, int p_149880_3_, int p_149880_4_, int p_149880_5_)
    {
        return p_149880_1_.getBlock(p_149880_2_, p_149880_3_, p_149880_4_) == this && (p_149880_1_.getBlockMetadata(p_149880_2_, p_149880_3_, p_149880_4_) & 7) == p_149880_5_;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    @Override
    public int damageDropped(int metadata)
    {
        return MathHelper.clamp_int(metadata & 7, 0, 5);
    }

    //@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        IconArray[0] = iconRegister.registerIcon(DarkNatureCore.MODID + ":" + "DarkSapling");
    }

    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean flag)
    {
        return true;
    }

    @Override
    public boolean func_149852_a(World world, Random rand, int x, int y, int z)
    {
        return (double)world.rand.nextFloat() < 0.45D;
    }

    @Override
    public void func_149853_b(World world, Random rand, int x, int y, int z)
    {
        this.markOrGrowMarked(world, x, y, z, rand);
    }
    
    @Override
    protected boolean canPlaceBlockOn(Block p_149854_1_)
    {
        return p_149854_1_ == DarkNatureCore.DarkGrass || p_149854_1_ == DarkNatureCore.DarkDirt;
    }
}