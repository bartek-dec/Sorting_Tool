package com.example.input.file;

import com.example.input.Strategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadingWordsFromFileStrategyTest {

    private final String path = "./src/test/resources/input.txt";
    private Strategy<File> strategy;
    private File file;
    private List<String> expected;

    @BeforeEach
    void setUp() {
        strategy = new ReadingWordsFromFileStrategy();
        file = new File(path);
        strategy.setSource(file);

        expected = Arrays.asList("1", "-2", "333", "4", "42", "1", "1");
    }


    @Test
    void readInputs() {
        assertEquals(expected, strategy.readInputs());
    }
}