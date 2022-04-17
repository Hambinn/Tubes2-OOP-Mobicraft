package com.aetherwars.board;

import com.aetherwars.model.Character;

public interface ActiveCharacter {
    Character getCharacter();

    void addExp(int addition);

    void levelUp();

    void swapStatus();

    void changeCharacter(Character character);

    Effects getEffects();

    boolean isDead();

    void receiveAttack(int damage);
}
