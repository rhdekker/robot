package world;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public abstract class Robot {
    protected final World world;
    protected Point position;
    private Point goal;

    public Robot(World world, Point position) {
        this.world = world;
        this.position = position;
    }

    public Point getGoal() {
        return goal;
    }

    public void setGoal(Point goal) {
        this.goal = goal;
    }

    public boolean hasReachedGoal() {
        // check whether the position point of the robot is at the goal
        return position.equals(getGoal());
    }

    public Move move() {
        // determine the next move
        Move next = determineNextMove();
        if (next == null) {
            throw new RuntimeException("Could not determine next move!");
        }
        // apply the next move
        this.position = next.destination;
        // check whether there is a collision
        WorldVector vector = world.collide(position);
        if (vector!=null) {
            throw new RuntimeException("Collision detected with vector: "+vector);
        }
        return next;
    }

    protected abstract Move determineNextMove();

}
