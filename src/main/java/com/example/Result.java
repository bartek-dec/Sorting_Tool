package com.example;

public interface Result<T> {

    T getEntry();

    void setEntry(T entry);

    long getCount();

    void setCount(long count);

    int getPercentage();

    void setPercentage(int percentage);
}
