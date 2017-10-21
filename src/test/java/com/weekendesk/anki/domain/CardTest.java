package com.weekendesk.anki.domain;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    private static final String question = "MyQuestion";
    private static final String answer = "MyAnswer";

    @Test
    public void test_mapping_between_constructor_and_card_fields() {
        Card card = new Card(question, answer);

        Assert.assertEquals(question, card.question);
        Assert.assertEquals(answer, card.answer);
    }

    @Test
    public void test_toString_method() {
        Card card = new Card(question, answer);

        Assert.assertEquals("MyQuestion?|MyAnswer", card.toString());
    }
}
