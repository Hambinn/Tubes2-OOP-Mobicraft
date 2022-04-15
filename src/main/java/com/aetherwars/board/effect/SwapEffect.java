package com.aetherwars.board.effect;

import com.aetherwars.board.ActiveCharacter;

public class SwapEffect extends Effect implements Switcher<SwapSpell> {
    public SwapEffect(SwapSpell spell) {
        super(spell);
    }

    public void merge(SwapEffect extension) {
        extendDuration(extension.getRemainingTime());
    }

    @Override
    public void onStart(ActiveCharacter character) {
        character.swapStatus();
    }

    @Override
    public void onEnd(ActiveCharacter character) {
        character.swapStatus();
    }
}
