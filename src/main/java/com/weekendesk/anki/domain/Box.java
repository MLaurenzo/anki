package com.weekendesk.anki.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class represent a box where you can add cards to store them, and take them back.
 */
public class Box {
    private List<Card> cards = new ArrayList<>();

    /**
     * This method add a card into the box.
     * @param card - card which is added
     */
    public void putCard(Card card) {
        cards.add(card);
    }

    /**
     * This methods add several cards into the box.
     * @param cards - cards which are added
     */
    public void putCards(Collection<Card> cards) {
        this.cards.addAll(cards);
    }

    /**
     * The methods gives a card from the box. The card is not containes in the box anymore.
     * @return a card from the box.
     */
    public Card takeCard() {
        // This current implementation is returning the first card of the list,
        // but this could change in the future.
        return cards.remove(0);
    }

    /**
     * This methods indicates if there is some cards left in the box or not.
     * @return true if the box is empty, false otherwise.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * The number of cards in this box is a positive integer.
     * @return the number of cards in this box.
     */
    public int numberOfCards() {
        return cards.size();
    }
}
