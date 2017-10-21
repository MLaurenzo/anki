package com.weekendesk.anki.commandLine;

import com.weekendesk.anki.UserInterface;
import com.weekendesk.anki.domain.Card;
import com.weekendesk.anki.domain.Evaluation;

import java.util.Scanner;

public class CommandLine implements UserInterface {
    private final Scanner scanner;

    public CommandLine(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean askUserToLoadDeckOrNot() {
        String answer = "";
        while (!(answer.equals("Y") || answer.equals("n"))) {
            System.out.println("Do you want to load a new Deck [Y/n]?");
            answer = scanner.nextLine();
        }
        return answer.equals("Y");
    }

    @Override
    public void sayGoodByeToTheUser() {
        System.out.println("Good bye !");
    }

    @Override
    public Evaluation askUserEvaluation(Card card) {
        System.out.println(card);
        System.out.println("How do you evaluate your answer ?");
        System.out.println("1. Correct");
        System.out.println("2. Partly orrect");
        System.out.println("3. Wrong");
        int answer = -1;
        while(answer < 1 || answer > 3) {
            answer = scanner.nextInt();
        }

        switch (answer) {
            default:
                return Evaluation.WRONG;
            case 1:
                return Evaluation.CORRECT;
            case 2:
                return Evaluation.PARTLY_CORRECT;
        }
    }
}
