package com.example.output.file;

import java.io.File;

public interface Saver {

    void saveToFile(File file, String stringToSave);
}
