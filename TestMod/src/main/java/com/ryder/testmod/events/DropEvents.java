package com.ryder.testmod.events;

import com.ryder.testmod.testBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.WorldPersistenceHooks;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = testBase.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
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
            ((PlayerEntity) player).respawnPlayer();
            //((PlayerEntity) player).startFallFlying();


           if (((PlayerEntity) player).isOnLadder()){
               //((PlayerEntity) player).jump();
               player.addVelocity(0, 1, 0);
               //((PlayerEntity) player).abilities.setWalkSpeed(1000);

           }

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
