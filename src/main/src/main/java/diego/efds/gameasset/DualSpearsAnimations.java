package diego.efds.gameasset;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import yesman.epicfight.api.animation.property.AnimationProperty.AttackPhaseProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.world.damagesource.StunType;
import yesman.epicfight.api.animation.types.AttackAnimation;

import static diego.efds.gameasset.DualSpearsCollider.*;
import static yesman.epicfight.api.animation.property.AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED;
@EventBusSubscriber(
        modid = "efds",
        bus = Bus.MOD
)
public class DualSpearsAnimations {

    public static StaticAnimation SPEAR_DUAL_AUTO_1;
    public static StaticAnimation SPEAR_DUAL_AUTO_2;
    public static StaticAnimation SPEAR_DUAL_AUTO_3;
    public static StaticAnimation SPEAR_DUAL_AUTO_4;
    public static StaticAnimation SPEAR_DUAL_DASH;
    public static StaticAnimation SPEAR_DUAL_AIRSLASH;
    public static StaticAnimation SPEAR_DUAL_SLASH;
    public static StaticAnimation SPEAR_DUAL_IDLE;
    public static StaticAnimation SPEAR_DUAL_WALK;
    public static StaticAnimation SPEAR_DUAL_RUN;
    public static StaticAnimation TACHI_DUAL_AUTO_1;
    public static StaticAnimation TACHI_DUAL_AUTO_2;
    public static StaticAnimation TACHI_DUAL_DASH;
    public static StaticAnimation TACHI_DUAL_AIRSLASH;
    public static StaticAnimation TACHI_DUAL_IDLE;
    public static StaticAnimation TACHI_DUAL_WALK;
    public static StaticAnimation TACHI_DUAL_RUN;

    public DualSpearsAnimations() {
    }

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put("efds", DualSpearsAnimations::build);
    }

    private static void build() {
        HumanoidArmature biped = Armatures.BIPED;
        SPEAR_DUAL_AUTO_1 = new BasicAttackAnimation(0.1F, 0.35F, 0.5F, 0.8F, null, biped.toolR, "biped/combat/spear_dual_auto_1", biped)
                .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(BASIS_ATTACK_SPEED,1.0F);

        SPEAR_DUAL_AUTO_2 = new BasicAttackAnimation(0.1F, 0.45F, 0.7F, 0.9F, null, biped.toolL, "biped/combat/spear_dual_auto_2", biped)
                .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(BASIS_ATTACK_SPEED,1.0F);

        SPEAR_DUAL_AUTO_3 = new BasicAttackAnimation(0.05F, "biped/combat/spear_dual_auto_3", biped,
                new AttackAnimation.Phase(0.0F, 0.2F, 0.2F, 0.5F, 1.4F, 0.6F, biped.toolL, null)
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F))
                        .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                , new AttackAnimation.Phase(0.0F, 0.5F, 0.7F, 1.4F, 0.9F, biped.toolL, null))
                .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F))
                .addProperty(BASIS_ATTACK_SPEED, 1.0F)
                .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.LONG);


        SPEAR_DUAL_AUTO_4 =  new BasicAttackAnimation(0.1F, 1.2F, 1.5F, 1.7F, SLASH, biped.rootJoint, "biped/combat/spear_dual_auto_4", biped)
                .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F))
                .addProperty(BASIS_ATTACK_SPEED,1.0F)
                .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN);



        SPEAR_DUAL_SLASH =  new BasicAttackAnimation(0.1F, 1.2F, 1.5F, 1.7F, SLASH, biped.rootJoint, "biped/skill/spear_dual_slash", biped)
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F))
                        .addProperty(BASIS_ATTACK_SPEED,1.0F)
                        .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN);




        SPEAR_DUAL_AIRSLASH = new BasicAttackAnimation(0.1F, 0.2F, 0.5F, 0.5F, SLASH, biped.rootJoint, "biped/combat/spear_dual_airslash", biped)
                .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN);




        SPEAR_DUAL_DASH =  new BasicAttackAnimation(0.1F, 0.1F, 0.2F, 0.5F, null, biped.toolR, "biped/combat/spear_dual_dash", biped);



        SPEAR_DUAL_IDLE = new StaticAnimation(0.1F, true, "biped/living/spear_dual_idle", biped);
        SPEAR_DUAL_WALK = new MovementAnimation(0.1F, true, "biped/living/spear_dual_walk", biped);
        SPEAR_DUAL_RUN = new MovementAnimation(0.1F, true, "biped/living/spear_dual_run", biped);


    }
}

