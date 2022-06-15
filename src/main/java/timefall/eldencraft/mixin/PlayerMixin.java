package timefall.eldencraft.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import timefall.eldencraft.api.interfaces.IRuneHolder;
import timefall.eldencraft.api.interfaces.ISoulsStats;
import timefall.eldencraft.api.util.RuneHolderHelper;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin
        extends LivingEntity
        implements IRuneHolder, ISoulsStats {

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    // *** TRACKED DATA *** //

    private static final TrackedData<Integer> LEVEL = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> HELDRUNES = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);

    // ** Attribute Points ** //

    private static final TrackedData<Integer> VIGOR = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> MIND = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> ENDURANCE = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> STRENGTH = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> DEXTERITY = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> INTELLIGENCE = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> FAITH = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> ARCANE = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);

    // ** Base Stats ** //

    private static final TrackedData<Integer> FP = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> STAMINA = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);

    private static final TrackedData<Integer> MAX_FP = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> MAX_STAMINA = DataTracker.registerData(PlayerMixin.class, TrackedDataHandlerRegistry.INTEGER);

    // Equip Load
        // Max dependent on Stamina. Current dependent on Equipped armor

    // Poise
        // Dependent on Equipped armor
    // Discovery
        // Dependent on Arcane
    // Memory Slots
        // Dependent on Memory Stones

    // ** Resistance ** //

    //TODO Find Out what the numbers on the status page mean

    @Override
    public DataTracker getDataTracker(){ return dataTracker; }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    protected void injectInitDataTracker(CallbackInfo ci) {
        dataTracker.startTracking(LEVEL, 0);
        dataTracker.startTracking(HELDRUNES, 0);
        dataTracker.startTracking(VIGOR, 0);
        dataTracker.startTracking(MIND, 0);
        dataTracker.startTracking(ENDURANCE, 0);
        dataTracker.startTracking(STRENGTH, 0);
        dataTracker.startTracking(DEXTERITY, 0);
        dataTracker.startTracking(INTELLIGENCE, 0);
        dataTracker.startTracking(FAITH, 0);
        dataTracker.startTracking(ARCANE, 0);
        dataTracker.startTracking(FP, 0);
        dataTracker.startTracking(STAMINA, 0);
        dataTracker.startTracking(MAX_FP, 0);
        dataTracker.startTracking(MAX_STAMINA, 0);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void injectWriteCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("Level", getLevel());
        nbt.putInt("HeldRunes", getLevel());
        nbt.putInt("Vigor", getVigor());
        nbt.putInt("Mind", getMind());
        nbt.putInt("Endurance", getEndurance());
        nbt.putInt("Strength", getStrength());
        nbt.putInt("Dexterity", getDexterity());
        nbt.putInt("Intelligence", getIntelligence());
        nbt.putInt("Faith", getFaith());
        nbt.putInt("Arcane", getArcane());
        nbt.putInt("FP", getFP());
        nbt.putInt("Stamina", getStamina());
        nbt.putInt("Max_FP", getMaxFP());
        nbt.putInt("Max_Stamina", getMaxStamina());
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    public void injectReadCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        setLevel(nbt.getInt("Level"));
        setHeldRunes(nbt.getInt("HeldRunes"));
        setVigor(nbt.getInt("Vigor"));
        setMind(nbt.getInt("Mind"));
        setEndurance(nbt.getInt("Endurance"));
        setStrength(nbt.getInt("Strength"));
        setDexterity(nbt.getInt("Dexterity"));
        setIntelligence(nbt.getInt("Intelligence"));
        setFaith(nbt.getInt("Faith"));
        setArcane(nbt.getInt("Arcane"));
        setFp(nbt.getInt("FP"));
        setStamina(nbt.getInt("Stamina"));
        setMaxFp(nbt.getInt("Max_FP"));
        setMaxStamina(nbt.getInt("Max_Stamina"));
    }

    public int getLevel() { return dataTracker.get(LEVEL); }
    public int getHeldRunes() { return dataTracker.get(HELDRUNES); }
    public int getVigor() { return dataTracker.get(VIGOR); }
    public int getMind() { return dataTracker.get(MIND); }
    public int getEndurance() { return dataTracker.get(ENDURANCE); }
    public int getStrength() { return dataTracker.get(STRENGTH); }
    public int getDexterity() { return dataTracker.get(DEXTERITY); }
    public int getIntelligence() { return dataTracker.get(INTELLIGENCE); }
    public int getFaith() { return dataTracker.get(FAITH); }
    public int getArcane() { return dataTracker.get(ARCANE); }
    public int getFP() { return dataTracker.get(FP); }
    public int getStamina() { return dataTracker.get(STAMINA); }
    public int getMaxFP() { return dataTracker.get(MAX_FP); }
    public int getMaxStamina() { return dataTracker.get(MAX_STAMINA); }

    public void setLevel(int level) {
        if (level >= 0)
            dataTracker.set(LEVEL, MathHelper.clamp(level, 0, 713));
    }
    public void setHeldRunes(int heldrunes) {
        if (heldrunes >= 0)
            dataTracker.set(HELDRUNES, heldrunes);
    }
    public void setVigor(int vigor) {
        if (vigor >= 0)
            dataTracker.set(VIGOR, MathHelper.clamp(vigor, 0, 99));
    }
    public void setMind(int mind) {
        if (mind >= 0)
            dataTracker.set(MIND, MathHelper.clamp(mind, 0, 99));
    }
    public void setEndurance(int endurance) {
        if (endurance >= 0)
            dataTracker.set(ENDURANCE, MathHelper.clamp(endurance, 0, 99));
    }
    public void setStrength(int strength) {
        if (strength >= 0)
            dataTracker.set(STRENGTH, MathHelper.clamp(strength, 0, 99));
    }
    public void setDexterity(int dexterity) {
        if (dexterity >= 0)
            dataTracker.set(DEXTERITY, MathHelper.clamp(dexterity, 0, 99));
    }
    public void setIntelligence(int intelligence) {
        if (intelligence >= 0)
            dataTracker.set(INTELLIGENCE, MathHelper.clamp(intelligence, 0, 99));
    }
    public void setFaith(int faith) {
        if (faith >= 0)
            dataTracker.set(FAITH, MathHelper.clamp(faith, 0, 99));
    }
    public void setArcane(int arcane) {
        if (arcane >= 0)
            dataTracker.set(ARCANE, MathHelper.clamp(arcane, 0, 99));
    }
    public void setFp(int fp) {
        if (fp >= 0)
            dataTracker.set(FP, MathHelper.clamp(fp, 0, getMaxFP()));
    }
    public void setStamina(int stamina) {
        if (stamina >= 0)
            dataTracker.set(STAMINA, MathHelper.clamp(stamina, 0, getMaxStamina()));
    }
    public void setMaxFp(int maxFp) {
        if (maxFp >= 0)
            dataTracker.set(MAX_FP, MathHelper.clamp(maxFp, 0, 9999));
    }
    public void setMaxStamina(int maxStamina) {
        if (maxStamina >= 0)
            dataTracker.set(MAX_STAMINA, MathHelper.clamp(maxStamina, 0, 9999));
    }

    @Inject(method = "onDeath", at = @At("HEAD"))
    private void dropHeldRunes(DamageSource source, CallbackInfo ci) {
        if ((Object) this instanceof PlayerEntity playerEntity) {
            RuneHolderHelper.loseRunes(playerEntity);
        }
    }
}