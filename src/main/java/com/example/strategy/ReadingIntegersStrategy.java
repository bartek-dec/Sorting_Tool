package com.example.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingIntegersStrategy implements ReadingStrategy<Long> {

    private Scanner scanner;

    public ReadingIntegersStrategy() {
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Long> readInputs() {
        List<Long> inputs = new ArrayList<>();

        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split("\\s+");
            for (String s : line) {
                try {
                    inputs.add(Long.parseLong(s));
                } catch (NumberFormatException e) {
                    System.out.println(s + " isn't a long. It's skipped");
                }
            }
        }
        return inputs;
    }
}
