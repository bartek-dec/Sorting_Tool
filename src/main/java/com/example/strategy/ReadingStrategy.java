package com.example.strategy;

import java.util.List;
import java.util.Scanner;

public interface ReadingStrategy <T>{

    void setScanner(Scanner scanner);

    List<T> readInputs();
}
