package com.teamspectrial.nuclearbanana.darknature.mobs;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityDarkZombie extends EntityZombie {
	
	public EntityDarkZombie(World world) {
		super(world);
	}

	protected Item getDropItem() {
        return Items.rotten_flesh;
    }
	
	protected void addRandomArmor() {
        this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
    }
	
	protected void dropRareDrop(int p_70600_1_)
    {
        switch (this.rand.nextInt(3))
        {
            case 0:
                this.dropItem(Items.iron_sword, 1);
                break;
            case 1:
                this.dropItem(Items.blaze_rod, 2);
                break;
            case 2:
                this.dropItem(Items.gold_nugget, 3);
        }
    }
}
