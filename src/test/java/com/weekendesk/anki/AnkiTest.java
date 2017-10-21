package com.weekendesk.anki;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

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

    @Test
    public void test_deck_is_loading_when_user_answers_yes() {
        when(userInterface.askUserToLoadDeckOrNot()).thenReturn(true);

        anki.run();

        verify(deckLoader, times(1)).loadDeck();
    }

    @Test
    public void test_deck_is_not_loading_when_user_answers_no() {
        when(userInterface.askUserToLoadDeckOrNot()).thenReturn(false);

        anki.run();

        verify(deckLoader, never()).loadDeck();
    }

}