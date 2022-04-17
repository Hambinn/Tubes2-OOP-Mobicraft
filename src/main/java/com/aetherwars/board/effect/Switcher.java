package com.aetherwars.board.effect;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.spell.SwapSpell;
import org.jetbrains.annotations.NotNull;

public class Switcher extends Effect {
    public Switcher(@NotNull SwapSpell spell) {
        super(spell);
    }

    public void merge(@NotNull Switcher extension) {
        extendDuration(extension.getRemainingTime());
    }

    @Override
    public void onAttach(@NotNull ActiveCharacter character) {
        super.onAttach(character);
        character.swapStatus();
    }

    @Override
    public void onWornOut(@NotNull ActiveCharacter character) {
        super.onWornOut(character);
        character.swapStatus();
    }
}
