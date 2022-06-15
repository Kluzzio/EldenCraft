package timefall.eldencraft.blocks.blockentities;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;

public class RuneBlockEntity extends BlockEntity {

    public RuneBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesInit.RUNE_BLOCK_ENTITY, pos, state);
    }

    private GameProfile owner = null;
    private int runes = 0;

    public GameProfile getOwner() {
        return this.owner;
    }

    public void setOwner(GameProfile gameProfile) {
        this.owner = gameProfile;
    }

    public boolean verifyOwner(PlayerEntity player) {
        return player.getGameProfile().getId().equals(this.owner.getId());
    }

    public int getRunes() {
        return this.runes;
    }

    public void setRunes(int runes) {
        this.runes = runes;
    }

    @Override
    public void readNbt(NbtCompound nbtCompound) {
        super.readNbt(nbtCompound);
        owner = NbtHelper.toGameProfile(nbtCompound.getCompound("playerName"));
        runes = nbtCompound.getInt("runes");
    }

    @Override
    public void writeNbt(NbtCompound nbtCompound) {
        nbtCompound.put("playerName", NbtHelper.writeGameProfile(new NbtCompound(), this.owner));
        nbtCompound.putInt("runes", this.runes);
        super.writeNbt(nbtCompound);
    }


    // Sync data from server to client
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
