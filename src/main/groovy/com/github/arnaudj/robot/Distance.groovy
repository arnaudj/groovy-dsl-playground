package com.github.arnaudj.robot

import groovy.transform.TupleConstructor

@TupleConstructor
class Distance {
    Number length
    String unit

    @Override
    String toString() {
        return length + unit
    }

    Speed div(Duration duration) {
        new Speed(this, duration)
    }
}
