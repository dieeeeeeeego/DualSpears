package diego.dualspears.world.capabilites.item;

import java.util.function.Function;

import diego.dualspears.gameasset.DualSpearsAnimations;
import diego.dualspears.gameasset.DualSpearsCollider;
import diego.dualspears.gameasset.DualSpearsSkills;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.capabilities.item.CapabilityItem.Styles;
import yesman.epicfight.world.capabilities.item.CapabilityItem.WeaponCategories;

@EventBusSubscriber(
        modid = "dualspear",
        bus = Bus.MOD
)
public class WeaponCapabilityPresets {
    public static final Function<Item, CapabilityItem.Builder> SPEAR = (item) -> {
        CapabilityItem.Builder builder = WeaponCapability.builder().category(WeaponCategories.SPEAR).styleProvider((playerpatch) -> {
              return playerpatch.getHoldingItemCapability(InteractionHand.OFF_HAND)
                    .getWeaponCategory() == WeaponCategories.SPEAR && ((PlayerPatch)playerpatch)
                    .getSkill(DualSpearsSkills.DUALSPEAR) != null && ((PlayerPatch)playerpatch)
                    .getSkill(DualSpearsSkills.DUALSPEAR)
                    .getSkill().getRegistryName()
                      .getPath() == "dualspear" ? Styles.OCHS : Styles.TWO_HAND;})

        .collider(DualSpearsCollider.SPEAR)
        .swingSound((SoundEvent)EpicFightSounds.WHOOSH.get())
        .hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get())

        .newStyleCombo(Styles.TWO_HAND, new StaticAnimation[]{Animations.SPEAR_TWOHAND_AUTO1, Animations.SPEAR_TWOHAND_AUTO2})
                .innateSkill(Styles.TWO_HAND, (itemstack) -> {return EpicFightSkills.GRASPING_SPIRE;})
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.IDLE, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.WALK, Animations.BIPED_WALK_SPEAR)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_WALK_SPEAR)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_SPEAR)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.JUMP, Animations.BIPED_WALK_SPEAR)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.KNEEL, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.SNEAK, Animations.BIPED_SNEAK)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.BLOCK, Animations.SPEAR_GUARD)

        .newStyleCombo(Styles.OCHS, new StaticAnimation[]{DualSpearsAnimations.SPEAR_DUAL_AUTO_1, DualSpearsAnimations.SPEAR_DUAL_AUTO_2, DualSpearsAnimations.SPEAR_DUAL_AUTO_3,DualSpearsAnimations.SPEAR_DUAL_DASH, DualSpearsAnimations.SPEAR_DUAL_AIRSLASH})
                .innateSkill(Styles.OCHS, (itemstack) -> {return DualSpearsSkills.SLASH;})
                .livingMotionModifier(Styles.OCHS, LivingMotions.IDLE, DualSpearsAnimations.SPEAR_DUAL_IDLE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.WALK, DualSpearsAnimations.SPEAR_DUAL_WALK)
                .livingMotionModifier(Styles.OCHS, LivingMotions.CHASE, DualSpearsAnimations.SPEAR_DUAL_IDLE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.RUN, DualSpearsAnimations.SPEAR_DUAL_RUN)
                .livingMotionModifier(Styles.OCHS, LivingMotions.JUMP, DualSpearsAnimations.SPEAR_DUAL_RUN)
                .livingMotionModifier(Styles.OCHS, LivingMotions.KNEEL, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(Styles.OCHS, LivingMotions.SNEAK, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(Styles.OCHS, LivingMotions.SWIM, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(Styles.OCHS, LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD)
                .weaponCombinationPredicator((entitypatch) -> {
            return entitypatch.getHoldingItemCapability(InteractionHand.OFF_HAND)
                    .getWeaponCategory() == WeaponCategories.SPEAR && ((PlayerPatch)entitypatch)
                    .getSkill(DualSpearsSkills.DUALSPEAR) != null && ((PlayerPatch)entitypatch)
                    .getSkill(DualSpearsSkills.DUALSPEAR).getSkill().getRegistryName().getPath() == "dualspear" ? true : false;
            });
        return builder;
    };

    public WeaponCapabilityPresets() {
    }

    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(new ResourceLocation("epicfight", "spear"), SPEAR);
    }
}
