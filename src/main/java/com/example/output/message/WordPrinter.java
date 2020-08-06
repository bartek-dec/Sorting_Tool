package com.example.output.message;

import com.example.output.message.MessagePrinter;

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
