package diego.efds.world.loot;

import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(
        modid = "dualspears"
)
public class EFModLootTables {
    public EFModLootTables() {
    }

    @SubscribeEvent
    public static void modifyVanillaLootPools(LootTableLoadEvent event) {
    }
}
