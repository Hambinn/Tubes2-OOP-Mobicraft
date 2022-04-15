package com.aetherwars.board;

import java.util.ArrayList;
import java.util.List;

public class Effects {
    private final List<ActiveSpell> effects;

    public Effects() {
        this.effects = new ArrayList<>();
    }

    public void push(ActiveSpell spell) {
        effects.add(0, spell);
    }

    public boolean has(Class<Spell> spellType) {
        return effects.stream().anyMatch(e -> spellType.isInstance(e.getSpell()));
    }

    public int getAttackBuff() {
        int total = effects.stream().mapToInt(ActiveSpell::getAttackBuff).reduce(0, Integer::sum);
        return Math.max(total, 0);
    }

    public int receiveAttack(int attack) {
        int remainder = attack;
        for (ActiveSpell effect : effects) {
            remainder = effect.receiveAttack(attack);
        }

        effects.removeIf(ActiveSpell::isWornOut);
        return remainder;
    }
}
