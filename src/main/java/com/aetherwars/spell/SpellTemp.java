package com.aetherwars.spell;

public class SpellTemp extends Spell {
    protected int duration;

    public SpellTemp(int id, String name, String description, String imagePath, int mana, int duration) {
        if (duration == 0) {
            super(id, name, description, imagePath, mana, true);
        }
        else {
            super(id, name, description, imagePath, mana, false);
        }
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public boolean isDurationIsOver() {
        return getDuration() == 0;
    }
}
