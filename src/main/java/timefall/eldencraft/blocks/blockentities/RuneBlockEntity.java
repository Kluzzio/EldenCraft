package timefall.eldencraft.blocks.blockentities;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.util.math.BlockPos;

public class RuneBlockEntity extends BlockEntity {
    public RuneBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesInit.RUNE_BLOCK_ENTITY, pos, state);
    }

    public GameProfile owner = null;

    public GameProfile assessOwner() {
        return this.owner;
    }

    @Override
    public void readNbt(NbtCompound nbtCompound) {

        owner = NbtHelper.toGameProfile(nbtCompound.getCompound("playerName"));
    }

    @Override
    public void writeNbt(NbtCompound nbtCompound) {

        nbtCompound.put("playerName", NbtHelper.writeGameProfile(new NbtCompound(), this.owner));
    }

    public boolean newphonewhodis(PlayerEntity player) {
        return player.getGameProfile().getId().equals(this.owner.getId());
    }
}
