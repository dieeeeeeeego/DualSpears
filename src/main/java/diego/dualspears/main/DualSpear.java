package diego.dualspears.main;

import diego.dualspears.gameasset.DualSpearsAnimations;
import diego.dualspears.gameasset.DualSpearsSkills;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("dualspear")
public class DualSpear {
    public static final String MODID = "dualspear";
    public static final String CONFIG_FILE_PATH = "dualspear.toml";
    public static final Logger LOGGER = LogManager.getLogger("dualspear");

    public DualSpear() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(DualSpearsAnimations::registerAnimations);
        DualSpearsSkills.registerSkills();
        MinecraftForge.EVENT_BUS.register(this);
    }
}