package com.otakusaikou.darkbuff.event;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.IDREFDatatypeValidator;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapabilityRegistry {
    @SubscribeEvent
    public static void CapabilityRegistry(FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(
                IDREFDatatypeValidator.class,
                new Capability.IStorage<IDREFDatatypeValidator>() {
                    @Nullable
                    @Override
                    public INBT writeNBT(Capability<IDREFDatatypeValidator> capability, IDREFDatatypeValidator instance, Direction side) {
                        return null;
                    }

                    @Override
                    public void readNBT(Capability<IDREFDatatypeValidator> capability, IDREFDatatypeValidator instance, Direction side, INBT nbt) {

                    }
                },
                () -> null
        );
    }
}
