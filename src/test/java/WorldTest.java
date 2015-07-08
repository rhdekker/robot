import org.junit.Test;
import world.*;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class WorldTest {

//    @Test
//    public void testFindNearestBorder() {
//        Main main = new Main();
//        World world = main.constructWorld();
//
//        WorldObject result = world.findNearestBorder(new Robot(new Point(10, 10)));
//
//    }

//    @Test
//    public void testRobotMoves() {
//        Main main = new Main();
//        World world = main.constructWorld();
//
//        Robot robot = new Robot(new Point(10, 10));
//        List<Move> moves = robot.getMoves();
//    }

    @Test
    public void testRobotMoves() {
        Main main = new Main();
        World world = main.constructWorld();
        world.setGoal(new Point(10, 5));

        Robot robot = new Robot(world, new Point(10, 10));
        while(robot.hasNotReachedGoal()) {
            Move move = robot.move();
            System.out.println("Last move was: " + move);
        }
    }
}
