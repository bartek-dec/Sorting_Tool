package com.example.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingWordsStrategy implements ReadingStrategy {

    private Scanner scanner;

    public ReadingWordsStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Object> readInputs() {
        List<Object> inputs = new ArrayList<>();

        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split("\\s+");
            for (String s : line) {
                inputs.add(s);
            }
        }
        return inputs;
    }
}
