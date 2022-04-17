package com.aetherwars.spell;

import com.aetherwars.board.ActiveCharacter;
import com.aetherwars.board.effect.Switcher;

public class SwapSpell extends SpellTemp {

    public SwapSpell(int id, String name, String description, String imagePath, int duration, int mana) {
        super(id, name, description, imagePath, mana, duration);
    }

    public void apply(ActiveCharacter character) {
        character.getEffects().addSwitcher(new Switcher(this));
    }
}