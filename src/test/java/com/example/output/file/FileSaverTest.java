package com.example.output.file;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class FileSaverTest {

    private Saver saver;
    private File file;

    @BeforeEach
    void setUp() throws IOException {
        saver = new FileSaver();
        file = File.createTempFile("testFile", "tmp");
        file.deleteOnExit();
    }

    @AfterEach
    void cleanUp() {
        file.delete();
    }

    @Test
    void saveToFile() throws IOException {
        StringBuilder builder = new StringBuilder();

        builder.append("Total ").append("numbers").append(": ");
        builder.append(3).append(".\n");
        builder.append("2: 2 time(s), 50%\n");
        builder.append("5: 1 time(s), 25%\n");
        builder.append("8: 1 time(s), 25%");

        String expected = builder.toString();

        saver.saveToFile(file,expected);
        assertEquals(expected, new String(Files.readAllBytes(file.toPath())));
    }
}