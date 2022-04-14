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
    super();
    this.type = Type.OVERWORLD;
    this.attack = 0;
    this.health = 0;
    this.attackUp = 0;
    this.healthUp = 0;
  }

  public Character(int id, String name, String description, String typeCard, String imagePath, int mana, Type element, int attack, int health, int attackUp, int healthUp) {
    super(id,name,description,typeCard,imagePath,mana);
    this.type = element;
    this.attack = attack;
    this.health = health;
    this.attackUp = attackUp;
    this.healthUp = healthUp;
  }

  /* Getter */

  public Type getType(){
    return this.type;
  }

  public int getAttack(){
    return this.attack;
  }

  public int getHealth(){
    return this.health;
  }

  public int getAttackUp(){
    return this.attackUp;
  }

  public int getHealthUp(){
    return this.healthUp;
  }

  /* Setter */

  public void setAttack(int attack){
    this.attack = attack;
  }

  public void setHealth(int health){
    this.health = health;
  }

  @Override
  public String toString() {
    return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
  }
}

