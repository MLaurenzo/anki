package com.weekendesk.anki.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {

    private Box box;

    @Before
    public void setUp() {
        box = new Box();
    }

    @Test
    public void test_empty_box() {
        Assert.assertTrue(box.isEmpty());
    }

    @Test
    public void test_not_empty_box() {
        box.addCard(new Card(null, null));

        Assert.assertFalse(box.isEmpty());
    }

    @Test
    public void test_empty_box_after_added_and_taking_card() {
        box.addCard(new Card(null, null));
        box.takeCard();

        Assert.assertTrue(box.isEmpty());
    }

    @Test
    public void test_an_added_card_can_be_taken_back() {
        Box box = new Box();
        Card card = new Card(null, null);

        box.addCard(card);

        Assert.assertEquals(card, box.takeCard());
    }

}