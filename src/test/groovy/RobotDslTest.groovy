import com.github.arnaudj.robot.Distance
import com.github.arnaudj.robot.DistanceCategory
import com.github.arnaudj.robot.Robot
import com.github.arnaudj.robot.Speed
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import static com.github.arnaudj.robot.Direction.FORWARD
import static com.github.arnaudj.robot.Duration.hour

// Groovy in action DSL 'koans' (chapter 18)
class RobotDslTest {
    Robot robot

    @Before
    void setup() {
        robot = new Robot()
    }

    @Test
    void testMoveNoParenthesis() {
        def state = robot.move FORWARD
        Assert.assertEquals("Moving in direction FORWARD", state)
    }

    @Test
    void testPseudoExtensionMethodViaUseKeyword() {
        use(DistanceCategory) {
            def state = robot.move FORWARD, 2.m
            Assert.assertEquals("Moving in direction FORWARD of distance 2m", state)
            state = robot.move FORWARD, 200.cm
            Assert.assertEquals("Moving in direction FORWARD of distance 200cm", state)
        }
    }

    @Test
    void testNamedArguments() {
        def state = robot.move FORWARD, by: new Distance(1, "m"), at: "5km/h"
        Assert.assertEquals("Moving in direction FORWARD of distance 1m at speed 5km/h", state)

        // with use
        use(DistanceCategory) {
            // with distance DSL
            state = robot.move FORWARD, by: 1.m, at: new Speed(5.km, hour)
            Assert.assertEquals("Moving in direction FORWARD of distance 1m at speed 5km/hour", state)

            // with speed DSL
            state = robot.move FORWARD, by: 2.m, at: 50.km / hour
            Assert.assertEquals("Moving in direction FORWARD of distance 2m at speed 50km/hour", state)
        }
    }

    @Test
    void testCommandChain() {
        def state = robot.moveCC FORWARD by new Distance(100, "m") at new Speed(new Distance(30, "km"), hour)
        // Equivalent to : def state = robot.moveCC(FORWARD).by(distance).at(speed)
        Assert.assertEquals("Moving in direction FORWARD of distance 100m at speed 30km/hour", state)

        // with use
        use(DistanceCategory) {
            state = robot.moveCC FORWARD by 110.m at 35.km/hour
            Assert.assertEquals("Moving in direction FORWARD of distance 110m at speed 35km/hour", state)
        }
    }

}
