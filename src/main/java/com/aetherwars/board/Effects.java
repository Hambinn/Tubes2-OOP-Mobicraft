package com.aetherwars.board;

import com.aetherwars.board.effect.ActiveSpell;
import com.aetherwars.board.effect.Buff;
import com.aetherwars.board.effect.Switcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Effects {
    private final List<Buff> buffs;
    private final Map<Class<? extends Switcher<?>>, Switcher<?>> switchers;

    public Effects() {
        this.buffs = new ArrayList<>();
        this.switchers = new HashMap<>();
    }

    public void addBuff(Buff buff) {
        buffs.add(0, buff);
    }

    public <S extends Spell> void addSwitcher(Switcher<?> newSwitcher) {
        Switcher<S> effect = (Switcher<S>) switchers.get(newSwitcher.getClass());
        if (effect == null) {
            switchers.put(newSwitcher.getClass(), newSwitcher);
        } else {
            effect.merge(newSwitcher);
        }
    }

    int getAttackBuff() {
        int total = buffs.stream().mapToInt(Buff::getAttackBuff).reduce(0, Integer::sum);
        return Math.max(total, 0);
    }

    int receiveAttack(int attack) {
        int remainder = attack;
        for (Buff effect : buffs) {
            remainder = effect.receiveAttack(attack);
        }

        buffs.removeIf(ActiveSpell::isWornOut);
        return remainder;
    }
}
