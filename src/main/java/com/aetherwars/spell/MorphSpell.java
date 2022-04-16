package com.aetherwars.spell;

public class MorphSpell extends Spell {
    protected int targetId;
    public MorphSpell(int id, String name, String description, String imagepath, int targetid, int mana) {
        super(id, name, description, imagePath, mana, true);
        this.targetId = targetId;
    }

    public void apply(ActiveCharacter character) {
        character.changeCharacter(this.targetId);
    }
}