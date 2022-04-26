package com.aetherwars.spell;

import java.lang.Math;
import com.aetherwars.board.ActiveCharacter;

public class LevelSpell extends Spell {
    private String levelSpellType;

    public LevelSpell(int id, String name, String description, String imagePath, String levelSpellType) {
        super(id, name, description, imagePath, -1, true, "Level");
        this.levelSpellType = levelSpellType;
    }

    public void apply(ActiveCharacter character) {
        if (this.levelSpellType=="LevelUp") {
            character.levelUp();
        } else if (this.levelSpellType=="LevelDown") {
            character.levelDown();
        }
    }
}