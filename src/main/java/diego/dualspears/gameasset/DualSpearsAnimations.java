package diego.dualspears.gameasset;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import yesman.epicfight.api.animation.property.AnimationProperty.AttackPhaseProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.MovementAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.world.damagesource.StunType;

import static yesman.epicfight.api.animation.property.AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED;

@EventBusSubscriber(
        modid = "dualspear",
        bus = Bus.MOD
)
public class DualSpearsAnimations {

    public static StaticAnimation SPEAR_DUAL_AUTO_1;
    public static StaticAnimation SPEAR_DUAL_AUTO_2;
    public static StaticAnimation SPEAR_DUAL_AUTO_3;
    public static StaticAnimation SPEAR_DUAL_DASH;
    public static StaticAnimation SPEAR_DUAL_AIRSLASH;
    public static StaticAnimation SPEAR_DUAL_SLASH;
    public static StaticAnimation SPEAR_DUAL_IDLE;
    public static StaticAnimation SPEAR_DUAL_WALK;
    public static StaticAnimation SPEAR_DUAL_RUN;

    public DualSpearsAnimations() {
    }

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put("dualspear", DualSpearsAnimations::build);
    }

    private static void build() {
        HumanoidArmature biped = Armatures.BIPED;
        SPEAR_DUAL_AUTO_1 = new BasicAttackAnimation(0.1F, 0.2F, 0.4F, 0.8F, null, biped.toolR, "biped/combat/spear_dual_auto_1", biped).addProperty(AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.LONG);

        SPEAR_DUAL_AUTO_2 = new BasicAttackAnimation(0.05F, "biped/combat/spear_dual_auto_2", biped,
                new AttackAnimation.Phase(0.0F, 0.3F, 0.2F, 0.3F, 0.8F, 0.4F, biped.toolL, null)
                , new AttackAnimation.Phase(0.1F, 0.6F, 0.7F, 0.7F, 0.9F, biped.toolR, null))
                .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F))
                .addProperty(BASIS_ATTACK_SPEED, 1.6F).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.LONG);
        SPEAR_DUAL_AUTO_3 = new BasicAttackAnimation(0.1F, 0.7F, 0.8F, 1.3F, null, biped.toolR, "biped/combat/spear_dual_auto_3", biped).addProperty(AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.9F))
                .addProperty(BASIS_ATTACK_SPEED, 1.0F).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.LONG);

        SPEAR_DUAL_SLASH = new BasicAttackAnimation(0.1F, 0.8F, 1.0F, 1.4F, null, biped.toolR, "biped/skill/spear_dual_slash", biped).addProperty(AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addProperty(BASIS_ATTACK_SPEED, 1.3F);

        SPEAR_DUAL_AIRSLASH = new BasicAttackAnimation(0.1F, 0.2F, 0.5F, 0.5F, null, biped.toolR, "biped/combat/spear_dual_airslash", biped).addProperty(AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get());

        SPEAR_DUAL_DASH = new BasicAttackAnimation(0.1F, 0.2F, 0.5F, 0.5F, null, biped.toolR, "biped/combat/spear_dual_dash", biped).addProperty(AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get());

        SPEAR_DUAL_IDLE = new StaticAnimation(0.1F, true, "biped/living/spear_dual_idle", biped);
        SPEAR_DUAL_WALK = new MovementAnimation(0.1F, true, "biped/living/spear_dual_walk", biped);
        SPEAR_DUAL_RUN = new MovementAnimation(0.1F, true, "biped/living/spear_dual_run", biped);
    }
}
