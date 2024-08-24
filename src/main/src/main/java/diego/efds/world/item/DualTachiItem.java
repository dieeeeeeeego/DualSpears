package diego.efds.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import yesman.epicfight.world.item.WeaponItem;

public class DualTachiItem extends WeaponItem {
    public DualTachiItem(Item.Properties build, Tier materialIn) {
        super(materialIn, 8, -2.2F, build);
    }
}

