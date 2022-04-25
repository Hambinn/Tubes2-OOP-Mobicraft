package com.aetherwars.board;

import com.aetherwars.model.Character;
import org.jetbrains.annotations.NotNull;

public interface ActiveCharacter {
    @NotNull Character getCharacter();

    void addExp(int addition);

    void levelUp();

    void levelDown();

    void swapStatus();

    void changeCharacter(@NotNull Character character);

    @NotNull Effects getEffects();

    @NotNull int getLevel();

    boolean isDead();

    void receiveAttack(int damage);

    int getAttackValue();
}
