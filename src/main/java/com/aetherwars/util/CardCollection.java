package com.aetherwars.util;

import java.io.File;
import java.util.*;
import java.io.IOException;
import java.net.URISyntaxException;
import com.aetherwars.model.Card;
import com.aetherwars.model.Character;
import com.aetherwars.model.Type;
// import com.aetherwars.spell.Spell;
import com.aetherwars.spell.MorphSpell;
import com.aetherwars.spell.PotionSpell;
import com.aetherwars.spell.SwapSpell;

public class CardCollection {
    private List<Card> characterCollection;
    private List<Card> morphSpellCollection;
    private List<Card> ptnSpellCollection;
    private List<Card> swapSpellCollection;
    private static final String CHARACTER_CSV_FILE_PATH = "/com/aetherwars/card/data/character.csv";
    private static final String MORPHS_CSV_FILE_PATH = "/com/aetherwars/card/data/spell_morph.csv";
    private static final String PTN_CSV_FILE_PATH = "/com/aetherwars/card/data/spell_ptn.csv";
    private static final String SWAP_CSV_FILE_PATH = "/com/aetherwars/card/data/spell_swap.csv";

    public CardCollection() {
        try {
            loadCardCollection();
        } catch (Exception e) {
            //gatau ini throw apa
        }
    }

    public void loadCardCollection() throws IOException, URISyntaxException {
        this.characterCollection = new ArrayList<Card>();
        this.morphSpellCollection = new ArrayList<Card>();
        this.ptnSpellCollection = new ArrayList<Card>();
        this.swapSpellCollection = new ArrayList<Card>();

        File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
        CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
        characterReader.setSkipHeader(true);
        List<String[]> characterRows = characterReader.read();
        for (String[] row : characterRows) {
            //Character(int id, String name, String description,String imagePath, int mana, Type element, int attack, int health, int attackUp, int healthUp)
            Character c = new Character(Integer.parseInt(row[0]), row[1], row[3], row[4], Integer.parseInt(row[7]), Type.valueOf(row[2]), Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[8]), Integer.parseInt(row[9]));
            this.characterCollection.add(c);
        }

        File morphsCSVFile = new File(getClass().getResource(MORPHS_CSV_FILE_PATH).toURI());
        CSVReader morphsReader = new CSVReader(morphsCSVFile, "\t");
        morphsReader.setSkipHeader(true);
        List<String[]> morphRows = morphsReader.read();
        for (String[] row : morphRows) {
            //MorphSpell(int id, String name, String description, String imagePath, int targetId, int mana)
            MorphSpell m = new MorphSpell(Integer.parseInt(row[0]), row[1], row[2], row[3], Integer.parseInt(row[4]), Integer.parseInt(row[5]));
            this.morphSpellCollection.add(m);
        }
        
        File ptnCSVFile = new File(getClass().getResource(PTN_CSV_FILE_PATH).toURI());
        CSVReader ptnReader = new CSVReader(ptnCSVFile, "\t");
        ptnReader.setSkipHeader(true);
        List<String[]> ptnRows = ptnReader.read();
        for(String[] row : ptnRows){
            //PotionSpell(int id, String name, String description, String imagePath, int updateAttackValue, int updateHpValue, int mana, int duration)
            PotionSpell p = new PotionSpell(Integer.parseInt(row[0]), row[1], row[2], row[3], Integer.parseInt(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]));
            this.ptnSpellCollection.add(p);
        }

        File swapCSVFile = new File(getClass().getResource(SWAP_CSV_FILE_PATH).toURI());
        CSVReader swapReader = new CSVReader(swapCSVFile, "\t");
        swapReader.setSkipHeader(true);
        List<String[]> swapRows = swapReader.read();
        for(String[] row : swapRows){
            //SwapSpell(int id, String name, String description, String imagePath, int duration, int mana)
            SwapSpell s = new SwapSpell(Integer.parseInt(row[0]), row[1], row[2], row[3], Integer.parseInt(row[4]), Integer.parseInt(row[5]));
            this.swapSpellCollection.add(s);
        }
    }

    public List<Card> getCharacterCollection() {
        return this.characterCollection;
    }

    public List<Card> getMorphSpellCollection() {
        return this.morphSpellCollection;
    }

    public List<Card> getPtnSpellCollection() {
        return this.ptnSpellCollection;
    }

    public List<Card> getSwapSpellCollection() {
        return this.swapSpellCollection;
    }
}