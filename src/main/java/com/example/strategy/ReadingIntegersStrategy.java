package com.example.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingIntegersStrategy implements ReadingStrategy<Integer> {

    private Scanner scanner;

    public ReadingIntegersStrategy() {
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Integer> readInputs() {
        List<Integer> inputs = new ArrayList<>();

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
