package com.weekendesk.anki;

import com.weekendesk.anki.domain.Box;
import com.weekendesk.anki.domain.Deck;
import com.weekendesk.anki.domain.Session;
import com.weekendesk.anki.domain.Student;

/**
 * This class is the higher class of the program. It is responsible running of the program from the first
 * action to do, to the last one.
 */
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

    /**
     * Load the cards of the deck into the red box.
     */
    private void loadDeck() {
        Deck deck = deckLoader.loadDeck();
        redBox.putCards(deck.cards);
    }
}
