package com.weekendesk.anki;

import com.weekendesk.anki.domain.Box;
import com.weekendesk.anki.domain.Deck;
import com.weekendesk.anki.domain.Session;
import com.weekendesk.anki.domain.Student;

public class Anki {

    private final UserInterface userInterface;
    private final DeckLoader deckLoader;

    private final Student student;

    private final Box redBox = new Box();
    private final Box orangeBox = new Box();
    private final Box greenBox = new Box();

    public Anki(UserInterface userInterface, DeckLoader deckLoader) {
        this.userInterface = userInterface;
        this.deckLoader = deckLoader;

        student = new Student(userInterface);
    }

    public void run() {
        if (userInterface.askUserToLoadDeckOrNot()) loadDeck();

        Session session = new Session(student, redBox, orangeBox, greenBox);
        session.run();

        userInterface.sayGoodByeToTheUser();
    }

    private void loadDeck() {
        Deck deck = deckLoader.loadDeck();
        redBox.putCards(deck.cards);
    }
}
