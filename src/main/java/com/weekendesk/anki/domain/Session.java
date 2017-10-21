package com.weekendesk.anki.domain;

import java.util.List;

/**
 * The goal of a session is to give the cards from the red box to the student and put it in the right box
 * depending of the answer of the student. The card is put in the red box if the student does not know the
 * answer, in the orange box if the student partly knows it, and in the green box if the student knows it.
 */
public class Session {

    private final Student student;
    private final Box redBox;
    private final Box orangeBox;
    private final Box greenBox;

    public Session(Student student, Box redBox, Box orangeBox, Box greenBox) {
        this.student = student;
        this.redBox = redBox;
        this.orangeBox = orangeBox;
        this.greenBox = greenBox;
    }

    public void run() {
        while(!redBox.isEmpty()) {
            Card currentCard = redBox.takeCard();

            switch (student.guessAnswer(currentCard)) {
                default:
                    // the currentCard must go back to the red box by default in order not to loose it
                    redBox.addCard(currentCard);
                    break;
                case PARTLY_CORRECT:
                    orangeBox.addCard(currentCard);
                    break;
                case CORRECT:
                    greenBox.addCard(currentCard);
                    break;
            }
        }
    }

}
