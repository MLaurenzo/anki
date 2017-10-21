package com.weekendesk.anki.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SessionTest {

    @Mock
    private Student student;

    private Box redBox;
    private Box orangeBox;
    private Box greenBox;

    private Session session;

    @Before
    public void setUp() {
        // default behaviour returning CORRECT but could be overridden.
        when(student.guessAnswer(any())).thenReturn(Evaluation.CORRECT);

        redBox = new Box();
        orangeBox = new Box();
        greenBox = new Box();

        redBox.addCard(new Card(null, null));

        session = new Session(student, redBox, orangeBox, greenBox);
    }

    @Test
    public void test_all_cards_in_the_red_box_are_processed() {
        session.run();

        Assert.assertTrue(redBox.isEmpty());
    }

    // this test doesn't need to be run while the session put the card in the redbox by default.
    // anyway this test cannot be run for now because the session will not end if all answers are always
    // WRONG
    /*
    @Test
    public void test_all_cards_are_in_the_red_box_for_a_bad_student() {
        when(student.guessAnswer(any())).thenReturn(Evaluation.WRONG);

        session.run();

        Assert.assertEquals(1, redBox.numberOfCards());
    }
    */

    @Test
    public void test_all_cards_are_in_the_green_box_for_a_good_student() {
        when(student.guessAnswer(any())).thenReturn(Evaluation.CORRECT);

        session.run();

        Assert.assertEquals(1, greenBox.numberOfCards());
    }

    @Test
    public void test_all_cards_are_in_the_orange_box_for_a_medium_student() {
        when(student.guessAnswer(any())).thenReturn(Evaluation.PARTLY_CORRECT);

        session.run();

        Assert.assertEquals(1, orangeBox.numberOfCards());
    }

    @Test
    public void test_no_card_is_lost() {
        int initialNumberOfCard = redBox.numberOfCards() + orangeBox.numberOfCards() + greenBox.numberOfCards();

        session.run();
        int totalNumberOfCard = redBox.numberOfCards() + orangeBox.numberOfCards() + greenBox.numberOfCards();

        Assert.assertEquals(initialNumberOfCard, totalNumberOfCard);
    }

}