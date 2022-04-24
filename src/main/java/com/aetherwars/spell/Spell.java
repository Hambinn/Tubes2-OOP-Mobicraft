package com.aetherwars.spell;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.model.Card;

public abstract class Spell extends Card {
    protected boolean isPermanent;
    protected String spell_type;

    public Spell(int id, String name, String description, String imagePath, int mana, boolean isPermanent, String spell_type) {
        super(id, name, description, "Spell", imagePath, mana);
        this.isPermanent = isPermanent;
        this.spell_type = spell_type;
    }

    public boolean getIsPermanent() {
        return this.isPermanent;
    }
    @Override
    public String getSpellType() {
        return this.spell_type;
    }
    public abstract void apply(ActiveCharacter character);
}






