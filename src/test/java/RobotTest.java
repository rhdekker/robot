import org.junit.Test;
import world.Move;
import world.Point;
import world.Robot;
import world.World;

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

        while(!robot.hasReachedGoal()) {
            Move move = robot.move();
            System.out.println("Last move was: " + move);
        }
    }

}
