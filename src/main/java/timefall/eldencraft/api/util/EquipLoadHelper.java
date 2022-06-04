package timefall.eldencraft.api.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EquipLoadHelper {
    private static float getWeight(PlayerEntity pe) {
        float totalPlayerWeight = 0;
        for (ItemStack itemStack : pe.getItemsEquipped()) {
            Item item = itemStack.getItem();
            //TODO replace false with a check to see if an item has a defined weight value
            float weight = false ? 0 : (item.isDamageable() ? item.getMaxDamage() / 100f : 2.6f);
            totalPlayerWeight += weight;
        }
        return totalPlayerWeight;
    }

    public static int getEquipLoadThreshold(PlayerEntity pe) {
        float ratio = getWeight(pe) / getMaxEquipLoad(pe);

        return ratio < 0.30f ? 1
                : (ratio < 0.70f ? 2
                : (ratio < 1.0f ? 3
                : 4));
    }

    public static float getMaxEquipLoad(PlayerEntity pe) {
        SoulStatsHelper.getEndurance(pe);
        return 0;
    }

}
