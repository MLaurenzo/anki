package com.weekendesk.anki;

import com.weekendesk.anki.commandLine.CommandLine;
import com.weekendesk.anki.files.FileDeckLoader;

import java.util.Scanner;

public final class Main {

    public static void main(String[] args) {
        Anki anki = new Anki(new CommandLine(new Scanner(System.in)), new FileDeckLoader());
        anki.run();
    }
}
