package com.ryder.zeldamod.util;

import com.ryder.zeldamod.blocks.BlockItemBase;
import com.ryder.zeldamod.blocks.RubyBlock;
import com.ryder.zeldamod.items.ItemBase;
import com.ryder.zeldamod.tools.ZeldaItemTier;
import com.ryder.zeldamod.zeldaBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.rmi.registry.Registry;

public class RegistryHandler
{

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, zeldaBase.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, zeldaBase.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    // ITEMS
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);

    // BLOCKS
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);

    // BLOCK ITEMS
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));

    // TOOLS
    public static final  RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
    new SwordItem(ZeldaItemTier.RUBY, 67, 0.0F, new Item.Properties().group(zeldaBase.WEAPONSTAB)));

    public static final  RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () ->
            new PickaxeItem(ZeldaItemTier.RUBY, 0, -1.0F, new Item.Properties().group(zeldaBase.TOOLSTAB)));
}
