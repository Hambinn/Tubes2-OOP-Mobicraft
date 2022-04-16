package com.aetherwars.board.ActiveCharacter;

abstract class Spell extends Card {
    protected boolean isPermanent;

    public Spell(int id, String name, String description, String imagePath, int mana, boolean isPermanent) {
        super(id, name, description, "Spell", imagePath, mana)
        this.isPermanent = isPermanent;
    }

    public boolean getIsPermanent() {
        return this.isPermanent;
    }

    public abstract void apply(ActiveCharacter character);
}






