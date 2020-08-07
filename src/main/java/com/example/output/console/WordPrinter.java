package com.example.output.console;

import java.util.List;

public interface WordPrinter extends ResultPrinter<String>{

    String printWordList(List<String> strings);

    String printLineList(List<String> strings);
}
