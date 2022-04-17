package com.aetherwars.board;

import com.aetherwars.model.Character;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BoardCard implements ActiveCharacter {
    private static final int minLevel = 1;
    private static final int maxLevel = 10;

    private static final Map<Integer, Integer> maxExp;

    static {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = minLevel; i <= maxLevel; i++) {
            map.put(i, (2 * i) - 1);
        }
        maxExp = Collections.unmodifiableMap(map);
    }

    private Character character;
    private Effects effects;
    private int hp;
    private int atk;
    private int level;
    private int exp;

    public BoardCard(Character character) {
        changeCharacter(character);
    }

    @Override
    public void changeCharacter(Character newCharacter) {
        character = newCharacter;
        hp = character.getHealth();
        atk = character.getAttack();
        level = 1;
        exp = 0;
        effects = new Effects(this);
    }

    private void setHp(int hp) {
        this.hp = Math.max(hp, 0);

        if (hp == 0) {
            // notify...
        }
    }

    private void setAtk(int atk) {
        this.atk = Math.max(atk, 0);
    }

    public int getHealth() {
        return hp;
    }

    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public Effects getEffects() {
        return effects;
    }

    @Override
    public void levelUp() {
        changeLevel(level + 1);
    }

    private boolean changeLevel(int newLevel) {
        if (newLevel < minLevel || newLevel > maxLevel) {
            return false;
        }

        level = newLevel;
        exp = 0;
        hp = character.getHealth() + ((level - 1) * character.getHealthUp());
        atk = character.getAttack() + ((level - 1) * character.getAttackUp());

        return true;
    }

    @Override
    public void addExp(int addition) {
        if (addition >= 0) {
            int space = maxExp.get(level) - exp;
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

    @Override
    public void swapStatus() {
        int tmp = hp;
        setHp(atk);
        setAtk(tmp);
    }

    @Override
    public boolean isDead() {
        return hp == 0;
    }

    @Override
    public void receiveAttack(int damage) {
        setHp(hp - effects.receiveAttack(damage));
    }
}
