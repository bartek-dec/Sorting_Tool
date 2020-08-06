package com.example.data;

import com.example.IntResult;
import com.example.Result;

import java.util.*;
import java.util.stream.Collectors;

public class NumberProcessor implements Processor<Integer> {

    @Override
    public Long countInputs(List<Integer> inputs) {
        return inputs.stream().count();
    }

    @Override
    public Integer getGreatest(List<Integer> inputs) {
        Optional<Integer> optional = inputs.stream()
                .max(Comparator.naturalOrder());

        return optional.orElse(null);
    }

    @Override
    public Long getQuantity(List<Integer> inputs, Integer itemToFind) {
        return inputs.stream()
                .filter(o -> o == itemToFind.intValue())
                .count();
    }

    @Override
    public Integer getPercentage(long quantity, long totalNum) {
        double percentage = ((1.0 * quantity) / totalNum) * 100;

        return (int) Math.round(percentage);
    }

    @Override
    public List<Integer> sortAscending(List<Integer> inputs) {
        List<Integer> integers = inputs.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return integers;
    }

    @Override
    public List<Result<Integer>> sortByCount(List<Integer> inputs) {
        List<Integer> sortedAndUnique = inputs.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<Result<Integer>> results = new ArrayList<>();
        int size = sortedAndUnique.size();
        int totalNumber = inputs.size();
        for (int i = 0; i < size; i++) {
            Result<Integer> result = new IntResult();

            int current = sortedAndUnique.get(i);
            long count = getQuantity(inputs, current);
            int percentage = getPercentage(count, totalNumber);

            result.setEntry(current);
            result.setCount(count);
            result.setPercentage(percentage);
            results.add(result);
        }

        return results.stream()
                .sorted(Comparator.comparingInt(o -> o.getEntry()))
                .sorted(Comparator.comparingLong(o -> o.getCount()))
                .collect(Collectors.toList());
    }
}
