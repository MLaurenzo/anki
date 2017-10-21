package com.weekendesk.anki;

import com.weekendesk.anki.domain.Card;
import com.weekendesk.anki.domain.Evaluation;

public interface UserInterface {
    boolean askUserToLoadDeckOrNot();
    void sayGoodByeToTheUser();
    Evaluation askUserEvaluation(Card card);
}
