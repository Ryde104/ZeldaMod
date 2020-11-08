package com.ryder.zeldamod;


import com.ryder.zeldamod.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("zelda")
public class zeldaBase
{

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "zelda";

    public zeldaBase()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        RegistryHandler.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {

    }
// Tab
    public static final ItemGroup ITEMSTAB = new ItemGroup("itemsTab")
    {
        @Override
        public ItemStack createIcon ()
        {
            return new ItemStack(RegistryHandler.RUBY.get());
        }
    };

    public static final ItemGroup BLOCKSTAB = new ItemGroup("blocksTab")
    {
        @Override
        public ItemStack createIcon ()
        {
            return new ItemStack(RegistryHandler.RUBY_BLOCK.get());
        }
    };

    public static final ItemGroup WEAPONSTAB = new ItemGroup("weaponsTab")
    {
        @Override
        public ItemStack createIcon ()
        {
            return new ItemStack(RegistryHandler.RUBY_SWORD.get());
        }
    };

    public static final ItemGroup TOOLSTAB = new ItemGroup("toolsTab")
    {
        @Override
        public ItemStack createIcon ()
        {
            return new ItemStack(RegistryHandler.RUBY_PICKAXE.get());
        }
    };

    public static final ItemGroup ARMORTAB = new ItemGroup("armorTab")
    {
        @Override
        public ItemStack createIcon ()
        {
            return new ItemStack(RegistryHandler.RUBY_CHESTPLATE.get());
        }
    };

    public static final ItemGroup FOODTAB = new ItemGroup("foodTab")
    {
        @Override
        public ItemStack createIcon ()
        {
            return new ItemStack(RegistryHandler.MUSHROOM_SKEWER.get());
        }
    };
}
