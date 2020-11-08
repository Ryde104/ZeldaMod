package com.ryder.zeldamod.items;

import com.ryder.zeldamod.zeldaBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {


    public ItemBase() {
        super(new Item.Properties().group(zeldaBase.ITEMSTAB));
    }
}
