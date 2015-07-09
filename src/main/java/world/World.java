package world;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Collision collide(Point point) {
        WorldObject collidingObject = null;
        WorldVector collidingVector = null;
        for (WorldObject object : objects) {
            WorldVector vector = object.collide(point);
            if (vector != null) {
                collidingObject = object;
                collidingVector = vector;
                break;
            }
        }
        if (collidingVector == null) {
            return null;
        }
        Collision collision = new Collision(collidingObject, collidingVector);
        return collision;
    }

}
