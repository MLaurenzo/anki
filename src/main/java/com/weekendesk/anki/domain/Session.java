package com.weekendesk.anki.domain;

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

    /**
     * This method runs a session.
     * All cards in the red box are processed and then put either in the orange box or the green one.
     */
    public void run() {
        while(!redBox.isEmpty()) {
            Card currentCard = redBox.takeCard();

            Evaluation evaluation = student.guessAnswer(currentCard);

            getTheRightBox(evaluation).putCard(currentCard);
        }
    }

    /**
     * This method is responsible getting the right box according to the answer of the student.
     * @param evaluation - the evaluation of the answer of the student
     */
    private Box getTheRightBox(Evaluation evaluation) {
        switch (evaluation) {
            default:
                // the currentCard must go back to the red box by default in order not to loose it
                return redBox;
            case PARTLY_CORRECT:
                return orangeBox;
            case CORRECT:
                return greenBox;
        }
    }

}
