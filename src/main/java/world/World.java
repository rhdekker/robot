package world;

import robots.Robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class World {
    public List<WorldObject> objects = new ArrayList<>();

    public void addObjects(WorldObject... objects) {
        this.addObjects(Arrays.asList(objects));
    }

    public void addObjects(List<WorldObject> objects) {
        this.objects.addAll(objects);
    }

    public WorldVector collide(Point point) {
        WorldVector collidingObject  = null;
        for (WorldObject object : objects) {
            WorldVector result = object.collide(point);
            if (result != null) {
                collidingObject = result;
                break;
            }
        }
        return collidingObject;
    }

    //TODO: not finished!
    public WorldObject findNearestBorder(Robot robot) {
        Collections.sort(objects);
        System.out.println(objects);
        return null;
    }

}
