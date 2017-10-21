package com.weekendesk.anki.files;

import com.weekendesk.anki.DeckLoader;
import com.weekendesk.anki.domain.Card;
import com.weekendesk.anki.domain.Deck;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FileDeckLoader implements DeckLoader {
    @Override
    public Deck loadDeck() {
        // TODO fake implementation
        return new Deck(Arrays.asList(new Card("question1", "answer1"), new Card("question2", "answer2")));
    }
}
