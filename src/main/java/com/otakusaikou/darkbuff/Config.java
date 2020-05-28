package com.otakusaikou.darkbuff;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.IntValue LIGHT;
    public static ForgeConfigSpec.IntValue TIME;
    public static ForgeConfigSpec.IntValue EFFECT_ID;
    public static ForgeConfigSpec.IntValue DURATION;
    public static ForgeConfigSpec.IntValue AMPLIFIER;
    public static ForgeConfigSpec.BooleanValue AMBIENT;
    public static ForgeConfigSpec.BooleanValue SHOW_PARTICLES;
    public static ForgeConfigSpec.BooleanValue SHOW_ICON;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("Effect IDs: https://minecraft.gamepedia.com/Status_effect#Effect_IDs").push("general");
        LIGHT = COMMON_BUILDER.comment("This is the light").defineInRange("light", 7, 0, 15);
        TIME = COMMON_BUILDER.comment("This is the time").defineInRange("time", 10 * 20, 0, Integer.MAX_VALUE);
        EFFECT_ID = COMMON_BUILDER.comment("This is the Effect ID").defineInRange("effect_id", 19, 1, Integer.MAX_VALUE);
        DURATION = COMMON_BUILDER.comment("This is the Effect duration, tick.").defineInRange("duration", 5 * 20, 1, Integer.MAX_VALUE);
        AMPLIFIER = COMMON_BUILDER.comment("This is the Effect amplifier.").defineInRange("amplifier", 0, 0, Integer.MAX_VALUE);
        AMBIENT = COMMON_BUILDER.comment("This is the Effect ambient.").define("ambient", false);
        SHOW_PARTICLES = COMMON_BUILDER.comment("If the Effect should show particles.").define("show_particles", true);
        SHOW_ICON = COMMON_BUILDER.comment("If the Effect should show icon.").define("show_icon", true);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
