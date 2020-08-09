package com.example.output.printers;

import com.example.data.result.LongResult;
import com.example.data.result.Result;
import com.example.data.result.StringResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordPrinterImplTest {

    private WordPrinter stringPrinter;
    private List<String> strings;
    private List<Result<String>> results;

    @BeforeEach
    void setUp() {
        stringPrinter = new WordPrinterImpl();
        strings = Arrays.asList("2", "5", "8");

        results = new ArrayList<>();
        Result<String> result1 = new StringResult();
        result1.setEntry("2");
        result1.setCount(2);
        result1.setPercentage(50);

        Result<String> result2 = new StringResult();
        result2.setEntry("5");
        result2.setCount(1);
        result2.setPercentage(25);

        Result<String> result3 = new StringResult();
        result3.setEntry("8");
        result3.setCount(1);
        result3.setPercentage(25);

        results.add(result1);
        results.add(result2);
        results.add(result3);
    }

    @Test
    void printResultList_WithWords() {
        StringBuilder builder = new StringBuilder();

        builder.append("Total ").append("words").append(": ");
        builder.append(3).append(".\n");
        builder.append("2: 2 time(s), 50%\n");
        builder.append("5: 1 time(s), 25%\n");
        builder.append("8: 1 time(s), 25%");

        String expected = builder.toString();
        assertEquals(expected, stringPrinter.printResultList(results, 3, "words"));
    }

    @Test
    void printResultList_WithLines() {
        StringBuilder builder = new StringBuilder();

        builder.append("Total ").append("lines").append(": ");
        builder.append(3).append(".\n");
        builder.append("2: 2 time(s), 50%\n");
        builder.append("5: 1 time(s), 25%\n");
        builder.append("8: 1 time(s), 25%");

        String expected = builder.toString();
        assertEquals(expected, stringPrinter.printResultList(results, 3, "lines"));
    }

    @Test
    void printResultList_ExpectedNull_WhenInputNull() {
        assertNull(stringPrinter.printResultList(null, 3, "words"));
    }

    @Test
    void printWordList() {
        StringBuilder builder = new StringBuilder();

        builder.append("Total words: ");
        builder.append(strings.size()).append("\n");
        builder.append("Sorted data:").append(" 2").append(" 5").append(" 8");

        String expected = builder.toString();
        assertEquals(expected, stringPrinter.printWordList(strings));
    }

    @Test
    void printWordList_ExpectedNull_WhenInputNull() {
        assertNull(stringPrinter.printWordList(null));
    }

    @Test
    void printLineList() {
        StringBuilder builder = new StringBuilder();

        builder.append("Total lines: ");
        builder.append(strings.size()).append("\n");
        builder.append("Sorted data:\n").append("2\n").append("5\n").append("8");

        String expected = builder.toString();
        assertEquals(expected, stringPrinter.printLineList(strings));
    }

    @Test
    void printLineList_ExpectedNull_WhenInputNull() {
        assertNull(stringPrinter.printLineList(null));
    }
}