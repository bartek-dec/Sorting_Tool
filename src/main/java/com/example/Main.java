package com.example;

import com.example.data.NumberProcessor;
import com.example.data.Processor;
import com.example.data.StringProcessor;
import com.example.output.list.IntegerPrinter;
import com.example.output.list.WordPrinter;
import com.example.strategy.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> parameters = Arrays.asList(args);

        String inputType;
        int index = parameters.indexOf("-dataType");
        inputType = parameters.get(index + 1);

        String sortType;
        if (parameters.contains("-sortingType")) {
            index = parameters.indexOf("-sortingType");
            sortType = parameters.get(index + 1);
        } else {
            sortType = "natural";
        }

        WordPrinter wordPrinter = new WordPrinter();
        if (Objects.equals(inputType, "long")) {
            IntegerPrinter integerPrinter = new IntegerPrinter();
            Processor<Integer> processor = new NumberProcessor();
            ReadingStrategy<Integer> strategy = new ReadingIntegersStrategy();
            strategy.setScanner(scanner);

            Context<Integer> context = new Context<>();
            context.setStrategy(strategy);
            List<Integer> integers = context.getInputs();

            if (Objects.equals(sortType, "natural")) {
                List<Integer> sorted = processor.sortAscending(integers);
                System.out.println(integerPrinter.printIntegerList(sorted));
            } else {
                List<Result<Integer>> sorted = processor.sortByCount(integers);
                int size = integers.size();
                System.out.println(integerPrinter.printResultList(sorted, size));
            }

        } else if (Objects.equals(inputType, "word")) {
            Processor<String> processor = new StringProcessor();
            ReadingStrategy<String> strategy = new ReadingWordsStrategy();
            strategy.setScanner(scanner);

            Context<String> context = new Context<>();
            context.setStrategy(strategy);
            List<String> strings = context.getInputs();

            if (Objects.equals(sortType, "natural")) {
                List<String> sorted = processor.sortAscending(strings);
                System.out.println(wordPrinter.printWordList(sorted));
            } else {
                List<Result<String>> sorted = processor.sortByCount(strings);
                int size = strings.size();
                System.out.println(wordPrinter.printResultList(sorted, size));
            }

        } else if (Objects.equals(inputType, "line")) {
            Processor<String> processor = new StringProcessor();
            ReadingStrategy<String> strategy = new ReadingLinesStrategy();
            strategy.setScanner(scanner);

            Context<String> context = new Context<>();
            context.setStrategy(strategy);
            List<String> strings = context.getInputs();

            if (Objects.equals(sortType, "natural")) {
                List<String> sorted = processor.sortAscending(strings);
                System.out.println(wordPrinter.printLineList(sorted));
            } else {
                List<Result<String>> sorted = processor.sortByCount(strings);
                int size = strings.size();
                System.out.println(wordPrinter.printResultList(sorted, size));
            }
        }
    }
}
