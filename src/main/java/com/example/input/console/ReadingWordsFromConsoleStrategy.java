package com.example.input.console;

import com.example.input.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingWordsFromConsoleStrategy implements Strategy<Scanner> {

    private Scanner scanner;

    public ReadingWordsFromConsoleStrategy() {
    }

    @Override
    public void setSource(Scanner source) {
        this.scanner = source;
    }

    @Override
    public List<String> readInputs() {
        List<String> inputs = new ArrayList<>();

        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split("\\s+");
            for (String s : line) {
                inputs.add(s);
            }
        }
        return inputs;
    }
}
