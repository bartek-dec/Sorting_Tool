package com.example.input;

import java.util.List;

public interface Strategy<T> {

    void setSource(T source);

    List<String> readInputs();
}
