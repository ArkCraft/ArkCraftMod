package com.arkcraft.lib;

import com.arkcraft.entity.EntityGiantSpider;
import com.arkcraft.entity.EntitySpear;
import com.arkcraft.models.ModelSpear;
import com.arkcraft.render.RenderGiantSpider;
import com.arkcraft.render.RenderSpear;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	public ClientProxy() {
		// registering the PROXY to use events from MinecraftForge
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void registerRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantSpider.class, new RenderGiantSpider(new ModelBiped(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(EntitySpear.class, new RenderSpear());
	}
}