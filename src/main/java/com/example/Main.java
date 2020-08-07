package com.example;

import com.example.data.manipulate.NumberProcessor;
import com.example.data.manipulate.Processor;
import com.example.data.manipulate.StringProcessor;
import com.example.data.result.Result;
import com.example.input.Context;
import com.example.input.Strategy;
import com.example.output.printers.LongPrinter;
import com.example.output.printers.LongPrinterImpl;
import com.example.output.printers.WordPrinterImpl;
import com.example.input.console.*;
import com.example.util.Converter;
import com.example.util.LongConverter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final String DATA_TYPE = "-dataType";
    private static final String SORTING_TYPE = "-sortingType";
    private static final String INPUT_FILE = "-inputFile";
    private static final String OUTPUT_FILE = "-outputFile";
    private static final String SUFFIX = ".txt";
    private static final String LONG = "long";
    private static final String WORD = "word";
    private static final String LINE = "line";
    private static final String NATURAL = "natural";
    private static final String BY_COUNT = "byCount";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> parameters = Arrays.asList(args);

        int index;
        String validType = null;
        String type;
        if (parameters.contains(DATA_TYPE)) {
            index = parameters.indexOf(DATA_TYPE);
            try {
                index++;
                type = parameters.get(index);
                while (!Objects.equals(type, SORTING_TYPE)) {

                    if (Objects.equals(type, LONG) ||
                            Objects.equals(type, WORD) ||
                            Objects.equals(type, LINE)) {
                        validType = type;
                    } else {
                        System.out.println("\"" + type + "\" isn't a valid parameter. It's skipped.");
                    }
                    index++;
                    type = parameters.get(index);
                }
            } catch (IndexOutOfBoundsException e) {
                if (!Objects.equals(validType, LONG) &&
                        !Objects.equals(validType, WORD) &&
                        !Objects.equals(validType, LINE)) {
                    System.out.println("No data type defined!");
                    return;
                }
            }

            if (!Objects.equals(validType, LONG) &&
                    !Objects.equals(validType, WORD) &&
                    !Objects.equals(validType, LINE)) {
                System.out.println("No data type defined!");
                return;
            }
        } else {
            validType = WORD;
        }


        String validSort = null;
        String sort;
        if (parameters.contains(SORTING_TYPE)) {
            index = parameters.indexOf(SORTING_TYPE);
            try {
                index++;
                sort = parameters.get(index);
                while (!Objects.equals(sort, DATA_TYPE)) {

                    if (Objects.equals(sort, NATURAL) ||
                            Objects.equals(sort, BY_COUNT)) {
                        validSort = sort;
                    } else {
                        System.out.println("\"" + sort + "\" isn't a valid parameter. It's skipped.");
                    }
                    index++;
                    sort = parameters.get(index);
                }
            } catch (IndexOutOfBoundsException e) {
                if (!Objects.equals(validSort, NATURAL) &&
                        !Objects.equals(validSort, BY_COUNT)) {
                    System.out.println("No sorting type defined!");
                    return;
                }
            }

            if (!Objects.equals(validSort, NATURAL) &&
                    !Objects.equals(validSort, BY_COUNT)) {
                System.out.println("No sorting type defined!");
                return;
            }
        } else {
            validSort = NATURAL;
        }

        WordPrinterImpl wordPrinterImpl = new WordPrinterImpl();
        if (Objects.equals(validType, LONG)) {
            LongPrinter longPrinterImpl = new LongPrinterImpl();
            Processor<Long> processor = new NumberProcessor();

            Strategy strategy = new ReadingWordsFromConsoleStrategy();
            strategy.setSource(scanner);

            Context context = new Context();
            List<String> strings = context.getInputs(strategy);

            Converter<Long> converter = new LongConverter();
            List<Long> longs = converter.convertToNumbers(strings);

            if (Objects.equals(validSort, NATURAL)) {
                List<Long> sorted = processor.sortAscending(longs);
                System.out.println(longPrinterImpl.printNumberList(sorted));
            } else {
                List<Result<Long>> sorted = processor.sortByCount(longs);
                int size = longs.size();
                System.out.println(longPrinterImpl.printResultList(sorted, size));
            }

        } else if (Objects.equals(validType, WORD)) {
            Processor<String> processor = new StringProcessor();
            Strategy strategy = new ReadingWordsFromConsoleStrategy();
            strategy.setSource(scanner);

            Context context = new Context();
            List<String> strings = context.getInputs(strategy);

            if (Objects.equals(validSort, NATURAL)) {
                List<String> sorted = processor.sortAscending(strings);
                System.out.println(wordPrinterImpl.printWordList(sorted));
            } else {
                List<Result<String>> sorted = processor.sortByCount(strings);
                int size = strings.size();
                System.out.println(wordPrinterImpl.printResultList(sorted, size));
            }

        } else if (Objects.equals(validType, LINE)) {
            Processor<String> processor = new StringProcessor();
            Strategy strategy = new ReadingLinesFromConsoleStrategy();
            strategy.setSource(scanner);

            Context context = new Context();
            List<String> strings = context.getInputs(strategy);

            if (Objects.equals(validSort, NATURAL)) {
                List<String> sorted = processor.sortAscending(strings);
                System.out.println(wordPrinterImpl.printLineList(sorted));
            } else {
                List<Result<String>> sorted = processor.sortByCount(strings);
                int size = strings.size();
                System.out.println(wordPrinterImpl.printResultList(sorted, size));
            }
        }
    }
}
