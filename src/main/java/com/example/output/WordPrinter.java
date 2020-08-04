package com.example.output;

public class WordPrinter implements MessagePrinter {

    @Override
    public String printMessage(long total, String greatest, long quantity, int percentage) {
        StringBuilder builder = new StringBuilder();

        builder.append("Total words: ").append(total).append(".\n");
        builder.append("The longest word: ").append(greatest);
        builder.append(" (").append(quantity).append(" time(s), ").append(percentage).append("%).\n");

        return builder.toString();
    }
}
