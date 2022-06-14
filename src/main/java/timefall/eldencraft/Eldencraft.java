package timefall.eldencraft;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import timefall.eldencraft.blocks.BlocksInit;

public class Eldencraft implements ModInitializer {

    public static final String MOD_ID = "eldencraft";
    public static Identifier ID(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {

        BlocksInit.init();
    }

}
