package com.example.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongConverterTest {

    private Converter<Long> longConverter;
    private List<String> inputs;
    private List<Long> output;

    @BeforeEach
    void setUp() {
        longConverter = new LongConverter();
        inputs = Arrays.asList("1", "a", "9", "12", "5");
        output = Arrays.asList(1L, 9L, 12L, 5L);
    }

    @Test
    void convertToNumbers() {
        assertEquals(output, longConverter.convertToNumbers(inputs));
    }

    @Test
    void convertToNumbers_ExpectNull_WhenInputNull() {
        assertNull(longConverter.convertToNumbers(null));
    }
}