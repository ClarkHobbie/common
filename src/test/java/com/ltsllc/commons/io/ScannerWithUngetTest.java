package com.ltsllc.commons.io;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ScannerWithUngetTest {

    @Test
    void next() {
        String string = "hi scanner, how are you?";
        Scanner scanner = new Scanner(string);
        ScannerWithUnget scannerWithUnget = new ScannerWithUnget(scanner);

        String token = scannerWithUnget.next();

        assert (token.equalsIgnoreCase("hi"));
    }

    @Test
    void nexiNull() {
        String nullString = "";
        Scanner scanner = new Scanner(nullString);
        ScannerWithUnget scannerWithUnget = new ScannerWithUnget(scanner);

        String token = scannerWithUnget.next();

        assert (token == null);
    }

    @Test
    void unget() {
        String string = "hi scanner, how are you?";
        Scanner scanner = new Scanner(string);
        ScannerWithUnget scannerWithUnget = new ScannerWithUnget(scanner);

        String token = scannerWithUnget.next();
        token = scannerWithUnget.next();

        assert (token.equalsIgnoreCase("scanner,"));

        scannerWithUnget.unget(token);

        token = scannerWithUnget.next();

        assert (token.equalsIgnoreCase("scanner,"));
    }
}