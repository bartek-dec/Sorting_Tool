package com.example.data.manipulate;

import com.example.data.result.LongResult;
import com.example.data.result.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberProcessorTest {

    private Processor<Long> processor;
    private List<Long> numbers;
    private List<Result<Long>> results;

    @BeforeEach
    void setUp() {
        processor = new NumberProcessor();
        numbers = Arrays.asList(2L, 1L, 1L, 9L, 7L);

        results = new ArrayList<>();
        Result<Long> result1 = new LongResult();
        result1.setEntry(2L);
        result1.setCount(1);
        result1.setPercentage(20);

        Result<Long> result2 = new LongResult();
        result2.setEntry(7L);
        result2.setCount(1);
        result2.setPercentage(20);

        Result<Long> result3 = new LongResult();
        result3.setEntry(9L);
        result3.setCount(1);
        result3.setPercentage(20);

        Result<Long> result4 = new LongResult();
        result4.setEntry(1L);
        result4.setCount(2);
        result4.setPercentage(40);

        results.add(result1);
        results.add(result2);
        results.add(result3);
        results.add(result4);
    }

    @Test
    void getQuantity() {
        assertEquals(2L, processor.getQuantity(numbers, 1L));
    }

    @Test
    void getPercentage() {
        assertEquals(40, processor.getPercentage(2, 5));
    }

    @Test
    void sortAscending() {
        List<Long> expected = Arrays.asList(1L, 1L, 2L, 7L, 9L);
        assertEquals(expected, processor.sortAscending(numbers));
    }

    @Test
    void sortByCount() {
        assertEquals(results, processor.sortByCount(numbers));
    }
}