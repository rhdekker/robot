package world;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class WorldObject implements Comparable<WorldObject> {
    private final String title;
    private List<WorldVector> vectors;

    public WorldObject(String title, WorldVector worldVector) {
        this.title = title;
        this.vectors = new ArrayList<>();
        this.vectors.add(worldVector);
    }

    public int compareTo(WorldObject other) {
        // for now compare the first vector of this object to the first vector of the other;
        int result = this.vectors.get(0).compareTo(other.vectors.get(0));
        return result;
    }

    @Override
    public String toString() {
        return title;
    }
}
