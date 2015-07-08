import robots.SmartRobot;
import org.junit.Test;
import world.*;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by ronalddekker on 08/07/15.
 */


public class RobotTest {

    // There are no obstructions in the world
    @Test
    public void testRobotMoves() {
        Application application = new Application();
        World world = application.constructWorld();

        Robot robot = new SmartRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 5));

        assertThat(robot.move(), MoveMatcher.move(10, 9));
        assertThat(robot.move(), MoveMatcher.move(10, 8));
        assertThat(robot.move(), MoveMatcher.move(10, 7));
        assertThat(robot.move(), MoveMatcher.move(10, 6));
        assertThat(robot.move(), MoveMatcher.move(10, 5));
        assertTrue(robot.hasReachedGoal());
    }

    // One obstruction in the world
    @Test
    public void testRobotMovesObstruction() {
        Application application = new Application();
        World world = application.constructWorld();

        WorldObject obstruction = new WorldObject("obstruction", new WorldVector(new Point(2,7), new Point(18,7)));
        world.addObjects(obstruction);

        Robot robot = new SmartRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 5));

//        assertThat(robot.move(), MoveMatcher.move(10, 9));
//        assertThat(robot.move(), MoveMatcher.move(10, 9));
//        assertTrue(robot.hasReachedGoal());
//        Last move was: up:(10,8)
//        Last move was: left:(9,8)
//        Last move was: left:(8,8)
//        Last move was: left:(7,8)
//        Last move was: left:(6,8)
//        Last move was: left:(5,8)
//        Last move was: left:(4,8)
//        Last move was: left:(3,8)
//        Last move was: left:(2,8)
//        Last move was: upper left:(1,7)
//        Last move was: upper right:(2,6)
//        Last move was: upper right:(3,5)
//        Last move was: right:(4,5)
//        Last move was: right:(5,5)
//        Last move was: right:(6,5)
//        Last move was: right:(7,5)
//        Last move was: right:(8,5)
//        Last move was: right:(9,5)
//        Last move was: right:(10,5)






        while(!robot.hasReachedGoal()) {
            Move move = robot.move();
            System.out.println("Last move was: " + move);
        }

    }



}
