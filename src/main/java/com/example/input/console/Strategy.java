package com.example.input.console;

import java.util.List;
import java.util.Scanner;

public interface Strategy{

    void setScanner(Scanner scanner);

    List<String> readInputs();
}
