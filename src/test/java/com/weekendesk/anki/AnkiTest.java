package com.weekendesk.anki;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AnkiTest {

    @Mock
    UserInterface userInterface;
    @Mock
    DeckLoader deckLoader;

    private Anki anki;

    @Before
    public void setUp() {
        anki = new Anki(userInterface, deckLoader);
    }

    @Test
    public void test_anki_is_saying_good_bye_when_exiting() {
        anki.run();

        verify(userInterface, times(1)).sayGoodByeToTheUser();
    }

}