package pepjebs.netherite_nugget.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class NetheriteNuggetConfig {

    public static ForgeConfigSpec spec;

    public static ForgeConfigSpec.DoubleValue piglinBruteNetheriteNuggetDropChance;

    static {
        ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder().push("general");
        piglinBruteNetheriteNuggetDropChance = BUILDER
                .comment("The [0-1] (0%-100%) chance of a Piglin Brute dropping a Netherite Nugget on death.")
                .defineInRange("piglinBruteNetheriteNuggetDropChance", 0.5F, 0F, 1F);
        BUILDER.pop();
        spec = BUILDER.build();
    }
}
