package com.weekendesk.anki.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void test_guessAnswerMethod_is_returning_CORRECT() {
        Student student = new Student();

        Card card = new Card(null, null);

        Evaluation evaluation = student.guessAnswer(card);

        Assert.assertEquals(Evaluation.CORRECT, evaluation);
    }

}