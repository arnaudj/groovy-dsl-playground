package com.github.arnaudj.robot

class Robot {
    String move(Direction direction) {
        "Moving in direction " + direction.name()
    }

    String move(Direction direction, com.github.arnaudj.robot.Distance distance) {
        "Moving in direction " + direction.name() + " of distance " + distance
    }

    // groovy note: for mixed named/unamed params, by convention, all named arguments are gathered in a map as first parameter
    String move(Map settings, Direction direction) {
        "Moving in direction " + direction.name() + " of distance " + settings.get("by") + " at speed " + settings.get("at")
    }
}