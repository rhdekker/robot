package world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class World {
    private List<WorldObject> objects = new ArrayList<WorldObject>();


    public void addObjects(WorldObject... objects) {
        this.objects.addAll(Arrays.asList(objects));
    }


    //TODO: not finished!
    public WorldObject findNearestBorder(Robot robot) {
        Collections.sort(objects);
        System.out.println(objects);
        return null;
    }

}
