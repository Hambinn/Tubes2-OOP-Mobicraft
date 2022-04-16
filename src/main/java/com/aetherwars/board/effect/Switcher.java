package com.aetherwars.board.effect;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.spell.SwapSpell;

public class Switcher extends Effect {
    public Switcher(SwapSpell spell) {
        super(spell);
    }

    public void merge(Switcher extension) {
        extendDuration(extension.getRemainingTime());
    }

    public void onAttach(ActiveCharacter character) {
        spell.apply(character);
    }

    public void onWornOut(ActiveCharacter character) {
        spell.apply(character);
    }
}
