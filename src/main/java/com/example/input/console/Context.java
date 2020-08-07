package com.example.input.console;

import java.util.List;

public class Context {

    public List<String> getInputs(Strategy strategy) {
        return strategy.readInputs();
    }
}
