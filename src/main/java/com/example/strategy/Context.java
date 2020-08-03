package com.example.strategy;

import java.util.List;

public class Context {

    public List<Object> getInputs(ReadingStrategy strategy) {
        return strategy.readInputs();
    }
}
