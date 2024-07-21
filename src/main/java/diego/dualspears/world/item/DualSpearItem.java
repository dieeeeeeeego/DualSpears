package diego.dualspears.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import yesman.epicfight.world.item.WeaponItem;

public class DualSpearItem extends WeaponItem {
    public DualSpearItem(Item.Properties build, Tier materialIn) {
        super(materialIn, 8, -2.2F, build);
    }
}

