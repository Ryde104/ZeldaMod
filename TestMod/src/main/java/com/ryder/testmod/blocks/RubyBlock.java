package com.ryder.testmod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class RubyBlock extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE_N = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1, 9, 1, 15, 12, 15), Block.makeCuboidShape(0, 0, 0, 16, 9, 16), IBooleanFunction.OR);
    public static final VoxelShape SHAPE_E = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1, 9, 1, 15, 12, 15), Block.makeCuboidShape(0, 0, 0, 16, 9, 16), IBooleanFunction.OR);
    public static final VoxelShape SHAPE_S = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1, 9, 1, 15, 12, 15), Block.makeCuboidShape(0, 0, 0, 16, 9, 16), IBooleanFunction.OR);
    public static final VoxelShape SHAPE_W = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1, 9, 1, 15, 12, 15), Block.makeCuboidShape(0, 0, 0, 16, 9, 16), IBooleanFunction.OR);

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    public RubyBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.LADDER)
                .harvestLevel(2)
                .harvestTool(ToolType.HOE)
                .setRequiresTool());
        }

    @Nullable
    @Override
     public BlockState getStateForPlacement(BlockItemUseContext context)  {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());

    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot){
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn){
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder){
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6F;
    }
}
