package com.aetherwars.board.effect;

public class PotionEffect extends Effect {
    private final int atk;
    private int hp;

    public PotionEffect(PotionSpell spell) {
        super(spell);
        this.atk = spell.getAtk();
        this.hp = spell.getHp();
    }

    @Override
    public boolean isWornOut() {
        return super.isWornOut() || hp == 0;
    }

    @Override
    public int getAttackBuff() {
        return atk;
    }

    @Override
    public int receiveAttack(int attack) {
        int attacked = Math.min(attack, hp);
        hp -= attacked;
        return attack - attacked;
    }
}
