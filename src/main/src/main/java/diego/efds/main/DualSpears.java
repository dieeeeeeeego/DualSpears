package diego.efds.main;

import diego.efds.gameasset.DualSpearsAnimations;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Mod(DualSpears.MOD_ID)
public class DualSpears {
    public static final String MOD_ID = "efds";
    public static final String CONFIG_FILE_PATH = "dualspears.toml";
    public static final Logger LOGGER = LogManager.getLogger("dualspear");

    public DualSpears() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(DualSpearsAnimations::registerAnimations);;
        MinecraftForge.EVENT_BUS.register(this);
    }
}