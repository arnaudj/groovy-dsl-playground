package com.github.arnaudj.robot

class Distance {
    final Number length
    final String unit

    Distance(Number length, String unit) {
        this.length = length
        this.unit = unit
    }

    @Override
    String toString() {
        return length + unit
    }
}
