package com.quantumsheep.arkcraft.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.quantumsheep.arkcraft.entity.EntitySpear;
import com.quantumsheep.arkcraft.lib.References;
import com.quantumsheep.arkcraft.models.ModelSpear;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderSpear extends Render
{
    private static final ResourceLocation SpearTextures = new ResourceLocation(References.MODID, "textures/models/ModelSpear.png");
    private ModelSpear modelSpear = new ModelSpear();
    
    public RenderSpear()
    {
        this.shadowSize = 0.5F;
    }
    
	public void renderSpear(EntitySpear entitySpear, double x, double y, double z, float f, float prt) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z); // On décale l'entité pour qu'elle soit au bon endroit
		GL11.glTranslatef(0.0F, 1.4F, 0.0F); // Ici tu décales ton entité en fonction de ce que tu veux, pour moi mon model était trop bas, donc je l'ai monté de 1
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F); // Ensuite tu modifies la rotation (NOTE : c'est mieux de faire la rotation après, NOTE 2 : mon model ne tournait pas en fonction de la direction de l'entité, il faut que tu le rajoutes toi-même)
		this.bindEntityTexture(entitySpear); // On bind la texture
		// Si tu veux augmenter la taille de ton model avec un glScale, c'est ici qu'il faut le faire
		modelSpear.render(entitySpear, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	protected ResourceLocation getEntityTexture(EntitySpear entitySpear) {
		return SpearTextures;
	}
	
    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntitySpear)entity);
    }

    @Override
    public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSpear((EntitySpear)entity, par2, par4, par6, par8, par9);
    }
}