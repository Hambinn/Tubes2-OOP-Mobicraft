package com.aetherwars.deck;

import java.util.*;
import com.aetherwars.model.Card;

public class Deck {
    private Stack<Card> deck;
    private int jumlahKartu;
    private int kapasitasDeck;

    public Deck() {
        this.kapasitasDeck = 60;
        this.deck = new Stack<Card>();
        this.jumlahKartu = 0;
    }

    public Deck(int kapasitasDeck) {
        this.kapasitasDeck = kapasitasDeck;
        this.deck = new Stack<Card>();
        this.jumlahKartu = 0;
    }

    public Deck(List<Card> charCards, List<Card> morphCards, List<Card> swapCards, List<Card> ptnCards, List<Card> levelCards){
        this.kapasitasDeck = 60;
        this.deck = new Stack<Card>();
        this.jumlahKartu = 0;

        addSomeCard(charCards);
        addSomeCard(morphCards);
        addSomeCard(swapCards);
        addSomeCard(ptnCards);
        addSomeCard(levelCards);

        int index1 = (int)(Math.random() * charCards.size());
        int index2 = (int)(Math.random() * charCards.size());
        addCard(charCards.get(index1));
        addCard(charCards.get(index2));

        index1 = (int)(Math.random() * morphCards.size());
        index2 = (int)(Math.random() * morphCards.size());
        addCard(morphCards.get(index1));
        addCard(morphCards.get(index2));

        index1 = (int)(Math.random() * swapCards.size());
        index2 = (int)(Math.random() * swapCards.size());
        addCard(swapCards.get(index1));
        addCard(swapCards.get(index2));

        index1 = (int)(Math.random() * ptnCards.size());
        index2 = (int)(Math.random() * ptnCards.size());
        addCard(ptnCards.get(index1));
        addCard(ptnCards.get(index2));

        index1 = (int)(Math.random() * levelCards.size());
        index2 = (int)(Math.random() * levelCards.size());
        addCard(levelCards.get(index1));
        addCard(levelCards.get(index2));

        shuffleDeck();
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
