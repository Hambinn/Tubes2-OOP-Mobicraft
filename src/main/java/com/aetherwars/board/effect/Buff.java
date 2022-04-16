package com.aetherwars.board.effect;

import com.aetherwars.spell.PotionSpell;

public class Buff extends Effect {
    private final int atk;
    private int hp;

    public Buff(PotionSpell spell) {
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
        int damaged = Math.min(damage, hp);
        hp -= damaged;
        return damage - damaged;
    }
}
