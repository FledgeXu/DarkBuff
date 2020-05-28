package com.otakusaikou.darkbuff.capability;

import net.minecraft.nbt.CompoundNBT;

public class DarkBuffCapability implements IDarkBuffCapability {
    long tick = 0;

    @Override
    public long getTick() {
        return tick;
    }

    @Override
    public long addTick() {
        return tick++;
    }

    @Override
    public void setZero() {
        tick = 0;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putLong("tick", tick);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.tick = nbt.getLong("tick");
    }
}
