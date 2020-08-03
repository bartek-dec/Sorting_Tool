package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputReader implements InputReader {

    private Scanner scanner;

    public UserInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> readIntegers() {
        List<Integer> integers = new ArrayList<>();

        while (scanner.hasNext()) {
            try {
                String[] inputs = scanner.nextLine().split("\\s+");

                for (String s : inputs) {
                    integers.add(Integer.parseInt(s));
                }
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return integers;
    }
}
