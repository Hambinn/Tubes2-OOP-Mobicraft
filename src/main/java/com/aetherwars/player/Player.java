package com.aetherwars.player;

import java.util.List;
import java.util.ArrayList;

import com.aetherwars.deck.*;
import com.aetherwars.model.*;
import com.aetherwars.board.*;
import com.aetherwars.util.*;


public class Player {
    private String name;
    private int health;
    private int mana;
    private Deck deck;
    private PlayerHand playerHand;
    private Board board;
    private int round;
    private List<Card> topThree;
    

    public Player(String name, List<Card> charCards, List<Card> morphCards, List<Card> swapCards, List<Card> ptnCards, List<Card> levelCards) {
        this.name = name;
        this.health = 80;
        this.mana = this.round;
        this.round = 0;
        this.playerHand = new PlayerHand();

        this.deck = new Deck(charCards, morphCards, swapCards, ptnCards, levelCards);
        this.deck.shuffleDeck();

        for(int i = 0; i < 3; i++) {
            this.playerHand.addCard(this.deck.getCard());
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

    public List<Card> getPlayerHand(){
        return this.playerHand.getHand();
    }

    public Card getCardByIndex(int index) {
        return this.playerHand.getCard(index);
    }

    public void fillTopThree(){
        for(int i = 0; i < 3; i++) {
            this.topThree.add(this.deck.getCard());
        }
    }

    public List<Card> getTopThree(){
        return this.topThree;
    }

    public void drawCard(int choice){
        this.playerHand.addCard(this.topThree.get(choice-1));
        this.topThree.remove(choice-1);
        for(int i =0; i<2;i++){
            this.deck.addCard(this.topThree.get(i));
        }
        this.topThree.clear();
        this.deck.shuffleDeck();
    }   

    public void removeCard(){
        int choice = 1; // ini harusnya input user buat kartu yg mau dibuang, cuman gatau cara dapet inputnya gmn?
        this.deck.addCard(this.playerHand.discardCard(choice-1));
        this.playerHand.discardCard(choice-1);
    }

    public void nextRound(){
        this.round++;
        if(this.round < 10){
            this.mana = this.round;
        }else{
            this.mana = 10;
        }
    }

    public void discardCard(int choice){
        this.playerHand.discardCard(choice-1);
    }

    public void damaged(int damage){
        this.health -= damage;
    }

    public Deck getDeck(){
        return this.deck;
    }

    public int getSisaDeck(){
        return this.deck.getJumlahKartu();
    }
    // public void summonCard(int cardChoice, int position){
    //     if(this.playerHand.getCard(cardChoice).getTypeCard().equals("Character")){
    //         this.board.addCharacter(this.playerHand.getCard(choice));
    //         this.playerHand.discardCard(choice-1);
    //     }
    // }
}
