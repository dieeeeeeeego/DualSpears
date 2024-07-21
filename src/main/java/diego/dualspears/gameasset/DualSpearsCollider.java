package diego.dualspears.gameasset;

import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;
import yesman.epicfight.api.collider.OBBCollider;

public class DualSpearsCollider {
    public static final Collider SPEAR = new MultiOBBCollider(3, 0.6, 0.6, 1.0, 0.0, 0.0, -1.0);

    public DualSpearsCollider() {
    }
}