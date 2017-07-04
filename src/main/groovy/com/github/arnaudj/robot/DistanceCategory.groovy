package com.github.arnaudj.robot

@Category(Number.class)
class DistanceCategory {
    Distance getM() {
        new Distance(this, "m")
    }

    Distance getCm() {
        new Distance(this, "cm")
    }

    Distance getKm() {
        new Distance(this, "km")
    }
}
