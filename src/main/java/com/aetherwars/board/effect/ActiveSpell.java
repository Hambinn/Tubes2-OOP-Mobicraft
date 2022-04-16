package com.aetherwars.board.effect;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.spell.Spell;

public interface ActiveSpell {
    Spell getSpell();

    int getRemainingTime();

    boolean isWornOut();

    void extendDuration(int extension);
}
