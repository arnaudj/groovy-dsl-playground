package com.github.arnaudj.robot.dsl;

import com.github.arnaudj.robot.Distance;

public class DistanceCategory {
    public static Distance getMeters(Number number) {
        return new Distance(number, "m");
    }

    public static Distance getCentimeters(Number number) {
        return new Distance(number, "cm");
    }
}
