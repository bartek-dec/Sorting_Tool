package com.example.data;

import com.example.Result;
import com.example.StringResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringProcessor implements Processor<String> {

    @Override
    public Long countInputs(List<String> inputs) {
        return inputs.stream().count();
    }

    @Override
    public String getGreatest(List<String> inputs) {
        Optional<String> optionalLongest = inputs.stream()
                .max(Comparator.comparingInt(String::length));

        String longest;
        int length;
        if (optionalLongest.isPresent()) {
            longest = optionalLongest.get();
            length = longest.length();
        } else {
            return null;
        }

        Optional<String> optionalLargest = inputs.stream()
                .filter(o -> o.length() == length)
                .max(Comparator.naturalOrder());

        return optionalLargest.orElse(null);
    }

    @Override
    public Long getQuantity(List<String> inputs, String itemToFind) {
        return inputs.stream()
                .filter(o -> o.equals(itemToFind))
                .count();
    }

    @Override
    public Integer getPercentage(long quantity, long totalNum) {
        double percentage = ((1.0 * quantity) / totalNum) * 100;

        return (int) Math.round(percentage);
    }

    @Override
    public List<String> sortAscending(List<String> inputs) {
        List<String> words = inputs.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return words;
    }

    @Override
    public List<Result<String>> sortByCount(List<String> inputs) {
        List<String> sortedAndUnique = inputs.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<Result<String>> results = new ArrayList<>();
        int size = sortedAndUnique.size();
        int totalNumber = inputs.size();
        for (int i = 0; i < size; i++) {
            Result<String> result = new StringResult();

            String current = sortedAndUnique.get(i);
            long count = getQuantity(inputs, current);
            int percentage = getPercentage(count, totalNumber);

            result.setEntry(current);
            result.setCount(count);
            result.setPercentage(percentage);
            results.add(result);
        }

        return results.stream()
                .sorted(Comparator.comparing(Result::getEntry))
                .sorted(Comparator.comparingLong(Result::getCount))
                .collect(Collectors.toList());
    }
}
