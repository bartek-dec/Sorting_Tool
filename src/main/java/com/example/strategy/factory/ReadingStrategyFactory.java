package com.example.strategy.factory;

import com.example.strategy.ReadingIntegersStrategy;
import com.example.strategy.ReadingLinesStrategy;
import com.example.strategy.ReadingStrategy;
import com.example.strategy.ReadingWordsStrategy;

public class ReadingStrategyFactory {

    public ReadingStrategy getStrategy(String strategy) {
        if (strategy == null) {
            return null;
        }

        switch (strategy) {
            case "long":
                return new ReadingIntegersStrategy();
            case "line":
                return new ReadingLinesStrategy();
            case "word":
                return new ReadingWordsStrategy();
            default:
                return null;
        }
    }
}
