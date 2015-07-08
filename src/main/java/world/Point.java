package world;

import java.util.Objects;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class Point implements Comparable<Point> {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point other) {
        int result = x - other.x;
        if (result != 0) {
            return result;
        }
        return y - other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        Point other = (Point) obj;
        return Objects.equals(x, other.x) && Objects.equals(y, other.y);
    }

    public double distanceToPoint(Point other) {
        return Math.sqrt(Math.pow(Math.abs(x - other.x), 2)+ Math.pow(Math.abs(y - other.y), 2));
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
