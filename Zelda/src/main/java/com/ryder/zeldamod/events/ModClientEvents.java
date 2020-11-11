package com.ryder.zeldamod.events;

import com.ryder.zeldamod.util.RegistryHandler;
import com.ryder.zeldamod.zeldaBase;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.command.impl.TeleportCommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

@Mod.EventBusSubscriber(modid = zeldaBase.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void knockout(LivingEvent.LivingJumpEvent event) {
        LivingEntity player = event.getEntityLiving();
        if (player.getHeldItemMainhand().getItem() == RegistryHandler.RUBY_HAMMER.get()) {
            World world = player.getEntityWorld();
            world.setBlockState(player.getPosition().add(0, -1, 0), Blocks.COBBLESTONE.getDefaultState());
        }
    }

    @SubscribeEvent
    public static void onDamage(AttackEntityEvent event) {
        if (event.getEntityLiving().getHeldItemMainhand().getItem() == RegistryHandler.RUBY_HAMMER.get()) {
            if (event.getTarget().isAlive()) {

                LivingEntity target = (LivingEntity) event.getTarget();
                 {

                    PlayerEntity player = event.getPlayer();
                    target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 60, 100));
                    target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 60, 100));
                    player.addVelocity(0, 4, 0);
                    //player.jump();
                    //player.abilities.disableDamage = true;
                    //player.abilities.isFlying = true;
                    //player.drop(true);
                     player.experienceLevel = 999999999;
                     //   player.setFire(100000);
                     player.cameraYaw = player.attackedAtYaw;
                     player.attemptTeleport(1, 10, 1, true);




                    // Client Only
                    if (!event.getPlayer().getEntityWorld().isRemote) {
                        String msg = TextFormatting.RED + "That Sheep isn't feeling so good...";
                       // player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public static void Zombie(AttackEntityEvent event){

        Entity player = event.getEntity();
        if ((player instanceof PlayerEntity)){

            //LivingEntity target = (LivingEntity) event.getTarget();

            //target.setMotion(100,100,100);

            //target.setJumping(true);

            //target.noClip = true;


        }


    }

}