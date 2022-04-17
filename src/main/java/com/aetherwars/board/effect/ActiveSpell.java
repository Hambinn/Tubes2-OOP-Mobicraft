package com.aetherwars.board.effect;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.spell.Spell;
import org.jetbrains.annotations.NotNull;

public interface ActiveSpell {
    @NotNull Spell getSpell();

    int getRemainingTime();

    boolean isWornOut();

    void extendDuration(int extension);

    void onAttach(@NotNull ActiveCharacter character);

    void onWornOut(@NotNull ActiveCharacter character);
}
