package world;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class Move {
    private final String description;
    public final Point destination;

    public Move(String description, Point destination) {
        this.description = description;
        this.destination = destination;
    }

    public double rate(Point goal) {
        // calculate the remaining distance to the goal
        double rating = destination.distanceToPoint(goal);
        return rating;
    }

    @Override
    public String toString() {
        return description+":"+destination;
    }
}
