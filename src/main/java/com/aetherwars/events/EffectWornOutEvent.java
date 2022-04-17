package com.aetherwars.events;

import com.aetherwars.board.effect.Effect;
import com.aetherwars.pubsub.Event;

public class EffectWornOutEvent extends Event {
    private final Effect effect;

    public EffectWornOutEvent(Effect effect) {
        this.effect = effect;
    }

    public Effect getEffect() {
        return effect;
    }
}
