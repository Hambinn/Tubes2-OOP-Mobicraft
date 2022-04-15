package com.aetherwars.board;

import com.aetherwars.model.Character;

import java.util.*;

public class BoardCard implements ActiveCharacter {
    private static final int minLevel = 1;
    private static final int maxLevel = 10;

    private static Map<Integer, Integer> maxExp;
    static {
        maxExp = new HashMap<>();
        for (int i = minLevel; i <= maxLevel; i++) {
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

    public Character getCharacter() {
        return character;
    }

    public void levelUp() throws Exception {
        if (!changeLevel(level + 1)) {
            throw new Exception();
        }
    }

    private boolean changeLevel(int newLevel) {
        if (newLevel < minLevel || newLevel >= maxLevel) {
            return false;
        }

        level = newLevel;
        exp = 0;
        hp = character.getHealth() + ((level - 1) * character.getHealthUp());
        atk = character.getAttack() + ((level - 1) * character.getAttackUp());

        return true;
    }

    public void addExp(int addition) {
        if (addition >= 0) {
            int max = maxExp.get(level);
            int space = max - exp;

            while (addition >= space && changeLevel(level + 1)) {
                addition -= space;
                space = maxExp.get(level);
            }
        } else {
            int space = exp;
            while (Math.abs(addition) >= space && changeLevel(level - 1)) {
                addition -= -space;
                space = maxExp.get(level);
            }
        }

        exp += addition;
    }

    public boolean hasEffect(/* Class<Spell> spell */) {
        for (Effect effect: effects) {
            // if (effect instanceof spell) {
        }
        return false;
    }
}
