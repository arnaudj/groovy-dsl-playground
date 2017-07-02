package com.github.arnaudj.robot

class DistanceCategory {
    static Distance getM(Number number) {
        return new Distance(number, "m")
    }

    static Distance getCm(Number number) {
        return new Distance(number, "cm")
    }

    static Distance getKm(Number number) {
        return new Distance(number, "km")
    }
}