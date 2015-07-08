import org.junit.Test;
import world.Move;
import world.Point;
import world.Robot;
import world.World;

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

        Robot robot = new Robot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 5));

        assertThat(robot.move(), MoveMatcher.move(10, 9));
        assertThat(robot.move(), MoveMatcher.move(10, 8));
        assertThat(robot.move(), MoveMatcher.move(10, 7));
        assertThat(robot.move(), MoveMatcher.move(10, 6));
        assertThat(robot.move(), MoveMatcher.move(10, 5));
        assertTrue(robot.hasReachedGoal());
    }



//        while(!robot.hasReachedGoal()) {
//            Move move = robot.move();
//            System.out.println("Last move was: " + move);
//        }

}
