package com.aetherwars.board.effect;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.spell.PotionSpell;
import org.jetbrains.annotations.NotNull;

public class Buff extends Effect {
    private final int atk;
    private int hp;

    public Buff(@NotNull PotionSpell spell) {
        super(spell);
        this.atk = spell.getUpdateAttackValue();
        this.hp = spell.getUpdateHpValue();
    }

    @Override
    public boolean isWornOut() {
        return super.isWornOut() || hp == 0;
    }

    public int getAttackBuff() {
        return atk;
    }

    public int receiveAttack(int damage) {
        int damaged;

        if (hp >= 0) {
            damaged = Math.min(damage, hp);
        } else {
            damaged = Math.max(damage, hp);
        }

        hp -= damaged;
        return damage - damaged;
    }
}
