package com.ryder.testmod.items;

import com.ryder.testmod.testBase;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Mushroom_Skewer extends Item {

    public Mushroom_Skewer() {
        super(new Item.Properties()
                .group(testBase.FOODTAB)
                .food(new Food.Builder()
                .hunger(4)
                .saturation(2)
                .effect(() -> new EffectInstance(Effects.JUMP_BOOST, 100, 2), 0.5F)
                .effect(() -> new EffectInstance(Effects.JUMP_BOOST, 100, 2), 0.2F)
                .fastToEat()
                .build())
        );

    }
}
