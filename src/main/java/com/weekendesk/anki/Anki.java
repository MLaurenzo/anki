package com.weekendesk.anki;

public class Anki {

    private final UserInterface userInterface;
    private final DeckLoader deckLoader;

    public Anki(UserInterface userInterface, DeckLoader deckLoader) {
        this.userInterface = userInterface;
        this.deckLoader = deckLoader;
    }

    public void run() {
        if (userInterface.askUserToLoadDeckOrNot()) loadDeck();

        userInterface.sayGoodByeToTheUser();
    }

    private void loadDeck() {
        deckLoader.loadDeck();
    }
}
