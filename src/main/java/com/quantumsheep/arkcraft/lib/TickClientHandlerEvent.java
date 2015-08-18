package com.quantumsheep.arkcraft.lib;

import org.lwjgl.opengl.GL11;

import com.quantumsheep.arkcraft.ArkCraftMod;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class TickClientHandlerEvent {
	public static final ResourceLocation zoomOverlay = new ResourceLocation(References.MODID + ":textures/overlay/sniperScope.png");

	public static void renderTextureOverlay(ResourceLocation s, float f)
	   {
	    Minecraft minecraft = FMLClientHandler.instance().getClient();
	       ScaledResolution scaledresolution = new ScaledResolution(minecraft, minecraft.displayWidth, minecraft.displayHeight);
	       int i = scaledresolution.getScaledWidth();
	       int j = scaledresolution.getScaledHeight();
	       GL11.glEnable(GL11.GL_BLEND);
	       GL11.glDisable(GL11.GL_DEPTH_TEST);
	       GL11.glDepthMask(false);
	       GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	       GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
	       GL11.glDisable(GL11.GL_ALPHA_TEST);
	       minecraft.getTextureManager().bindTexture(s);
	       Tessellator tessellator = Tessellator.instance;
	       tessellator.startDrawingQuads();
	       tessellator.addVertexWithUV(0.0D, j, -90D, 0.0D, 1.0D);
	       tessellator.addVertexWithUV(i, j, -90D, 1.0D, 1.0D);
	       tessellator.addVertexWithUV(i, 0.0D, -90D, 1.0D, 0.0D);
	       tessellator.addVertexWithUV(0.0D, 0.0D, -90D, 0.0D, 0.0D);
	       tessellator.draw();
	       GL11.glDepthMask(true);
	       GL11.glEnable(GL11.GL_DEPTH_TEST);
	       GL11.glEnable(GL11.GL_ALPHA_TEST);
	       GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
	   }
	
	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
	 if(ArkCraftMod.zoomSniper)
	 {
	 if(Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)
	  {
	 zoom(20.0D); //c'est déjà pas mal, mais libre à vous de jongler sur la valeur
	 if(ArkCraftMod.zoomSniper && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && Minecraft.getMinecraft().currentScreen == null)
	 {
	  renderTextureOverlay(zoomOverlay, 1.0F);
	 }
	  }
	 }
	 else
	 {
	 zoom(1.0D); //par défaut, le zoom de la caméra est à 1.0D
	 }
	}

	public static void zoom(double zoomValue)
	{
	ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, Minecraft.getMinecraft().entityRenderer, zoomValue, "cameraZoom", "field_78503_V");
	}
}
	 