package com.example;

import com.example.data.manipulate.NumberProcessor;
import com.example.data.manipulate.Processor;
import com.example.data.manipulate.StringProcessor;
import com.example.data.result.Result;
import com.example.input.Context;
import com.example.input.Strategy;
import com.example.input.console.ReadingLinesFromConsoleStrategy;
import com.example.input.console.ReadingWordsFromConsoleStrategy;
import com.example.input.file.ReadingLinesFromFileStrategy;
import com.example.input.file.ReadingWordsFromFileStrategy;
import com.example.output.file.FileSaver;
import com.example.output.file.Saver;
import com.example.output.printers.LongPrinter;
import com.example.output.printers.LongPrinterImpl;
import com.example.output.printers.WordPrinter;
import com.example.output.printers.WordPrinterImpl;
import com.example.util.Converter;
import com.example.util.LongConverter;
import com.example.util.Params;
import com.example.util.Validator;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final String INPUT_SOURCE = "./src/main/resources/";
    private static final String OUTPUT_SOURCE = "./src/main/resources/";

    public static void main(String[] args) {
        List<String> parameters = Arrays.asList(args);
        Validator validator = new Validator();

        String validType = validator.checkDataParameters(parameters);
        if (validType == null) {
            return;
        }

        String validSort = validator.checkSortingParameters(parameters);
        if (validSort == null) {
            return;
        }

        String validInputName = validator.checkInputOutputParameters(parameters, Params.INPUT_FILE,
                Params.OUTPUT_FILE, "input");
        if (validInputName != null && !validInputName.matches(Params.MATCHER)) {
            return;
        }

        String validOutputName = validator.checkInputOutputParameters(parameters, Params.OUTPUT_FILE,
                Params.INPUT_FILE, "output");
        if (validOutputName != null && !validOutputName.matches(Params.MATCHER)) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Context context = new Context();
        Converter<Long> longConverter = new LongConverter();
        File inputFile = new File(INPUT_SOURCE + validInputName);
        File outputFile = new File(OUTPUT_SOURCE + validOutputName);
        Processor<Long> longProcessor = new NumberProcessor();
        Processor<String> stringProcessor = new StringProcessor();
        LongPrinter longPrinter = new LongPrinterImpl();
        WordPrinter wordPrinter = new WordPrinterImpl();
        Saver saver = new FileSaver();

        boolean isValidType = Objects.equals(validType, Params.LONG) ||
                Objects.equals(validType, Params.WORD) ||
                Objects.equals(validType, Params.LINE);

        List<String> words;
        List<Long> numbers;
        String result;
        Strategy<Scanner> scannerStrategy;
        Strategy<File> fileStrategy;

        if (isValidType && validInputName == null) {
            scannerStrategy = new ReadingWordsFromConsoleStrategy();
            scannerStrategy.setSource(scanner);

            if (Objects.equals(validType, Params.LONG)) {
                words = context.getInputs(scannerStrategy);
                numbers = longConverter.convertToNumbers(words);

                if (Objects.equals(validSort, Params.NATURAL)) {
                    result = processNumbersNatural(longProcessor, longPrinter, numbers);
                } else {
                    result = processNumbersByCount(longProcessor, longPrinter, numbers, "numbers");
                }
            } else if (Objects.equals(validType, Params.WORD)) {
                words = context.getInputs(scannerStrategy);
                if (Objects.equals(validSort, Params.NATURAL)) {
                    result = processStringsNatural(stringProcessor, wordPrinter, words);
                } else {
                    result = processStringsByCount(stringProcessor, wordPrinter, words, "words");
                }
            } else {
                scannerStrategy = new ReadingLinesFromConsoleStrategy();
                scannerStrategy.setSource(scanner);
                words = context.getInputs(scannerStrategy);

                if (Objects.equals(validSort, Params.NATURAL)) {
                    result = processStringsNatural(stringProcessor, wordPrinter, words);
                } else {
                    result = processStringsByCount(stringProcessor, wordPrinter, words, "lines");
                }
            }
            saveResult(validOutputName, outputFile, saver, result);

        } else if (isValidType && validInputName != null) {
            fileStrategy = new ReadingWordsFromFileStrategy();
            fileStrategy.setSource(inputFile);

            if (Objects.equals(validType, Params.LONG)) {
                words = context.getInputs(fileStrategy);
                numbers = longConverter.convertToNumbers(words);

                if (Objects.equals(validSort, Params.NATURAL)) {
                    result = processNumbersNatural(longProcessor, longPrinter, numbers);
                } else {
                    result = processNumbersByCount(longProcessor, longPrinter, numbers, "numbers");
                }
            } else if (Objects.equals(validType, Params.WORD)) {
                words = context.getInputs(fileStrategy);
                if (Objects.equals(validSort, Params.NATURAL)) {
                    result = processStringsNatural(stringProcessor, wordPrinter, words);
                } else {
                    result = processStringsByCount(stringProcessor, wordPrinter, words, "words");
                }
            } else {
                fileStrategy = new ReadingLinesFromFileStrategy();
                fileStrategy.setSource(inputFile);
                words = context.getInputs(fileStrategy);

                if (Objects.equals(validSort, Params.NATURAL)) {
                    result = processStringsNatural(stringProcessor, wordPrinter, words);
                } else {
                    result = processStringsByCount(stringProcessor, wordPrinter, words, "lines");
                }
            }
            saveResult(validOutputName, outputFile, saver, result);
        }
    }

    private static String processNumbersByCount(Processor<Long> longProcessor, LongPrinter longPrinter,
                                                List<Long> numbers, String name) {
        List<Result<Long>> longResults;
        String result;
        longResults = longProcessor.sortByCount(numbers);
        result = longPrinter.printResultList(longResults, numbers.size(), name);
        return result;
    }

    private static String processNumbersNatural(Processor<Long> longProcessor, LongPrinter longPrinter,
                                                List<Long> numbers) {
        List<Long> sortedNumbers;
        String result;
        sortedNumbers = longProcessor.sortAscending(numbers);
        result = longPrinter.printNumberList(sortedNumbers);
        return result;
    }

    private static String processStringsNatural(Processor<String> stringProcessor, WordPrinter wordPrinter,
                                                List<String> words) {
        List<String> sortedStrings;
        String result;
        sortedStrings = stringProcessor.sortAscending(words);
        result = wordPrinter.printWordList(sortedStrings);
        return result;
    }

    private static String processStringsByCount(Processor<String> stringProcessor, WordPrinter wordPrinter,
                                                List<String> words, String name) {
        List<Result<String>> stringResults;
        String result;
        stringResults = stringProcessor.sortByCount(words);
        result = wordPrinter.printResultList(stringResults, words.size(), name);
        return result;
    }

    private static void saveResult(String validOutputName, File outputFile, Saver saver, String result) {
        if (validOutputName == null) {
            System.out.println(result);
        } else {
            saver.saveToFile(outputFile, result);
        }
    }
}
