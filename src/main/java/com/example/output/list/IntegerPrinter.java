package com.example.output.list;

import com.example.Result;

import java.util.List;

public class IntegerPrinter implements IntPrinter, ResultPrinter<Long> {

    @Override
    public String printIntegerList(List<Long> integers) {
        if (integers == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        builder.append("Total numbers: ");
        builder.append(integers.size()).append("\n");
        builder.append("Sorted data:");

        integers.stream().forEach(o -> builder.append(" " + o));

        return builder.toString();
    }

    @Override
    public String printResultList(List<Result<Long>> results, int quantity) {
        if (results == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        builder.append("Total numbers: ");
        builder.append(quantity).append(".\n");

        results.stream()
                .forEach(o -> builder.append(o.getEntry()).append(": ")
                        .append(o.getCount()).append(" time(s), ").append(o.getPercentage()).append("%\n"));

        return builder.toString();
    }
}
