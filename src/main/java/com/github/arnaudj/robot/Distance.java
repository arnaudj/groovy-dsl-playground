package com.github.arnaudj.robot;

public class Distance {
    final Number length;
    final String unit;

    public Distance(Number length, String unit) {
        this.length = length;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return length + unit;
    }
}
