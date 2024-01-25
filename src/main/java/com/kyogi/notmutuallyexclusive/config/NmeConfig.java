package com.kyogi.notmutuallyexclusive.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class NmeConfig {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static Pair<Common, ForgeConfigSpec> getConfigSpec() {
        return BUILDER.configure(NmeConfig.Common::new);
    }

    public static class Common {

        Common(ForgeConfigSpec.Builder builder) {
            ForgeConfigSpec.IntValue configVersion = builder.comment("The version of this config.").defineInRange("ConfigVersion", 3, 1, 3);
            ForgeConfigSpec.ConfigValue<String> dimensionKey = builder.comment("Custom dimensionKey").define("dimensionKey", "minecraft:overworld");

        }
    }
}
