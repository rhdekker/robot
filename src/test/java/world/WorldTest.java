package world;

import application.Application;
import org.junit.Test;

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

}
