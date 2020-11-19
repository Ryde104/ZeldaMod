package com.ryder.testmod.init;

import com.ryder.testmod.blocks.BlockItemBase;
import com.ryder.testmod.items.ItemBase;
import com.ryder.testmod.items.Mushroom_Skewer;
import com.ryder.testmod.testBase;
import com.ryder.testmod.util.enums.RubyItemTier;
import com.ryder.testmod.util.enums.ZeldaArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, testBase.MOD_ID);

    // ITEMS
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Mushroom_Skewer> MUSHROOM_SKEWER = ITEMS.register("mushroom_skewer", Mushroom_Skewer::new);
    public static final RegistryObject<Item> GUN = ITEMS.register("gun", ItemBase::new);

    // ARMOR
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () ->
            new ArmorItem(ZeldaArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(testBase.ARMORTAB)));
    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () ->
            new ArmorItem(ZeldaArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(testBase.ARMORTAB)));
    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () ->
            new ArmorItem(ZeldaArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(testBase.ARMORTAB)));
    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () ->
            new ArmorItem(ZeldaArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(testBase.ARMORTAB)));

    // TOOLS
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
            new SwordItem(RubyItemTier.RUBY, 67, 0.0F, new Item.Properties().group(testBase.WEAPONSTAB)));

    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () ->
            new PickaxeItem(RubyItemTier.RUBY, 0, -1.0F, new Item.Properties().group(testBase.TOOLSTAB)));

    public static final RegistryObject<SwordItem> RUBY_HAMMER = ITEMS.register("ruby_hammer", () ->
            new SwordItem(RubyItemTier.RUBY, 10, -2.5F, new Item.Properties().group(testBase.WEAPONSTAB)));

    // BLOCK ITEMS
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(ModBlocks.RUBY_BLOCK.get()));
}
