package com.aetherwars.board;

import com.aetherwars.board.effect.ActiveSpell;
import com.aetherwars.board.effect.Buff;
import com.aetherwars.board.effect.Switcher;
import com.aetherwars.events.EffectWornOutEvent;
import com.aetherwars.pubsub.Subscriber;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Effects implements Subscriber<EffectWornOutEvent> {
    private final @NotNull ActiveCharacter character;
    private final @NotNull List<Buff> buffs;
    private @Nullable Switcher switcher;

    public Effects(@NotNull ActiveCharacter character) {
        this.character = character;
        this.buffs = new ArrayList<>();
    }

    public void addBuff(@NotNull Buff buff) {
        buffs.add(0, buff);
        buff.onAttach(character);
    }

    public void addSwitcher(@NotNull Switcher newSwitcher) {
        if (switcher == null) {
            switcher = newSwitcher;
            newSwitcher.onAttach(character);
            newSwitcher.getChannel().subscribe(EffectWornOutEvent.class, this);
        } else {
            switcher.merge(newSwitcher);
        }
    }

    int calcAttackBuff() {
        return buffs.stream().mapToInt(Buff::getAttackBuff).reduce(0, Integer::sum);
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
    public boolean on(@NotNull EffectWornOutEvent event) {
        event.getEffect().onWornOut(character);
        cleanWornOut();
        return true;
    }

    private void cleanWornOut() {
        buffs.removeIf(ActiveSpell::isWornOut);
        if (switcher != null && switcher.isWornOut()) {
            switcher = null;
        }
    }

    public void clear() {
        buffs.clear();
        switcher = null;
    }
}
