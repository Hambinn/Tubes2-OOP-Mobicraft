package com.aetherwars.board.effect;

import com.aetherwars.board.ActiveCharacter;

public interface Switcher<S extends Spell> extends ActiveSpell {
    void merge(Switcher<S> extension);

    void onStart(ActiveCharacter character);

    void onEnd(ActiveCharacter character);
}
