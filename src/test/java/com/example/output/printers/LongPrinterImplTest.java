package com.example.output.printers;

import com.example.data.result.LongResult;
import com.example.data.result.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongPrinterImplTest {

    private LongPrinter longPrinter;
    private List<Long> numbers;
    private List<Result<Long>> results;

    @BeforeEach
    void setUp() {
        longPrinter = new LongPrinterImpl();
        numbers = Arrays.asList(2L, 5L, 8L);

        results = new ArrayList<>();
        Result<Long> result1 = new LongResult();
        result1.setEntry(2L);
        result1.setCount(2);
        result1.setPercentage(50);

        Result<Long> result2 = new LongResult();
        result2.setEntry(5L);
        result2.setCount(1);
        result2.setPercentage(25);

        Result<Long> result3 = new LongResult();
        result3.setEntry(8L);
        result3.setCount(1);
        result3.setPercentage(25);

        results.add(result1);
        results.add(result2);
        results.add(result3);
    }

    @Test
    void printNumberList() {
        StringBuilder builder = new StringBuilder();

        builder.append("Total numbers: ");
        builder.append(numbers.size()).append("\n");
        builder.append("Sorted data:").append(" 2").append(" 5").append(" 8");

        String expected = builder.toString();
        assertEquals(expected, longPrinter.printNumberList(numbers));
    }

    @Test
    void printNumberList_ExpectedNull_WhenInputNull() {
        assertNull(longPrinter.printNumberList(null));
    }

    @Test
    void printResultList() {
        StringBuilder builder = new StringBuilder();

        builder.append("Total ").append("numbers").append(": ");
        builder.append(3).append(".\n");
        builder.append("2: 2 time(s), 50%\n");
        builder.append("5: 1 time(s), 25%\n");
        builder.append("8: 1 time(s), 25%");

        String expected = builder.toString();
        assertEquals(expected, longPrinter.printResultList(results, 3, "numbers"));
    }

    @Test
    void printResultList_ExpectedNull_WhenInputNull() {
        assertNull(longPrinter.printResultList(null, 3, "numbers"));
    }
}