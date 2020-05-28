package com.otakusaikou.darkbuff;

import com.otakusaikou.darkbuff.util.ModConstants;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(ModConstants.MOD_ID)
public class DarkBuff {
    public DarkBuff() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
    }
}
