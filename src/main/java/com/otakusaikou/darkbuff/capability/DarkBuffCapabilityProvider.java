package com.otakusaikou.darkbuff.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DarkBuffCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    IDarkBuffCapability darkBuffCapability = null;

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == ModCapability.DarkBufferCapability ? LazyOptional.of(this::getOrCreateCapability).cast() : LazyOptional.empty();
    }

    @Nonnull
    IDarkBuffCapability getOrCreateCapability() {
        if (darkBuffCapability == null) {
            this.darkBuffCapability = new DarkBuffCapability();
        }
        return this.darkBuffCapability;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return this.getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.getOrCreateCapability().deserializeNBT(nbt);
    }
}
