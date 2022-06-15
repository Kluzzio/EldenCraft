package timefall.eldencraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;
import timefall.eldencraft.enums.BlocksID;

import java.util.EnumMap;
import java.util.Locale;

import static timefall.eldencraft.Eldencraft.ID;

public class BlocksInit {

    //Blocks
    public static final RuneBlock RUNE_BLOCK = new RuneBlock();

    //Enum
    public static final EnumMap<BlocksID, Block> ELDENCRAFT_BLOCKS = new EnumMap<>(BlocksID.class);

    public static void init() {

        ELDENCRAFT_BLOCKS.put(BlocksID.RUNE_BLOCK, RUNE_BLOCK);
        registerBlockWithItem(BlocksID.RUNE_BLOCK.toString().toLowerCase(Locale.ROOT), RUNE_BLOCK);
    }
    protected static void registerBlockWithItem(String id, Block block) {
        Registry.register(Registry.BLOCK, ID(id), block);
    }
}
