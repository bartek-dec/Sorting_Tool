package com.example.data.manipulate;

import com.example.data.result.Result;
import com.example.data.result.StringResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringProcessorTest {

    private Processor<String> processor;
    private List<String> strings;
    private List<Result<String>> results;

    @BeforeEach
    void setUp() {
        processor = new StringProcessor();
        strings = Arrays.asList("2", "1", "1", "9", "7");

        results = new ArrayList<>();
        Result<String> result1 = new StringResult();
        result1.setEntry("2");
        result1.setCount(1);
        result1.setPercentage(20);

        Result<String> result2 = new StringResult();
        result2.setEntry("7");
        result2.setCount(1);
        result2.setPercentage(20);

        Result<String> result3 = new StringResult();
        result3.setEntry("9");
        result3.setCount(1);
        result3.setPercentage(20);

        Result<String> result4 = new StringResult();
        result4.setEntry("1");
        result4.setCount(2);
        result4.setPercentage(40);

        results.add(result1);
        results.add(result2);
        results.add(result3);
        results.add(result4);
    }

    @Test
    void getQuantity() {
        assertEquals(2L, processor.getQuantity(strings, "1"));
    }

    @Test
    void getPercentage() {
        assertEquals(40, processor.getPercentage(2, 5));
    }

    @Test
    void sortAscending() {
        List<String> expected = Arrays.asList("1", "1", "2", "7", "9");
        assertEquals(expected, processor.sortAscending(strings));
    }

    @Test
    void sortByCount() {
        assertEquals(results, processor.sortByCount(strings));
    }
}