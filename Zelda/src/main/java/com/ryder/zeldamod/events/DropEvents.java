package com.ryder.zeldamod.events;

import com.ryder.zeldamod.zeldaBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import sun.management.counter.perf.PerfLongArrayCounter;

@Mod.EventBusSubscriber(modid = zeldaBase.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class DropEvents {
    @SubscribeEvent
    public static void Zombie(AttackEntityEvent event){

        Entity player = event.getEntity();
        if ((player instanceof PlayerEntity)){

            LivingEntity target = (LivingEntity) event.getTarget();

            //target.setMotion(100,100,100);

            //target.setJumping(true);

            //target.noClip = true;
            target.setNoGravity(true);
            //target.setGlowing(true);
            //target.setHeadRotation(180, 180);

        }

    }

    @SubscribeEvent
    public static void test(PlayerEvent event) {
        Entity player = event.getEntity();
        if ((player instanceof PlayerEntity)) {

            //((PlayerEntity) player).jump();
            //((PlayerEntity) player).abilities.isFlying = true;

        }

    }

    @SubscribeEvent
    public static void click(PlayerEvent event){
        Entity player = event.getEntity();
        if ((player instanceof PlayerEntity)) {
            if(((PlayerEntity) player).isSneaking()){
                //((PlayerEntity) player).cameraYaw = 1;
                player.setNoGravity(false);

            }
        }
    }
}
