package com.teamspectrial.nuclearbanana.darknature.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DarkTallGrass extends Block {

	public DarkTallGrass(Material m) {
		super(m);
		float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
        return 1; // 6 je kvadrat, 1 je +
    }
	
	public boolean isOpaqueCube() {
		return true;
	}
	
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    //walk through
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
        return null;
    }
}
