package com.aetherwars.board;

import com.aetherwars.board.effect.ActiveSpell;
import com.aetherwars.board.effect.Buff;
import com.aetherwars.board.effect.Switcher;
import com.aetherwars.events.EffectWornOutEvent;
import com.aetherwars.pubsub.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Effects implements Subscriber<EffectWornOutEvent> {
    private final ActiveCharacter character;
    private final List<Buff> buffs;
    private Switcher switcher;

    public Effects(ActiveCharacter character) {
        this.character = character;
        this.buffs = new ArrayList<>();
    }

    public void addBuff(Buff buff) {
        buffs.add(0, buff);
        buff.onAttach(character);
    }

    public void addSwitcher(Switcher newSwitcher) {
        if (switcher == null) {
            switcher = newSwitcher;
            newSwitcher.onAttach(character);
            newSwitcher.getChannel().subscribe(EffectWornOutEvent.class, this);
        } else {
            switcher.merge(newSwitcher);
        }
    }

    int getAttackBuff() {
        int total = buffs.stream().mapToInt(Buff::getAttackBuff).reduce(0, Integer::sum);
        return Math.max(total, 0);
    }

    int receiveAttack(int damage) {
        int remainder = damage;
        for (Buff buff : buffs) {
            remainder = buff.receiveAttack(remainder);
        }

        cleanWornOut();
        return remainder;
    }

    @Override
    public boolean on(EffectWornOutEvent event) {
        event.getEffect().onWornOut(character);
        cleanWornOut();
        return true;
    }

    private void cleanWornOut() {
        buffs.removeIf(ActiveSpell::isWornOut);
        if (switcher.isWornOut()) {
            switcher = null;
        }
    }
}
