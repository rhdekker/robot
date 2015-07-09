package robots;

import world.Collision;
import world.Point;
import world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public abstract class Robot {
    protected final World world;
    private final List<Point> path = new ArrayList<>();
    protected Point position;
    private Point goal;

    public Robot(World world, Point position) {
        this.world = world;
        this.position = position;
        // add start position to the path
        this.path.add(position);
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

    public List<Point> getPath() {
        return path;
    }

    public Move move() {
        // determine the next move
        Move next = determineNextMove();
        if (next == null) {
            throw new RuntimeException("Could not determine next move!");
        }
        // apply the next move
        this.position = next.destination;
        // add it to the path
        path.add(next.destination);
        // check whether there is a collision
        Collision collision = world.collide(position);
        if (collision!=null) {
            throw new RuntimeException(collision.toString());
        }
        return next;
    }

    public List<Point> goToGoal() {
        while(!hasReachedGoal()) {
            try {
                Move move = move();
                System.out.println("Last move was: " + move);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                break;
            }
        }
        return path;
    }

    protected abstract Move determineNextMove();

}
