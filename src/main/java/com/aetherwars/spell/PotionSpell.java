package com.aetherwars.spell;

public class PotionSpell extends SpellTemp {
    protected int updateAttackValue;
    protected int updateHpValue;

    public PotionSpell(int id, String name, String description, String imagepath, int updateAttackValue, int attackHp, int Mana, int duration) {
       super(id, String name, String description, String imagePath, int mana, int duration);
       this.updateAttackValue = updateAttackValue;
       this.updateHpValue = updateHpValue;
    }

    public void apply(ActiveCharacter character) {
        character.updateAttack(this.updateAttackValue);
        character.updateHealth(this.updateHpValue);
    }
}
