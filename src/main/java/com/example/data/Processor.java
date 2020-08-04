package com.example.data;

import java.util.List;

public interface Processor {

    Long countInputs(List<Object> inputs);

    Integer getGreatest(List<Object> inputs);

    String getLongest(List<Object> inputs);

    Long getQuantity(List<Object> inputs, int numToFind);

    Long getQuantity(List<Object> inputs, String wordToFind);

    Integer getPercentage(long quantity, long totalNum);

    List<Integer> sortAscending(List<Object> inputs);
}
