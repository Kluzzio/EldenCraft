package timefall.eldencraft.api.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import timefall.eldencraft.api.interfaces.IRuneHolder;

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
        //Delete any runes on ground that were dropped by pe

        //Drop runes on ground
    }

    public static void gainRunes(PlayerEntity pe, int runes) {
        // Implement any modifiers to runes
        addRunes(pe, runes);
    }
}
