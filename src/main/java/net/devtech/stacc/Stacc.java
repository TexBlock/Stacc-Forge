package net.devtech.stacc;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Stacc.MODID)
public class Stacc {

    public static Logger LOGGER = LogManager.getLogger("Stacc Core");
    public static final String MODID = "stacc";

    public static boolean fastbenchLoaded;

    public Stacc() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onInitializeCommon);

        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));

    }

    public void onInitializeCommon(final FMLCommonSetupEvent event) {

        fastbenchLoaded = ModList.get().isLoaded("fastbench");

    }

    public static Logger logger() {
        if (LOGGER == null) {
            LOGGER = LogManager.getLogger("Stacc Core");
        }

        return LOGGER;
    }

}
