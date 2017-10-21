package com.weekendesk.anki.domain;

import java.util.List;

/**
 * This class represents a list of cards.
 */
public class Deck {
    public final List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }
}
