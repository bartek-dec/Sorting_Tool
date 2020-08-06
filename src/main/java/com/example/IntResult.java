package com.example;

public class IntResult implements Result<Integer> {

    private Integer entry;
    private long count;
    private int percentage;

    @Override
    public Integer getEntry() {
        return entry;
    }

    @Override
    public void setEntry(Integer entry) {
        this.entry = entry;
    }

    @Override
    public long getCount() {
        return count;
    }

    @Override
    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public int getPercentage() {
        return percentage;
    }

    @Override
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
