package com.aetherwars.board;

interface  ActiveCharacter {
    public void addExp(int addition);
    public void levelUp();
    public boolean hasEffect(/* Class<Spell> spell */); // Misal butuh ngecek swap effect
}
