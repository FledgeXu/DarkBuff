package com.otakusaikou.darkbuff.event;

import com.otakusaikou.darkbuff.Config;
import com.otakusaikou.darkbuff.capability.IDarkBuffCapability;
import com.otakusaikou.darkbuff.capability.ModCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerEvents {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        World world = player.getEntityWorld();

        if (world.isRemote) {
            return;
        }
        LazyOptional<IDarkBuffCapability> tickCapability = player.getCapability(ModCapability.DarkBufferCapability);
        int light = world.getLight(player.getPosition());
        if (light > Config.LIGHT.get()) {
            tickCapability.ifPresent(IDarkBuffCapability::setZero);
        } else {
            tickCapability.ifPresent(IDarkBuffCapability::addTick);
        }
        Effect effect = Registry.EFFECTS.getByValue(Config.EFFECT_ID.get());
        if (effect == null) {
            throw new RuntimeException("Maybe You input the wrong effect id");
        }
        tickCapability.ifPresent(t -> {
            if (t.getTick() > Config.TIME.get()) {
                if (player.getActivePotionEffect(effect) == null) {
                    player.addPotionEffect(new EffectInstance(effect, Config.DURATION.get(), Config.AMPLIFIER.get(), Config.AMBIENT.get(), Config.SHOW_PARTICLES.get(), Config.SHOW_ICON.get()));
                }
            }
        });
    }
}
