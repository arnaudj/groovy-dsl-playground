import com.github.arnaudj.robot.Robot
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RobotMetaClassTest {
    Robot robot

    @Before
    void setup() {
        robot = new Robot()
    }

    @Test
    void testMetaClassExpando() {
        def originalRobot = new Robot()

        Robot.metaClass.greet = { -> "hi" }
        Assert.assertEquals("hi", new Robot().greet())

        // metaclass changes only apply to objects created afterwards (unless ExpandoMetaClass.enableGlobally() is called)
        try {
            Assert.assertEquals("hi", originalRobot.greet())
            Assert.fail("Expected fail")
        } catch (MissingMethodException mme) {
        }
    }

    class RobotEx extends Robot {}

    @Test
    void testMetaClassInheritance() {
        Robot.metaClass.greet = { -> "hi" }

        // greet method apply to both parent & subclasses
        Assert.assertEquals("hi", new RobotEx().greet())
        Assert.assertEquals("hi", new Robot().greet())
    }

    @Test
    void testMetaClassOnInterface() {
        Map.metaClass.hello = { -> "hi" }
        Assert.assertEquals("hi", [a: "test"].hello())
    }
}

