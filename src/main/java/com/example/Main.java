package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputReader reader = new UserInputReader(scanner);

        List<Integer> integers = reader.readIntegers();

        long totalNumber = integers.stream().count();
        int greatest = integers.stream().max(Comparator.naturalOrder()).get();
        long quantity = integers.stream().filter(o -> o == greatest).count();

        System.out.println("Total numbers: " + totalNumber + ".");
        System.out.println("The greatest number: " + greatest + " (" + quantity + " time(s)).");
    }
}
