package com.example.output;

import java.util.List;

public class ListPrinterImpl implements ListPrinter {

    @Override
    public String printList(List<Integer> integers) {
        if (integers == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        builder.append("Total numbers: ");
        builder.append(integers.size()).append(".\n");
        builder.append("Sorted data:");

        integers.stream().forEach(o -> builder.append(" " + o));

        return builder.toString();
    }
}
