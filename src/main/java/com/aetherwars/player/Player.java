package com.aetherwars.player;

import java.util.List;
import java.util.ArrayList;

import com.aetherwars.deck.*;
import com.aetherwars.model.*;
import com.aetherwars.model.Character;
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
        this.round = 1;
        this.mana = this.round;
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

    public Board getBoard() {
        return this.board;
    }

    public int getRound(){
        if(this.round < 10){
            return this.round;
        }else{
            return 10;
        }
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
        if(this.playerHand.handSize() < 5){
            this.playerHand.addCard(this.topThree.get(choice-1));
            this.topThree.remove(choice-1);
            for(int i =0; i<2;i++){
                this.deck.addCard(this.topThree.get(i));
            }
            this.topThree.clear();
        }else{
            removeCard();
            this.playerHand.addCard(this.topThree.get(choice-1));
            this.topThree.remove(choice-1);
            for(int i =0; i<2;i++){
                this.deck.addCard(this.topThree.get(i));
            }
            this.topThree.clear();
        }
        this.deck.shuffleDeck();
    }

    public void removeCard(){
        Card remove = this.playerHand.discardCard(0);
    }

    public void nextRound(){
        this.round++;
        if(this.round < 10){
            this.mana = this.round;
        }else{
            this.mana = 10;
        }
    }

    // public void discardCard(int choice){
    //     this.playerHand.discardCard(choice-1);
    // }

    public void damaged(int damage){
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public Deck getDeck(){
        return this.deck;
    }

    public int getSisaDeck(){
        return this.deck.getJumlahKartu();
    }

    public void setMana(int usedMana){
        this.mana += usedMana;
    }
    // public void summonCard(int cardChoice, int position){
    //     if(this.playerHand.getCard(cardChoice).getTypeCard().equals("Character")){
    //         this.board.addCharacter(this.playerHand.getCard(choice));
    //         this.playerHand.discardCard(choice-1);
    //     }
    // }
}
