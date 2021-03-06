package robots;

import world.Point;

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

    @Override
    public String toString() {
        return description+":"+destination;
    }
}
