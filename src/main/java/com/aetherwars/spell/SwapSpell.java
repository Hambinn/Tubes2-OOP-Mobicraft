package com.aetherwars.spell;

public class SwapSpell extends SpellTemp {

    public SwapSpell(int id, String name, String description, String imagepath, int duration, int mana) {
        super(id, name, description, imagePath, mana, int duration);
    }

    public void apply(ActiveCharacter character) {
        character.swapStatus();
    }
}