package com.weekendesk.anki.domain;

import com.weekendesk.anki.UserInterface;

public class Student {

    private UserInterface userInterface;

    public Student(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public Evaluation guessAnswer(Card card) {
        return userInterface.askUserEvaluation(card);
    }
}
