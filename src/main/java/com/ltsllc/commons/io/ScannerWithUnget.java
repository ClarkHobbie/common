package com.ltsllc.commons.io;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerWithUnget {
    private Scanner scanner;
    private List<String> tokenCache = new ArrayList<>();

    public ScannerWithUnget(Scanner scanner) {
        this.scanner = scanner;
    }

    public String next() {
        try {
            if (!tokenCache.isEmpty()) {
                return tokenCache.remove(0); // Retrieve from cache
            } else {
                return scanner.next(); // Read from Scanner
            }
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void unget(String token) {
        tokenCache.add(0, token); // Add to beginning of cache
    }

}
