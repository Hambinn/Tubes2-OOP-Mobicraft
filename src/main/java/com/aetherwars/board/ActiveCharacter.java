package com.aetherwars.board;

import com.aetherwars.model.Character;

public interface ActiveCharacter {
    Character getCharacter();

    void addExp(int addition);

    void levelUp() throws Exception;

    void swapStatus();

    Effects getEffects();

    boolean isDead();
}
