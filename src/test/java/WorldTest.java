import org.junit.Test;
import renderer.Application;
import world.*;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class WorldTest {

    @Test
    public void testCollision() {
        Application main = new Application();
        World world = main.constructWorld();

        Point point = new Point(0, 5);

        // should collide with left border
        WorldVector collisionVector = world.collide(point);
        System.out.println(collisionVector);

    }

//    @Test
//    public void testFindNearestBorder() {
//        renderer.Application main = new renderer.Application();
//        World world = main.constructWorld();
//
//        WorldObject result = world.findNearestBorder(new Robot(new Point(10, 10)));
//
//    }

//    @Test
//    public void testRobotMoves() {
//        renderer.Application main = new renderer.Application();
//        World world = main.constructWorld();
//
//        Robot robot = new Robot(new Point(10, 10));
//        List<Move> moves = robot.getMoves();
//    }
}
