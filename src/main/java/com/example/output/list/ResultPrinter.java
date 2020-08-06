package com.example.output.list;

import com.example.Result;

import java.util.List;

public interface ResultPrinter<T> {

    String printResultList(List<Result<T>> results, int quantity);
}
