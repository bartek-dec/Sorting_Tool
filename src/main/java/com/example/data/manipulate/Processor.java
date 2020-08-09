package com.example.data.manipulate;

import com.example.data.result.Result;

import java.util.List;

public interface Processor<T> {

    Long getQuantity(List<T> inputs, T itemToFind);

    Integer getPercentage(long quantity, long totalNum);

    List<T> sortAscending(List<T> inputs);

    List<Result<T>> sortByCount(List<T> inputs);
}
