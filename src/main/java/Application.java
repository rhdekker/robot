import world.Point;
import world.World;
import world.WorldObject;
import world.WorldVector;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class Application {
    public World world;

    public static void main(String[] args) {
        Application application = new Application();
        application.world = application.constructWorld();
    }

    protected World constructWorld() {
        // create world
        World world = new World();

        // create border objects
        WorldObject upperBorder = new WorldObject("upper", new WorldVector(new Point(0, 0), new Point(19, 0)));
        WorldObject leftBorder = new WorldObject("left", new WorldVector(new Point(0, 0), new Point(0, 19)));
        WorldObject rightBorder = new WorldObject("right", new WorldVector(new Point(19, 0), new Point(19, 19)));
        WorldObject lowerBorder = new WorldObject("lower", new WorldVector(new Point(0, 19), new Point(19, 19)));

        // add border objects to the world
        world.addObjects(upperBorder, leftBorder, rightBorder, lowerBorder);
        return world;
    }
}
