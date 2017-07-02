package com.github.arnaudj.robot;

import java.util.Map;

public class Robot {
    public String move(Direction direction) {
        return "Moving in direction " + direction.name();
    }

    public String move(Direction direction, Distance distance) {
        return "Moving in direction " + direction.name() + " of distance " + distance;
    }

    // groovy note: for mixed named/unamed params, by convention, all named arguments are gathered in a map as first parameter
    public String move(Map settings, Direction direction) {
        return "Moving in direction " + direction.name() + " of distance " + settings.get("by") + " at speed " + settings.get("at");
    }
}
