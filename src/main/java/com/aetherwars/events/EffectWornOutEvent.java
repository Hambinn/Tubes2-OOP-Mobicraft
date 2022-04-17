package com.aetherwars.events;

import com.aetherwars.board.effect.Effect;
import com.aetherwars.pubsub.Event;
import org.jetbrains.annotations.NotNull;

public class EffectWornOutEvent extends Event {
    private final @NotNull Effect effect;

    public EffectWornOutEvent(@NotNull Effect effect) {
        this.effect = effect;
    }

    public @NotNull Effect getEffect() {
        return effect;
    }
}
