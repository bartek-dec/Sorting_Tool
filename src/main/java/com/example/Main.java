package com.example;

import com.example.data.DataProcessor;
import com.example.data.Processor;
import com.example.output.ListPrinter;
import com.example.output.ListPrinterImpl;
import com.example.output.MessagePrinter;
import com.example.output.factory.PrinterFactory;
import com.example.strategy.factory.ReadingStrategyFactory;
import com.example.strategy.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Context context = new Context();
        Processor processor = new DataProcessor();
        ReadingStrategyFactory strategyFactory = new ReadingStrategyFactory();
        PrinterFactory printerFactory = new PrinterFactory();
        List<Object> inputs;
        String parameter;
        boolean isSort = false;

        if (Arrays.asList(args).contains("-sortIntegers")) {
            isSort = true;
            parameter = "long";
        } else {
            parameter = args[1];
        }

        ReadingStrategy strategy = strategyFactory.getStrategy(parameter);
        strategy.setScanner(scanner);
        inputs = context.getInputs(strategy);

        if (isSort) {
            List<Integer> integers = processor.sortAscending(inputs);
            ListPrinter printer = new ListPrinterImpl();
            System.out.println(printer.printList(integers));
        } else {
            MessagePrinter messagePrinter = printerFactory.getPrinter(parameter);

            long totalNumber = processor.countInputs(inputs);
            Long quantity;
            int percentage;

            if (Objects.equals(parameter, "long")) {
                int greatest = processor.getGreatest(inputs);
                quantity = processor.getQuantity(inputs, greatest);
                percentage = processor.getPercentage(quantity, totalNumber);

                System.out.println(messagePrinter.printMessage(totalNumber, Integer.toString(greatest), quantity, percentage));
            } else {
                String longest = processor.getLongest(inputs);
                quantity = processor.getQuantity(inputs, longest);
                percentage = processor.getPercentage(quantity, totalNumber);

                System.out.println(messagePrinter.printMessage(totalNumber, longest, quantity, percentage));
            }
        }
    }
}
