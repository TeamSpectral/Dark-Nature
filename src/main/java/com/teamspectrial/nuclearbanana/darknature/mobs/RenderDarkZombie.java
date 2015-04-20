package com.teamspectrial.nuclearbanana.darknature.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.teamspectrial.nuclearbanana.darknature.DarkNatureCore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDarkZombie extends RenderZombie
{
    private static final ResourceLocation mobTextures = new ResourceLocation(DarkNatureCore.MODID + ":" + "textures/entity/DarkZombie.png");

    public RenderDarkZombie(ModelBase par1ModelBase, float par2)
    {
        super();
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityDarkZombie par1EntityTutMob)
    {
        return mobTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityDarkZombie)par1Entity);
    }
}