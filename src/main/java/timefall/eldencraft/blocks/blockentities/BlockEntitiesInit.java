package timefall.eldencraft.blocks.blockentities;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import timefall.eldencraft.blocks.BlocksInit;

public class BlockEntitiesInit {
    public static BlockEntityType<RuneBlockEntity> RUNE_BLOCK_ENTITY;

    public static void init() {
        RUNE_BLOCK_ENTITY =
                Registry.register(
                        Registry.BLOCK_ENTITY_TYPE,
                        "eldencraft:rune_block_entity",
                        FabricBlockEntityTypeBuilder.create(RuneBlockEntity::new, BlocksInit.RUNE_BLOCK)
                                .build(null));
    }
}