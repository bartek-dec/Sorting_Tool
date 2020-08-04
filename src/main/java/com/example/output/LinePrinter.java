package com.example.output;

public class LinePrinter implements MessagePrinter {

    @Override
    public String printMessage(long total, String greatest, long quantity, int percentage) {
        StringBuilder builder = new StringBuilder();

        builder.append("Total lines: ").append(total).append(".\n");
        builder.append("The longest line: \n");
        builder.append(greatest).append("\n");
        builder.append("(").append(quantity).append(" time(s), ").append(percentage).append("%).\n");

        return builder.toString();
    }
}
