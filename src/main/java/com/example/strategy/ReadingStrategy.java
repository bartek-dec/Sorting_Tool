package com.example.strategy;

import java.util.List;
import java.util.Scanner;

public interface ReadingStrategy {

    void setScanner(Scanner scanner);

    List<Object> readInputs();
}
