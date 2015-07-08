import org.junit.Test;
import world.Point;
import world.WorldObject;
import world.WorldVector;

import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class WorldVectorTest {

    @Test
    public void testRasterizeBorders() {
        WorldVector vector = new WorldVector(new Point(0, 0), new Point(19, 0));
        WorldObject upperBorder = new WorldObject("upper", vector);
        List<Point> points = vector.rasterize();
        System.out.println(points);



    }
}
