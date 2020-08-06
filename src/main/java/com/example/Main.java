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

        int index;
        String validType = null;
        String type;
        if (parameters.contains("-dataType")) {
            index = parameters.indexOf("-dataType");
            try {
                index++;
                type = parameters.get(index);
                while (!Objects.equals(type, "-sortingType")) {

                    if (Objects.equals(type, "long") ||
                            Objects.equals(type, "word") ||
                            Objects.equals(type, "line")) {
                        validType = type;
                    } else {
                        System.out.println("\"" + type + "\" isn't a valid parameter. It's skipped.");
                    }
                    index++;
                    type = parameters.get(index);
                }
            } catch (IndexOutOfBoundsException e) {
                if (!Objects.equals(validType, "long") &&
                        !Objects.equals(validType, "word") &&
                        !Objects.equals(validType, "line")) {
                    System.out.println("No data type defined!");
                    return;
                }
            }

            if (!Objects.equals(validType, "long") &&
                    !Objects.equals(validType, "word") &&
                    !Objects.equals(validType, "line")) {
                System.out.println("No data type defined!");
                return;
            }
        } else {
            validType = "word";
        }


        String validSort = null;
        String sort;
        if (parameters.contains("-sortingType")) {
            index = parameters.indexOf("-sortingType");
            try {
                index++;
                sort = parameters.get(index);
                while (!Objects.equals(sort, "-dataType")) {

                    if (Objects.equals(sort, "natural") ||
                            Objects.equals(sort, "byCount")) {
                        validSort = sort;
                    } else {
                        System.out.println("\"" + sort + "\" isn't a valid parameter. It's skipped.");
                    }
                    index++;
                    sort = parameters.get(index);
                }
            } catch (IndexOutOfBoundsException e) {
                if (!Objects.equals(validSort, "natural") &&
                        !Objects.equals(validSort, "byCount")) {
                    System.out.println("No sorting type defined!");
                    return;
                }
            }

            if (!Objects.equals(validSort, "natural") &&
                    !Objects.equals(validSort, "byCount")) {
                System.out.println("No sorting type defined!");
                return;
            }
        } else {
            validSort = "natural";
        }

        WordPrinter wordPrinter = new WordPrinter();
        if (Objects.equals(validType, "long")) {
            IntegerPrinter integerPrinter = new IntegerPrinter();
            Processor<Long> processor = new NumberProcessor();
            ReadingStrategy<Long> strategy = new ReadingIntegersStrategy();
            strategy.setScanner(scanner);

            Context<Long> context = new Context<>();
            context.setStrategy(strategy);
            List<Long> integers = context.getInputs();

            if (Objects.equals(validSort, "natural")) {
                List<Long> sorted = processor.sortAscending(integers);
                System.out.println(integerPrinter.printIntegerList(sorted));
            } else {
                List<Result<Long>> sorted = processor.sortByCount(integers);
                int size = integers.size();
                System.out.println(integerPrinter.printResultList(sorted, size));
            }

        } else if (Objects.equals(validType, "word")) {
            Processor<String> processor = new StringProcessor();
            ReadingStrategy<String> strategy = new ReadingWordsStrategy();
            strategy.setScanner(scanner);

            Context<String> context = new Context<>();
            context.setStrategy(strategy);
            List<String> strings = context.getInputs();

            if (Objects.equals(validSort, "natural")) {
                List<String> sorted = processor.sortAscending(strings);
                System.out.println(wordPrinter.printWordList(sorted));
            } else {
                List<Result<String>> sorted = processor.sortByCount(strings);
                int size = strings.size();
                System.out.println(wordPrinter.printResultList(sorted, size));
            }

        } else if (Objects.equals(validType, "line")) {
            Processor<String> processor = new StringProcessor();
            ReadingStrategy<String> strategy = new ReadingLinesStrategy();
            strategy.setScanner(scanner);

            Context<String> context = new Context<>();
            context.setStrategy(strategy);
            List<String> strings = context.getInputs();

            if (Objects.equals(validSort, "natural")) {
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
