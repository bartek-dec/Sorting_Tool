package com.example.data.result;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringResult that = (StringResult) o;
        return count == that.count &&
                percentage == that.percentage &&
                entry.equals(that.entry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entry, count, percentage);
    }
}
