package com.example.data;

import com.example.IntResult;
import com.example.Result;

import java.util.*;
import java.util.stream.Collectors;

public class NumberProcessor implements Processor<Long> {

    @Override
    public Long countInputs(List<Long> inputs) {
        return inputs.stream().count();
    }

    @Override
    public Long getGreatest(List<Long> inputs) {
        Optional<Long> optional = inputs.stream()
                .max(Comparator.naturalOrder());

        return optional.orElse(null);
    }

    @Override
    public Long getQuantity(List<Long> inputs, Long itemToFind) {
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
    public List<Long> sortAscending(List<Long> inputs) {
        List<Long> integers = inputs.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return integers;
    }

    @Override
    public List<Result<Long>> sortByCount(List<Long> inputs) {
        List<Long> sortedAndUnique = inputs.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<Result<Long>> results = new ArrayList<>();
        int size = sortedAndUnique.size();
        int totalNumber = inputs.size();
        for (int i = 0; i < size; i++) {
            Result<Long> result = new IntResult();

            long current = sortedAndUnique.get(i);
            long count = getQuantity(inputs, current);
            int percentage = getPercentage(count, totalNumber);

            result.setEntry(current);
            result.setCount(count);
            result.setPercentage(percentage);
            results.add(result);
        }

        return results.stream()
                .sorted(Comparator.comparingLong(o -> o.getEntry()))
                .sorted(Comparator.comparingLong(o -> o.getCount()))
                .collect(Collectors.toList());
    }
}
