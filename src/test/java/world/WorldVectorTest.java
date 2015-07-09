package world;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class WorldVectorTest {

    @Test
    public void testRasterizeBorders() {
        WorldVector vector = new WorldVector(new Point(0, 0), new Point(5, 0));
        WorldObject upperBorder = new WorldObject("upper", vector);
        List<Point> points = vector.rasterize();
        assertEquals("[(0,0), (1,0), (2,0), (3,0), (4,0), (5,0)]", points.toString());
    }
}
