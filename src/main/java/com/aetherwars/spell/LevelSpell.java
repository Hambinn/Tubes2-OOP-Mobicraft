package com.aetherwars.spell;

import com.aetherwars.board.ActiveCharacter;

public class LevelSpell extends Spell {

    public LevelSpell(int id, String name, String description, String imagePath, int mana) {
        super(id, name, description, imagePath, mana, true);
    }

    public void apply(ActiveCharacter character) {
        character.levelUp();
    }
}