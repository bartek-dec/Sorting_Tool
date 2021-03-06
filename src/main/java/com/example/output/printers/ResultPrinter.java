package com.example.output.printers;

import com.example.data.result.Result;
import com.example.input.Strategy;

import java.util.List;

public interface ResultPrinter<T> {

    String printResultList(List<Result<T>> results, int quantity, String name);
}
