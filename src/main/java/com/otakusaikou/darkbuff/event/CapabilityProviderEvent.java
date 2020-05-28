package com.otakusaikou.darkbuff.event;

import com.otakusaikou.darkbuff.capability.DarkBuffCapabilityProvider;
import com.otakusaikou.darkbuff.capability.IDarkBuffCapability;
import com.otakusaikou.darkbuff.capability.ModCapability;
import com.otakusaikou.darkbuff.util.ModConstants;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CapabilityProviderEvent {
    @SubscribeEvent
    public static void onAttachCapabilityEvent(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if (entity instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(ModConstants.MOD_ID, "tick"), new DarkBuffCapabilityProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) {
            LazyOptional<IDarkBuffCapability> oldSpeedCap = event.getOriginal().getCapability(ModCapability.DarkBufferCapability);
            LazyOptional<IDarkBuffCapability> newSpeedCap = event.getPlayer().getCapability(ModCapability.DarkBufferCapability);
            if (oldSpeedCap.isPresent() && newSpeedCap.isPresent()) {
                newSpeedCap.ifPresent((newCap) -> {
                    oldSpeedCap.ifPresent((oldCap) -> {
                        newCap.deserializeNBT(oldCap.serializeNBT());
                    });
                });
            }
        }
    }
}
