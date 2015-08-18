package com.quantumsheep.arkcraft.items;

import com.quantumsheep.arkcraft.ArkCraftMod;
import com.quantumsheep.arkcraft.lib.References;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemLongneckRifle extends Item
{
	public ItemLongneckRifle()
	{
		super();
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if(worldIn.isRemote)
		{
			ArkCraftMod.zoomSniper = !ArkCraftMod.zoomSniper;
		}
	    return itemStackIn;
	}
	   
	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon(References.MODID + ":ItemLongneckRifle");
	}

	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		return this.itemIcon;
	}
	
	
}