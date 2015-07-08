package world;

import world.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class WorldVector {
    private Point begin;
    private Point end;

    // end is inclusive
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

    public List<Point> rasterize() {
        int hor = end.x - begin.x;
        int ver = end.y - begin.y;
        // hor and ver == 0 ---> error
        double horStep;
        double verStep;
        int length;
        if (hor == 0) {
            horStep = 0;
            verStep = 1;
            length = ver+1;
        } else if (ver == 0) {
            horStep = 1;
            verStep = 0;
            length = hor+1;
        } else {
            horStep = hor / ver;
            verStep = ver / hor;
            //        System.out.println(hor+":"+ver);
            throw new RuntimeException("Length not yet implemented!");
        }
        double xpos = begin.x;
        double ypos = begin.y;
        List<Point> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(new Point((int)xpos, (int)ypos));
            xpos += horStep;
            ypos += verStep;
        }
        return result;
    }
}


