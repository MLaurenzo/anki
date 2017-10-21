package com.weekendesk.anki.domain;

import java.util.List;

/**
 * The goal of a session is to give the cards from the red box to the student and put it in the right box
 * depending of the answer of the student. The card is put in the red box if the student does not know the
 * answer, in the orange box if the student partly knows it, and in the green box if the student knows it.
 */
public class Session {

    private final Box redBox;
    private final Box orangeBox;
    private final Box greenBox;

    public Session(Box redBox, Box orangeBox, Box greenBox) {
        this.redBox = redBox;
        this.orangeBox = orangeBox;
        this.greenBox = greenBox;
    }

    public void start() {
        while(!redBox.isEmpty()) {
            // fake implementation
            Card takenCard = redBox.takeCard();
            greenBox.addCard(takenCard);
        }
    }

}
