package world;

import world.Point;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class WorldVector {
    private Point begin;
    private Point end;

    public WorldVector(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public int compareTo(WorldVector other) {
        int result = begin.compareTo(other.begin);
        if (result!=0) {
            return result;
        }
        return end.compareTo(other.end);
    }
}


