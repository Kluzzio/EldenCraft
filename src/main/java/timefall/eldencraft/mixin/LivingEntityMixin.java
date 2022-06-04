package timefall.eldencraft.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import timefall.eldencraft.api.util.RuneHolderHelper;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "tryUseTotem", at = @At("HEAD"))
    private void eldencraft$dropRunes(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        if ((Object) this instanceof PlayerEntity pe) {
            RuneHolderHelper.loseRunes(pe);
            pe.sendMessage(Text.of("You Died"), true);
        }
    }
}
