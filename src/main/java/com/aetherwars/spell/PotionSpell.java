package com.aetherwars.spell;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.board.effect.Buff;

public class PotionSpell extends SpellTemp {
    protected int updateAttackValue;
    protected int updateHpValue;

    public PotionSpell(int id, String name, String description, String imagePath, int updateAttackValue, int updateHpValue, int mana, int duration) {
        super(id, name, description, imagePath, mana, duration);
        this.updateAttackValue = updateAttackValue;
        this.updateHpValue = updateHpValue;
    }

    public void apply(ActiveCharacter character) {
        // character.updateAttack(this.updateAttackValue);
        // character.updateHealth(this.updateHpValue);
        character.getEffects().addBuff(new Buff(this));
    }

    public int getUpdateAttackValue() {
        return this.updateAttackValue;
    }

    public int getUpdateHpValue() {
        return this.updateHpValue;
    }
}
