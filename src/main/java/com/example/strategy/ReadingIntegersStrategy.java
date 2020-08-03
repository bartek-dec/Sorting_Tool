package com.example.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingIntegersStrategy implements ReadingStrategy {

    private Scanner scanner;

    public ReadingIntegersStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Object> readInputs() {
        List<Object> inputs = new ArrayList<>();

        while (scanner.hasNext()) {
            try {
                String[] line = scanner.nextLine().split("\\s+");

                for (String s : line) {
                    inputs.add(Integer.parseInt(s));
                }
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return inputs;
    }
}
