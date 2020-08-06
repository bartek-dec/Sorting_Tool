package com.example.output.list;

import com.example.Result;

import java.util.List;

public class WordPrinter implements StringPrinter, ResultPrinter<String> {

    @Override
    public String printResultList(List<Result<String>> results, int quantity) {
        if (results == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        builder.append("Total words: ");
        builder.append(quantity).append(".\n");

        results.stream()
                .forEach(o -> builder.append(o.getEntry()).append(": ")
                        .append(o.getCount()).append(" time(s), ").append(o.getPercentage()).append("%\n"));

        return builder.toString();
    }

    @Override
    public String printWordList(List<String> strings) {
        if (strings == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        builder.append("Total words: ");
        builder.append(strings.size()).append("\n");
        builder.append("Sorted data:");

        strings.stream().forEach(o -> builder.append(" " + o));

        return builder.toString();
    }

    @Override
    public String printLineList(List<String> strings) {
        if (strings == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        builder.append("Total lines: ");
        builder.append(strings.size()).append("\n");
        builder.append("Sorted data:\n");

        strings.stream().forEach(o -> builder.append(o + "\n"));

        return builder.toString();
    }
}
