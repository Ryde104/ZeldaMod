package com.ryder.testmod.events;

import com.ryder.testmod.testBase;
import net.java.games.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

@Mod.EventBusSubscriber(modid = testBase.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class DevEvent  {

    private static Field KEYBIND_ARRAY = null;

    @SubscribeEvent (priority = EventPriority.LOWEST)
    public void onClientTick(TickEvent.ClientTickEvent event) throws Exception {
        if(KEYBIND_ARRAY == null){
            KEYBIND_ARRAY = KeyBinding.class.getDeclaredField("KEYBIND_ARRAY");
            KEYBIND_ARRAY.setAccessible(true);
        }
        if(event.phase.equals(TickEvent.Phase.END)){
            Map<String, KeyBinding> binds = (Map<String, KeyBinding>) KEYBIND_ARRAY.get(null);
            for (String bind : binds.keySet()) {
                if(binds.get(bind).isKeyDown()){
                    System.out.println("IT WORKS");
                    break;
                }
            }
        }
    }
}
