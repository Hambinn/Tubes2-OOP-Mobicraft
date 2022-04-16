package com.aetherwars.spell;

public class LevelSpell extends Spell {

    public LevelSpell(int id, String name, String description, String imagePath, int Mana) {
        super(id, name, description, imagePath, mana, true);
    }

    public void apply(ActiveCharacter character) {
        character.resetExp();
        character.levelUp();
    }
}