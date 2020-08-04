package com.example.data;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataProcessor implements Processor {

    @Override
    public Long countInputs(List<Object> inputs) {
        return inputs.stream().count();
    }

    @Override
    public Integer getGreatest(List<Object> inputs) {
        Optional<Integer> optional = inputs.stream()
                .map(o -> (Integer) o)
                .max(Comparator.naturalOrder());

        return optional.orElse(null);
    }

    @Override
    public String getLongest(List<Object> inputs) {
        Optional<String> optionalLongest = inputs.stream()
                .map(o -> (String) o)
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
                .map(o -> (String) o)
                .filter(o -> o.length() == length)
                .max(Comparator.naturalOrder());

        return optionalLargest.orElse(null);
    }

    @Override
    public Long getQuantity(List<Object> inputs, int numToFind) {
        return inputs.stream()
                .map(o -> (Integer) o)
                .filter(o -> o == numToFind)
                .count();
    }

    @Override
    public Long getQuantity(List<Object> inputs, String wordToFind) {
        return inputs.stream()
                .map(o -> (String) o)
                .filter(o -> o.equals(wordToFind))
                .count();
    }

    @Override
    public Integer getPercentage(long quantity, long totalNum) {
        double percentage = ((1.0 * quantity) / totalNum) * 100;
        return (int) percentage;
    }

    @Override
    public List<Integer> sortAscending(List<Object> inputs) {
        List<Integer> integers = inputs.stream()
                .map(o -> (Integer) o)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return integers;
    }
}
