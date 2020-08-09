package com.example.input.console;

import com.example.input.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingLinesFromConsoleStrategy implements Strategy<Scanner> {

    private Scanner scanner;

    public ReadingLinesFromConsoleStrategy() {
    }

    @Override
    public void setSource(Scanner source) {
        this.scanner = source;
    }

    @Override
    public List<String> readInputs() {
        List<String> inputs = new ArrayList<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            inputs.add(line);
        }
        return inputs;
    }
}
