package com.aetherwars.model;

public abstract class Card {
    protected int id;
    protected String name;
    protected String description;
    protected String typeCard;       //Character or Spell
    protected String imagePath;
    protected int mana;

    /* Constructor Default */
    public Card(){
        this.id = 0;
        this.name = "";
        this.description = "";
        this.typeCard = "";
        this.imagePath = "";
        this.mana = 0;
    }

    /* Constructor User Defined */
    public Card(int id, String name, String description, String typeCard, String imagePath, int mana){
        this.id = id;
        this.name = name;
        this.description = description;
        this.typeCard = typeCard;
        this.imagePath = imagePath;
        this.mana = mana;
    }

    /* Getter */
    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public String getTypeCard(){
        return this.typeCard;
    }

    public String getImagePath(){
        return this.imagePath;
    }

    public int getMana(){
        return this.mana;
    }
}
