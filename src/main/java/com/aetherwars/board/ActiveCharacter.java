package com.aetherwars.board;

import com.aetherwars.model.Character;

interface  ActiveCharacter {
    public Character getCharacter();
    public void addExp(int addition);
    public void levelUp() throws Exception;
    public boolean hasEffect(/* Class<Spell> spell */); // Misal butuh ngecek swap effect
}
