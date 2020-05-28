package com.otakusaikou.darkbuff.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ModCapability {
    @CapabilityInject(IDarkBuffCapability.class)
    public static Capability<IDarkBuffCapability> DarkBufferCapability;
}
