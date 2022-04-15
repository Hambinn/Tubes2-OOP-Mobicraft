package com.aetherwars.board.effect;

import com.aetherwars.board.ActiveSpell;

abstract class Effect implements ActiveSpell {
    Spell spell;
    private int timeLeft;

    public Effect(Spell spell) {
        this.spell = spell;
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
}
