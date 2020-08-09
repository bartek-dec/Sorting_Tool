package com.example.input.console;

import com.example.input.Strategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ReadingWordsFromConsoleStrategyTest {

    private Strategy<Scanner> strategy;
    private Scanner scanner;
    private List<String> expected;

    @BeforeEach
    void setUp() {
        strategy = new ReadingWordsFromConsoleStrategy();

        String input = "3 44 333   1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        scanner = new Scanner(System.in);
        strategy.setSource(scanner);

        expected = Arrays.asList("3", "44", "333", "1");
    }

    @Test
    void readInputs() {
        assertEquals(expected, strategy.readInputs());
    }
}