package com.example.data.result;

public class StringResult implements Result<String> {

    private String entry;
    private long count;
    private int percentage;

    @Override
    public String getEntry() {
        return entry;
    }

    @Override
    public void setEntry(String entry) {
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
