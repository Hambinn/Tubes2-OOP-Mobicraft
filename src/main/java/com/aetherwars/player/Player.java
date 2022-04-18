package com.aetherwars.player;

import java.util.List;
import java.util.ArrayList;

import com.aetherwars.deck.*;
import com.aetherwars.model.*;
import com.aetherwars.board.*;

public class Player {
    private String name;
    private int health;
    private int mana;
    private Deck deck;
    private List<Card> hand;
    private Board board;
    private int round;
    private List<Card> topThree;

    public Player(String name) {
        this.name = name;
        this.health = 80;
        this.mana = this.round;
        this.round = 0;

        this.deck = new Deck();
        this.deck.shuffleDeck();

        this.hand = new ArrayList<Card>();
        for(int i = 0; i < 5; i++) {
            this.hand.add(this.deck.getCard());
        }

        this.topThree = new ArrayList<Card>();

        this.board = new Board();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public void fillTopThree(){
        for(int i = 0; i < 3; i++) {
            this.topThree.add(this.deck.getCard());
        }
    }

    public void drawCard(int choice){
        if(this.hand.size() < 5){
            this.hand.add(this.topThree.get(choice-1));
            this.topThree.remove(choice-1);
            for(int i =0; i<2;i++){
                this.deck.addCard(this.topThree.get(i));
            }
            this.topThree.clear();
        }else{
            this.hand.add(this.topThree.get(choice-1));
            this.topThree.remove(choice-1);
            for(int i =0; i<2;i++){
                this.deck.addCard(this.topThree.get(i));
            }
            this.topThree.clear();
            removeCard();
        }
    }   

    public void removeCard(){
        int choice = 1; // ini harusnya input user buat kartu yg mau dibuang, cuman gatau cara dapet inputnya gmn?
        this.deck.addCard(this.hand.get(choice-1));
        this.hand.remove(choice-1);
    }

    
}
