package com.weekendesk.anki.domain;

import com.weekendesk.anki.UserInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentTest {

    @Mock
    private UserInterface userInterface;
    @InjectMocks
    private Student student;

    public void test_guessAnswerMethod_is_returning_evaluation(Evaluation evaluation) {
    }

    @Test
    public void test_guessAnswerMethod_is_returning_CORRECT() {
        when(userInterface.askUserEvaluation(any())).thenReturn(Evaluation.CORRECT);
        Card card = new Card(null, null);

        student.guessAnswer(card);

        verify(userInterface, times(1)).askUserEvaluation(card);
    }

}