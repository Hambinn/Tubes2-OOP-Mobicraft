package com.aetherwars.player;
import java.util.*;
import com.aetherwars.model.*;

public class PlayerHand {
    private List<Card> hand;
    

    public PlayerHand() {
        this.hand = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public Card discardCard(int choice) {
        Card c = this.hand.remove(choice-1);
        return c;
    }

    public int handSize() {
        return this.hand.size();
    }

    public Card getCard(int choice){
        return this.hand.get(choice-1);
    }

    


}
