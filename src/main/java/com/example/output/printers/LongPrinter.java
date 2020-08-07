package com.example.output.printers;

import java.util.List;

public interface LongPrinter extends ResultPrinter<Long>{

    String printNumberList(List<Long> integers);
}
