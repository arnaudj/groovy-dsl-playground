package com.github.arnaudj.robot

import groovy.transform.TupleConstructor

@TupleConstructor
class Speed {
    Distance distance
    Duration duration

    @Override
    String toString() {
        return "${distance}/${duration.name()}"
    }
}
