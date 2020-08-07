package com.example.util;

import java.util.List;

public interface Converter<T> {

    List<T> convertToNumbers(List<String> list);
}
