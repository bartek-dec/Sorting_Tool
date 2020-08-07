package com.example.output.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver implements Saver {

    @Override
    public void saveToFile(File file, String stringToSave) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(stringToSave);
        } catch (IOException e) {
            System.out.println("Results have not been saved successfully");
        }
    }
}
