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

    @Override
    public void onAttach(ActiveCharacter character) {
        super.onAttach(character);
        character.swapStatus();
    }

    @Override
    public void onWornOut(ActiveCharacter character) {
        super.onWornOut(character);
        character.swapStatus();
    }
}
