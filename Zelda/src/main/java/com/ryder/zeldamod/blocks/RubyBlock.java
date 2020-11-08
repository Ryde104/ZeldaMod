package com.ryder.zeldamod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RubyBlock extends Block {
    public RubyBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.LADDER)
                .harvestLevel(2)
                .harvestTool(ToolType.HOE)
        );
    }
}
