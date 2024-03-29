package com.aetherwars.spell;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.util.CardCollection;
import com.aetherwars.model.Character;

public class MorphSpell extends Spell {
    protected int targetId;
    public MorphSpell(int id, String name, String description, String imagePath, int targetId, int mana) {
        super(id, name, description, imagePath, mana, true, "Morph");
        this.targetId = targetId;
    }

    public void apply(ActiveCharacter character) {
        // Ambil character dari data access object berdasarkan targetId
        // Baru taro ke changeCharacter
        // Character character = DAOCharacter.get(targetId);
        character.changeCharacter(CardCollection.getInstance().getCharacterbyId(targetId));
    }

    public Character getTarget() {
        return CardCollection.getInstance().getCharacterbyId(targetId);
    }
}