package timefall.eldencraft.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {

    @Shadow @Final public PlayerEntity player;

    @Inject(method = "getMainHandStack", at = @At("RETURN"), cancellable = true)
    public void getMainHandStack(CallbackInfoReturnable<ItemStack> cir) {
        if (cir.getReturnValue() != ItemStack.EMPTY) {
            cir.setReturnValue(this.player.getMainHandStack());
        }
    }

}
