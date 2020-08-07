package com.example.data.result;

public class IntResult implements Result<Long> {

    private Long entry;
    private long count;
    private int percentage;

    @Override
    public Long getEntry() {
        return entry;
    }

    @Override
    public void setEntry(Long entry) {
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
