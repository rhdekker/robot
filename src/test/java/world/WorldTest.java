package world;

import application.Application;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        Collision collision = world.collide(point);
        assertEquals("left", collision.getIdentifier());
    }

}
