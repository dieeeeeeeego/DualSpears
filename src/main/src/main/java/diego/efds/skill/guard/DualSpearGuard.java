package diego.efds.skill.guard;
import java.util.UUID;

import diego.efds.main.DualSpears;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import static yesman.epicfight.world.capabilities.item.WeaponCapabilityPresets.SPEAR;


@Mod.EventBusSubscriber(modid = DualSpears.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)

public class DualSpearGuard extends Skill {
    public static final UUID EVENT_UUID = UUID.fromString("b84e577a-c653-11ed-afa1-0242ac120002");
    public DualSpearGuard(Builder<? extends Skill> builder) {
        super(builder);
    }

    public static Builder createGuardBuilder() {
        return (new GuardSkill.Builder()).setCategory(SkillCategories.GUARD).setActivateType(ActivateType.ONE_SHOT).setResource(Resource.STAMINA)
                .addGuardMotion(CapabilityItem.WeaponCategories.SPEAR, (item, player) -> {
                    return Animations.SWORD_DUAL_GUARD_HIT;
                })
                .addGuardBreakMotion(CapabilityItem.WeaponCategories.SPEAR, (item, player) -> {
                    return Animations.BIPED_COMMON_NEUTRALIZED;
                });
    }
    public static void registerGuard(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(new ResourceLocation(DualSpears.MOD_ID,"spear"), SPEAR);
    }
}
