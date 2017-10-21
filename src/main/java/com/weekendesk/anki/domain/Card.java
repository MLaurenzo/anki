package com.weekendesk.anki.domain;

/**
 * This class represents a card containing a question and its answer.
 */
public class Card {

    public final String question;
    public final String answer;

    public Card(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String toString() {
        return question + "?|" + answer;
    }
}
