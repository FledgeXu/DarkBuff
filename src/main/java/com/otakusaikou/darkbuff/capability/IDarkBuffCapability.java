package com.otakusaikou.darkbuff.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IDarkBuffCapability extends INBTSerializable<CompoundNBT> {
    long getTick();

    long addTick();

    void setZero();

}
