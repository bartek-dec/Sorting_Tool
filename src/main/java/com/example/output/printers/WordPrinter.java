package com.example.output.printers;

import java.util.List;

public interface WordPrinter extends ResultPrinter<String>{

    String printWordList(List<String> strings);

    String printLineList(List<String> strings);
}
