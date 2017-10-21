package com.weekendesk.anki.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessionTest {

    private Box redBox;
    private Box orangeBox;
    private Box greenBox;
    private Session session;

    @Before
    public void setUp() {
        redBox = new Box();
        orangeBox = new Box();
        greenBox = new Box();

        redBox.addCard(new Card(null, null));

        session = new Session(redBox, orangeBox, greenBox);
    }

    @Test
    public void test_all_cards_in_the_red_box_are_processed() {
        session.start();

        Assert.assertTrue(redBox.isEmpty());
    }

    @Test
    public void test_no_card_is_lost() {
        int initialNumberOfCard = redBox.numberOfCards() + orangeBox.numberOfCards() + greenBox.numberOfCards();

        session.start();
        int totalNumberOfCard = redBox.numberOfCards() + orangeBox.numberOfCards() + greenBox.numberOfCards();

        Assert.assertEquals(initialNumberOfCard, totalNumberOfCard);
    }

}