package com.aetherwars.board.effect;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.events.ClockTickEvent;
import com.aetherwars.events.EffectWornOutEvent;
import com.aetherwars.pubsub.Channel;
import com.aetherwars.pubsub.GlobalChannel;
import com.aetherwars.pubsub.Publisher;
import com.aetherwars.pubsub.Subscriber;
import com.aetherwars.spell.Spell;
import org.jetbrains.annotations.NotNull;

public abstract class Effect implements ActiveSpell, Subscriber<ClockTickEvent>, Publisher {
    protected final @NotNull Spell spell;
    protected final @NotNull Channel channel;
    protected int timeLeft;

    public Effect(@NotNull Spell spell) {
        this.spell = spell;
        this.channel = new Channel();
    }

    @Override
    public @NotNull Spell getSpell() {
        return spell;
    }

    @Override
    public int getRemainingTime() {
        return timeLeft;
    }

    @Override
    public void extendDuration(int extension) {
        timeLeft += extension;
    }

    @Override
    public boolean isWornOut() {
        return timeLeft == 0;
    }

    @Override
    public void onAttach(@NotNull ActiveCharacter character) {
        GlobalChannel.getInstance().subscribe(ClockTickEvent.class, this);
    }

    @Override
    public void onWornOut(@NotNull ActiveCharacter character) {
    }

    @Override
    public boolean on(@NotNull ClockTickEvent event) {
        if (timeLeft == 1) {
            timeLeft = 0;
            channel.publish(new EffectWornOutEvent(this));
        } else if (timeLeft > 0) {
            --timeLeft;
        }

        return true;
    }

    @Override
    public @NotNull Channel getChannel() {
        return channel;
    }
}
