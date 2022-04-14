package com.aetherwars.model;

public class Character extends Card {
  // private String name;
  // private String description;
  private Type type;
  private int attack;
  private int health;
  private int attackUp;
  private int healthUp;

  public Character() {
    this.name = "";
    this.description = "";
    this.type = Type.OVERWORLD;
  }

  public Character(int id, String name, String description, String typeCard, String imagePath, int mana, Type element, int attack, int health, int attackUp, int healthUp) {
    super(id,name,description,typeCard,imagePath,mana);
    this.type = element;
    this.attack = attack;
    this.health = health;
    this.attackUp = attackUp;
    this.healthUp = healthUp;
  }

  @Override
  public String toString() {
    return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
  }
}

