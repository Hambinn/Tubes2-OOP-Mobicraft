package com.aetherwars.board;

public interface ActiveSpell {
    Spell getSpell();

    int getRemainingTime();

    boolean isWornOut();

    void extendDuration(int extension);

    int getAttackBuff();

    int receiveAttack(int attack);
}
