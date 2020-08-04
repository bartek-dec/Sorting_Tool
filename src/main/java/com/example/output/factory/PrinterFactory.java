package com.example.output.factory;

import com.example.output.IntegerPrinter;
import com.example.output.LinePrinter;
import com.example.output.MessagePrinter;
import com.example.output.WordPrinter;

public class PrinterFactory {

    public MessagePrinter getPrinter(String type) {
        if (type == null) {
            return null;
        }

        switch (type) {
            case "long":
                return new IntegerPrinter();
            case "line":
                return new LinePrinter();
            case "word":
                return new WordPrinter();
            default:
                return null;
        }
    }
}
