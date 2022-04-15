package com.aetherwars.board;

import com.aetherwars.model.Character;

import java.util.*;

public class BoardCard implements ActiveCharacter {
    private static Map<Integer, Integer> maxExp;
    static {
        maxExp = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            maxExp.put(i, (2 * i) - 1);
        }
        maxExp = Collections.unmodifiableMap(maxExp);
    }

    private Character character;
    private int hp;
    private int atk;
    int level;
    int exp;
    List<Effect> effects;

    public BoardCard(Character character) {
        this.character = character;
        this.hp = character.getHealth();
        this.atk = character.getAttack();
        this.level = 1;
        this.exp = 0;
        this.effects = new ArrayList<>();
    }

    public void levelUp() {
        level += 1;
        exp = 0;
        hp = character.getHealth() + ((level - 1) * character.getHealthUp());
        atk = character.getAttack() + ((level - 1) * character.getAttackUp());
    }

    public void addExp(int addition) {
        //
    }

    public boolean hasEffect(/* Class<Spell> spell */) {
        for (Effect effect: effects) {
            // if (effect instanceof spell) {
        }
        return false;
    }
}
