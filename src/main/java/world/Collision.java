package world;

/**
 * Created by ronalddekker on 09/07/15.
 */
public class Collision {
    private final WorldObject collidingObject;
    private final WorldVector collidingVector;

    public Collision(WorldObject collidingObject, WorldVector collidingVector) {
        this.collidingObject = collidingObject;
        this.collidingVector = collidingVector;
    }

    @Override
    public String toString() {
        return "Collision detected with "+collidingObject.toString()+" in vector: "+collidingVector;
    }

    public String getIdentifier() {
        return collidingObject.title;
    }
}
