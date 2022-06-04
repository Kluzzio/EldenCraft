package timefall.eldencraft.api.util;

import net.minecraft.entity.player.PlayerEntity;
import timefall.eldencraft.api.interfaces.ISoulsStats;

public class SoulStatsHelper {
    public static int getLevel(PlayerEntity pe) {
        return ((ISoulsStats) pe).getLevel();
    }
    public static int getVigor(PlayerEntity pe) {
        return ((ISoulsStats) pe).getVigor();
    }
    public static int getMind(PlayerEntity pe) {
        return ((ISoulsStats) pe).getMind();
    }
    public static int getEndurance(PlayerEntity pe) {
        return ((ISoulsStats) pe).getEndurance();
    }
    public static int getStrength(PlayerEntity pe) {
        return ((ISoulsStats) pe).getStrength();
    }
    public static int getDexterity(PlayerEntity pe) {
        return ((ISoulsStats) pe).getDexterity();
    }
    public static int getIntelligence(PlayerEntity pe) {
        return ((ISoulsStats) pe).getIntelligence();
    }
    public static int getFaith(PlayerEntity pe) {
        return ((ISoulsStats) pe).getFaith();
    }
    public static int getArcane(PlayerEntity pe) {
        return ((ISoulsStats) pe).getArcane();
    }
    public static int getHP(PlayerEntity pe) {
        return ((ISoulsStats) pe).getHP();
    }
    public static int getFP(PlayerEntity pe) {
        return ((ISoulsStats) pe).getFP();
    }
    public static int getStamina(PlayerEntity pe) {
        return ((ISoulsStats) pe).getStamina();
    }
    public static int getMaxHP(PlayerEntity pe) {
        return ((ISoulsStats) pe).getMaxHP();
    }
    public static int getMaxFP(PlayerEntity pe) {
        return ((ISoulsStats) pe).getMaxFP();
    }
    public static int getMaxStamina(PlayerEntity pe) {
        return ((ISoulsStats) pe).getMaxStamina();
    }
    
    public static void setLevel(PlayerEntity pe, int level) {
        ((ISoulsStats) pe).setLevel(level);
    }
    public static void setVigor(PlayerEntity pe, int vigor) {
        ((ISoulsStats) pe).setVigor(vigor);
    }
    public static void setMind(PlayerEntity pe, int mind) {
        ((ISoulsStats) pe).setMind(mind);
    }
    public static void setEndurance(PlayerEntity pe, int endurance) {
        ((ISoulsStats) pe).setEndurance(endurance);
    }
    public static void setStrength(PlayerEntity pe, int strength) {
        ((ISoulsStats) pe).setStrength(strength);
    }
    public static void setDexterity(PlayerEntity pe, int dexterity) {
        ((ISoulsStats) pe).setDexterity(dexterity);
    }
    public static void setIntelligence(PlayerEntity pe, int intelligence) {
        ((ISoulsStats) pe).setIntelligence(intelligence);
    }
    public static void setFaith(PlayerEntity pe, int faith) {
        ((ISoulsStats) pe).setFaith(faith);
    }
    public static void setArcane(PlayerEntity pe, int arcane) {
        ((ISoulsStats) pe).setArcane(arcane);
    }
    public static void setHp(PlayerEntity pe, int hp) {
        ((ISoulsStats) pe).setStamina(hp);
    }
    public static void setFp(PlayerEntity pe, int fp) {
        ((ISoulsStats) pe).setArcane(fp);
    }
    public static void setStamina(PlayerEntity pe, int stamina) {
        ((ISoulsStats) pe).setStamina(stamina);
    }
    public static void setMaxHp(PlayerEntity pe, int maxHp) {
        ((ISoulsStats) pe).setMaxHp(maxHp);
    }
    public static void setMaxFp(PlayerEntity pe, int maxFp) {
        ((ISoulsStats) pe).setStamina(maxFp);
    }
    public static void setMaxStamina(PlayerEntity pe, int maxStamina) {
        ((ISoulsStats) pe).setMaxStamina(maxStamina);
    }
}
