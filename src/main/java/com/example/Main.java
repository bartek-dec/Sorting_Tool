package com.example;

import com.example.strategy.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Context context = new Context();
        String parameter = args[1];
        List<Object> inputs = null;

        switch (parameter) {
            case "long":
                inputs = context.getInputs(new ReadingIntegersStrategy(scanner));
                break;
            case "line":
                inputs = context.getInputs(new ReadingLinesStrategy(scanner));
                break;
            case "word":
                inputs = context.getInputs(new ReadingWordsStrategy(scanner));
        }

        long totalNumber = inputs.stream().count();

        int greatest = 0;
        String longest = null;
        Long quantity;

        if (Objects.equals(parameter, "long")) {
            Optional<Integer> optional = inputs.stream()
                    .map(o -> (Integer) o)
                    .max(Comparator.naturalOrder());

            greatest = optional.get();
        } else {
            Optional<String> optional = inputs.stream()
                    .map(o -> (String) o)
                    .max(Comparator.comparingInt(String::length));

            longest = optional.get();
        }

        if (Objects.equals(parameter, "long")) {
            int finalGreatest = greatest;
            quantity = inputs.stream()
                    .map(o -> (Integer) o)
                    .filter(o -> o == finalGreatest)
                    .count();
        } else {
            String finalLongest = longest;
            quantity = inputs.stream()
                    .map(o -> (String) o)
                    .filter(o -> o.equals(finalLongest))
                    .count();
        }

        double percente = ((1.0 * quantity) / totalNumber) * 100;
        long percentage = (long) percente;

        if (Objects.equals(parameter, "long")) {
            System.out.println("Total numbers: " + totalNumber + ".");
            System.out.println("The greatest number: " + greatest + " (" + quantity + " time(s), " + percentage + "%).");
        } else if (Objects.equals(parameter, "word")) {
            System.out.println("Total words: " + totalNumber + ".");
            System.out.println("The longest word: " + longest + " (" + quantity + " time(s), " + percentage + "%).");
        } else {
            System.out.println("Total lines: " + totalNumber + ".");
            System.out.println("The longest line:");
            System.out.println(longest);
            System.out.println("(" + quantity + " time(s), " + percentage + "%).");
        }

    }
}
