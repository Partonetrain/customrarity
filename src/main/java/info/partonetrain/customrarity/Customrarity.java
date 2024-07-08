package info.partonetrain.customrarity;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customrarity implements ModInitializer {

    public static final String MOD_ID = "customrarity";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static CustomrarityConfig config;

    @Override
    public void onInitialize() {
        AutoConfig.register(CustomrarityConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(CustomrarityConfig.class).getConfig();
    }
}