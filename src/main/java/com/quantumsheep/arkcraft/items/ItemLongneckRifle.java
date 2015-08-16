package com.quantumsheep.arkcraft.items;

import com.quantumsheep.arkcraft.lib.References;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemLongneckRifle extends Item
{
	public ItemLongneckRifle()
	{
		super();
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