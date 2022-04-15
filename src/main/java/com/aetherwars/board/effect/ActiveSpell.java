package com.aetherwars.board.effect;

public interface ActiveSpell {
    Spell getSpell();

    int getRemainingTime();

    boolean isWornOut();

    void extendDuration(int extension);
}
