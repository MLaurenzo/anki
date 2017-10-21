package com.weekendesk.anki.commandLine;

import com.weekendesk.anki.UserInterface;

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
}
