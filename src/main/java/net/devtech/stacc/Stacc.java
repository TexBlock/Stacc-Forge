package net.devtech.stacc;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Stacc.MODID)
public class Stacc {

    public static Logger LOGGER = LogManager.getLogger("Stacc Core");
    public static final String MODID = "stacc";

    public static boolean fastbenchLoaded;
    public static boolean optiforgeLoaded;
    public static boolean optifineLoaded;

    public Stacc() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onInitializeCommon);

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));

    }

    public void onInitializeCommon(final FMLCommonSetupEvent event) {

        fastbenchLoaded = ModList.get().isLoaded("fastbench");
        optiforgeLoaded = ModList.get().isLoaded("optiforge");
        optifineLoaded = ModList.get().isLoaded("optifine");
    }

    public static Logger logger() {
        if (LOGGER == null) {
            LOGGER = LogManager.getLogger("Stacc Core");
        }

        return LOGGER;
    }

}
