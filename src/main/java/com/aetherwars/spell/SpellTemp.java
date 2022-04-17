package com.aetherwars.spell;

public abstract class SpellTemp extends Spell {
    protected int duration;

    public SpellTemp(int id, String name, String description, String imagePath, int mana, int duration) {
        super(id, name, description, imagePath, mana, duration == 0);
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public boolean isDurationIsOver() {
        return getDuration() == 0;
    }
}
