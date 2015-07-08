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
    private Point goal;


    public void addObjects(WorldObject... objects) {
        this.objects.addAll(Arrays.asList(objects));
    }

    public Point getGoal() {
        return goal;
    }

    public void setGoal(Point goal) {
        this.goal = goal;
    }


    //TODO: not finished!
    public WorldObject findNearestBorder(Robot robot) {
        Collections.sort(objects);
        System.out.println(objects);
        return null;
    }

}
