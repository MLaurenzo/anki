package com.weekendesk.anki;

import com.weekendesk.anki.commandLine.CommandLine;
import com.weekendesk.anki.files.FileDeckLoader;

import java.util.Scanner;

/**
 * This class just instanciates the concrete classes and injects them to the Anki class.
 */
public final class Main {

    public static void main(String[] args) {
        Anki anki = new Anki(new CommandLine(new Scanner(System.in)), new FileDeckLoader());
        anki.run();
    }
}
