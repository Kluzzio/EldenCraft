package timefall.eldencraft.api.interfaces;

import net.minecraft.util.math.BlockPos;

public interface IRuneHolder {
    int getHeldRunes();
    boolean areRunesReclaimed();
    BlockPos getRunesPos();

    void setHeldRunes(int heldRunes);
    void setRunesReclaimed(boolean runesReclaimed);
    void setRunesPos(BlockPos blockPos);
    }
