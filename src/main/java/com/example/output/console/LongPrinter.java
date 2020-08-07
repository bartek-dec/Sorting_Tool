package com.example.output.console;

import java.util.List;

public interface LongPrinter extends ResultPrinter<Long>{

    String printNumberList(List<Long> integers);
}
