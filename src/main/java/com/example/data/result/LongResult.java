package com.example.data.result;

import java.util.Objects;

public class LongResult implements Result<Long> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongResult result = (LongResult) o;
        return count == result.count &&
                percentage == result.percentage &&
                entry.equals(result.entry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entry, count, percentage);
    }
}
