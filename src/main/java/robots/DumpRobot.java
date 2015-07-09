package robots;

import world.Point;
import world.World;

/**
 * Created by ronalddekker on 09/07/15.
 */
public class DumpRobot extends Robot {
    public DumpRobot(World world, Point position) {
        super(world, position);
    }

    @Override
    protected Move determineNextMove() {
        return null;
    }
}
