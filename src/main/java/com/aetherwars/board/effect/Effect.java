package com.aetherwars.board.effect;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.events.ClockTickEvent;
import com.aetherwars.events.EffectWornOutEvent;
import com.aetherwars.pubsub.Channel;
import com.aetherwars.pubsub.GlobalChannel;
import com.aetherwars.pubsub.Publisher;
import com.aetherwars.pubsub.Subscriber;
import com.aetherwars.spell.Spell;

public abstract class Effect implements ActiveSpell, Subscriber<ClockTickEvent>, Publisher {
    protected final Spell spell;
    protected int timeLeft;
    protected final Channel channel;

    public Effect(Spell spell) {
        this.spell = spell;
        this.channel = new Channel();
    }

    @Override
    public Spell getSpell() {
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
    public void onAttach(ActiveCharacter character) {
        GlobalChannel.getInstance().subscribe(ClockTickEvent.class, this);
    }

    @Override
    public void onWornOut(ActiveCharacter character) {
    }

    @Override
    public boolean on(ClockTickEvent event) {
        if (timeLeft == 1) {
            timeLeft = 0;
            channel.publish(new EffectWornOutEvent(this));
        } else if (timeLeft > 0) {
            --timeLeft;
        }

        return true;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }
}
