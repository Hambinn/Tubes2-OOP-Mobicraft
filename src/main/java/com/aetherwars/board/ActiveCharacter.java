package com.aetherwars.board;

import com.aetherwars.model.Character;

public interface ActiveCharacter {
    Character getCharacter();

    void addExp(int addition);

    void resetExp();

    void updateHp(int updateHpValue);

    void updateAttack(int updateAttackValue);

    void levelUp() throws Exception;

    void swapStatus();

    void changeCharacter(int targetId);

    Effects getEffects();

    boolean isDead();
}
