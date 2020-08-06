package com.example.strategy;

import java.util.List;

public class Context<T> {

    private ReadingStrategy<T> strategy;

    public void setStrategy(ReadingStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public List<T> getInputs() {
        return strategy.readInputs();
    }
}
