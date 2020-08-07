package com.example.input.file;

import com.example.input.Strategy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingLinesFromFileStrategy implements Strategy<File> {

    private File file;

    @Override
    public void setSource(File source) {
        this.file = source;
    }

    @Override
    public List<String> readInputs() {
        List<String> inputs;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            inputs = reader.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("File " + file.getName() + " has not been found");
            return null;
        }
        return inputs;
    }
}
