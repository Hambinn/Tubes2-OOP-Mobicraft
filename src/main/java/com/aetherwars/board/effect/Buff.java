package com.aetherwars.board.effect;

public interface Buff extends ActiveSpell {
    int getAttackBuff();

    int receiveAttack(int attack);
}
