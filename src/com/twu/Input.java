package com.twu;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public final class Input {

    private static final Input instance = new Input();
    private final Scanner scanner;
    private Input() { scanner = new Scanner(System.in); }

    public static Input getInstance() {
        return instance;
    }

    public Integer getIntegerUntilSuccess(String emptyLinePrompt, String notNumberPrompt) {
        Optional<Integer> integer = getInteger(emptyLinePrompt);
        while (integer.isEmpty()) {
            System.out.print(notNumberPrompt);
            integer = getInteger(emptyLinePrompt);
        }
        return integer.get();
    }

    public Integer getIntegerUntilSuccess(String emptyLinePrompt,
                                          String notNumberPrompt,
                                          String outOfRangePrompt,
                                          Predicate<Integer> validator) {
        Integer integer = getIntegerUntilSuccess(emptyLinePrompt, notNumberPrompt);
        while (!validator.test(integer)) {
            System.out.print(outOfRangePrompt);
            integer = getIntegerUntilSuccess(emptyLinePrompt, notNumberPrompt);
        }
        return integer;
    }

    public Optional<Integer> getInteger() {
        return getInteger("");
    }

    public Optional<Integer> getInteger(String emptyLinePrompt) {
        try {
            return Optional.of(Integer.parseInt(getString(emptyLinePrompt)));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public String getString() {
        return getString("");
    }

    public String getString(String emptyLinePrompt) {
        String line = scanner.nextLine().trim();
        while (line.isEmpty()) {
            System.out.print(emptyLinePrompt);
            line = scanner.nextLine().trim();
        }
        return line;
    }

}