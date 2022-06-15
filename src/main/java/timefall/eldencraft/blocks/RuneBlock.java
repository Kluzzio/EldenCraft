package timefall.eldencraft.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import timefall.eldencraft.api.interfaces.IRuneHolder;
import timefall.eldencraft.api.util.RuneHolderHelper;
import timefall.eldencraft.blocks.blockentities.RuneBlockEntity;

public class RuneBlock extends BlockWithEntity implements BlockEntityProvider {


    public RuneBlock() { super(FabricBlockSettings.of(Material.AIR).dropsNothing().luminance(value -> 2).noCollision());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }

    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!world.isClient && blockEntity != null) {
            if (((RuneBlockEntity) blockEntity).verifyOwner(player)) {
                RuneHolderHelper.addRunes(player, ((RuneBlockEntity) blockEntity).getRunes());
                world.breakBlock(pos, false, player);
                ((IRuneHolder) player).setRunesPos(null);
                ((IRuneHolder) player).setRunesReclaimed(true);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.FAIL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RuneBlockEntity(pos, state);
    }
}
