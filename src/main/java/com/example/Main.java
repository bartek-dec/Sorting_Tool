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

        WordPrinterImpl wordPrinterImpl = new WordPrinterImpl();
        if (Objects.equals(validType, "long")) {
            LongPrinter longPrinterImpl = new LongPrinterImpl();
            Processor<Long> processor = new NumberProcessor();

            Strategy strategy = new ReadingWordsFromConsoleStrategy();
            strategy.setSource(scanner);

            Context context = new Context();
            List<String> strings = context.getInputs(strategy);

            Converter<Long> converter = new LongConverter();
            List<Long> longs = converter.convertToNumbers(strings);

            if (Objects.equals(validSort, "natural")) {
                List<Long> sorted = processor.sortAscending(longs);
                System.out.println(longPrinterImpl.printNumberList(sorted));
            } else {
                List<Result<Long>> sorted = processor.sortByCount(longs);
                int size = longs.size();
                System.out.println(longPrinterImpl.printResultList(sorted, size));
            }

        } else if (Objects.equals(validType, "word")) {
            Processor<String> processor = new StringProcessor();
            Strategy strategy = new ReadingWordsFromConsoleStrategy();
            strategy.setSource(scanner);

            Context context = new Context();
            List<String> strings = context.getInputs(strategy);

            if (Objects.equals(validSort, "natural")) {
                List<String> sorted = processor.sortAscending(strings);
                System.out.println(wordPrinterImpl.printWordList(sorted));
            } else {
                List<Result<String>> sorted = processor.sortByCount(strings);
                int size = strings.size();
                System.out.println(wordPrinterImpl.printResultList(sorted, size));
            }

        } else if (Objects.equals(validType, "line")) {
            Processor<String> processor = new StringProcessor();
            Strategy strategy = new ReadingLinesFromConsoleStrategy();
            strategy.setSource(scanner);

            Context context = new Context();
            List<String> strings = context.getInputs(strategy);

            if (Objects.equals(validSort, "natural")) {
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
