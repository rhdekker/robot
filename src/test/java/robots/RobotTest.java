package robots;

import application.Application;
import org.junit.Test;
import world.Point;
import world.World;
import world.WorldObject;
import world.WorldVector;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by ronalddekker on 08/07/15.
 */


public class RobotTest {

    // There are no obstructions in the world
    @Test
    public void testRobotMoves() {
        Application application = new Application();
        World world = application.constructWorld();

        Robot robot = new DumbRobot(world, new Point(10, 10));
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

        WorldObject obstruction = new WorldObject("obstruction", new WorldVector(new Point(3,7), new Point(16,7)));
        world.addObjects(obstruction);

        Robot robot = new DumbRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 5));

        assertThat(robot.move(), robots.MoveMatcher.move(10, 9));
        assertThat(robot.move(), robots.MoveMatcher.move(10, 8));
        // TODO: add more asserts!
    }



}
