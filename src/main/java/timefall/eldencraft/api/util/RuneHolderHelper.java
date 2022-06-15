package timefall.eldencraft.api.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import timefall.eldencraft.api.interfaces.IRuneHolder;
import timefall.eldencraft.blocks.BlocksInit;
import timefall.eldencraft.blocks.blockentities.RuneBlockEntity;
import timefall.eldencraft.enums.BlocksID;

public class RuneHolderHelper {
    public static int getHeldRunes(PlayerEntity pe) {
        return ((IRuneHolder) pe).getHeldRunes();
    }

    public static void setHeldRunes(PlayerEntity pe, int heldRunes) {
        ((IRuneHolder) pe).setHeldRunes(heldRunes);
    }

    public static void addRunes(PlayerEntity pe, int runes) {
        setHeldRunes(pe, getHeldRunes(pe) + runes);
    }

    public static boolean canUseRunes(PlayerEntity pe, int runes) {
        return getHeldRunes(pe) >= runes;
    }

    public static void useRunes(PlayerEntity pe, int runes) {
        if (canUseRunes(pe, runes))
            // add negative runes = subtract (Already verified they are there)
            addRunes(pe, -runes);
    }

    public static void loseRunes(PlayerEntity pe) {
        //TODO make way to drop runes on ground
        //if (!pe.reclaimedRunes) {
            //Delete any runes on ground that were dropped by pe
        //}
        createRuneEntity(pe, getHeldRunes(pe));
        setHeldRunes(pe, 0);
        //pe.reclaimedRunes = false;
    }

    public static void gainRunes(PlayerEntity pe, int runes) {
        // Implement any modifiers to runes
        addRunes(pe, runes);
    }

    public static void createRuneEntity(PlayerEntity playerEntity, int runes) {
        BlockState blockState = playerEntity.getBlockStateAtPos();
        BlockPos blockPos = playerEntity.getBlockPos();
        if (blockState.isOf(Blocks.AIR)) {
            Block blocks = BlocksInit.ELDENCRAFT_BLOCKS.get(BlocksID.RUNE_BLOCK);

            playerEntity.world.setBlockState(blockPos, blocks.getDefaultState());
            BlockEntity blockEntity = playerEntity.world.getBlockEntity(blockPos);
            if (blockEntity != null) {
                ((RuneBlockEntity) blockEntity).setOwner(playerEntity.getGameProfile());
                ((RuneBlockEntity) blockEntity).setRunes(runes);
            }
        }
    }
}
