package com.github.arnaudj.robot

class Robot {
    String move(Direction direction) {
        "Moving in direction ${direction.name()}"
    }

    String move(Direction direction, Distance distance) {
        "Moving in direction ${direction.name()} of distance $distance"
    }

    // groovy note: for mixed named/unamed params, by convention, all named arguments are gathered in a map as first parameter
    String move(Map settings, Direction direction) {
        "Moving in direction ${direction.name()} of distance ${settings["by"]} at speed ${settings["at"]}"
    }

    // command chain based move
    def moveCC(Direction direction) {
        [by: { Distance distance ->
            [at: { Speed speed ->
                "Moving in direction ${direction.name()} of distance $distance at speed $speed".toString()
            }]
        }]
    }
}