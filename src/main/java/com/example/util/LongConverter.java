package com.example.util;

import java.util.ArrayList;
import java.util.List;

public class LongConverter implements Converter<Long> {

    @Override
    public List<Long> convertToNumbers(List<String> list) {
        if (list == null) {
            return null;
        }

        List<Long> longs = new ArrayList<>();
        for (String s : list) {
            try {
                long number = Long.parseLong(s);
                longs.add(number);
            } catch (NumberFormatException e) {
                System.out.println(s + " isn't a long. It's skipped");
            }
        }
        return longs;
    }
}
