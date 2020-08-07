package com.example.input.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingLinesStrategy implements Strategy {

    private Scanner scanner;

    public ReadingLinesStrategy() {
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<String> readInputs() {
        List<String> inputs = new ArrayList<>();

        while (scanner.hasNext()) {
            inputs.add(scanner.nextLine());
        }
        return inputs;
    }
}
