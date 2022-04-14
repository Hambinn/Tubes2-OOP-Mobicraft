package com.aetherwars.deck;

import java.util.*;
import com.aetherwars.model.Card;

public class Deck {
    private Stack<Card> deck;
    private int jumlahKartu;
    private int kapasitasDeck;

    public Deck() {
        this.kapasitasDeck = 40;
        this.deck = new Stack<Card>();
        this.jumlahKartu = 0;
    }

    public Deck(int kapasitasDeck) {
        this.kapasitasDeck = kapasitasDeck;
        this.deck = new Stack<Card>();
        this.jumlahKartu = 0;
    }

    public int getJumlahKartu() {
        return jumlahKartu;
    }

    public void addCard(Card id) {
        if (this.jumlahKartu < this.kapasitasDeck) {
            this.deck.push(id);
            this.jumlahKartu++;
        }
    }

    public void addSomeCard(List<Card> listCard) {
        for(int i = 0; i < listCard.size(); i++) {
            addCard(listCard.get(i));
        }
    }

    public Card getCard() {
        Card card = this.deck.pop();
        this.jumlahKartu--;
        return card;
    }

    public List<Card> getSomeCard(int amount) {
        List<Card> listCard = new ArrayList<Card>();

        if(this.jumlahKartu < amount) {
            for(int i = 0; i < jumlahKartu; i++) {
                listCard.add(this.getCard());
            }
        }else{
            for(int i = 0; i < amount; i++) {
                listCard.add(this.getCard());
            }
        }

        return listCard;
    }

    public void printDeck(){
        System.out.println("Deck : ");
        for (int i = 0; i < this.jumlahKartu; i++) {
            System.out.println(this.deck.get(i));
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public boolean isEmpty() {
        return this.deck.isEmpty();
    }
}
