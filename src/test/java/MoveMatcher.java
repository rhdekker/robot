import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import world.Move;
import world.Point;

import java.util.Objects;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class MoveMatcher extends BaseMatcher<Move> {

    private Point expectedDestination;

    public MoveMatcher(Point expectedDestination) {
        this.expectedDestination = expectedDestination;
    }

    public static MoveMatcher move(int x, int y) {
        return new MoveMatcher(new Point(x, y));
    }

    @Override
    public boolean matches(Object o) {
        if (!(o instanceof Move)) {
            return false;
        }
        Move other = (Move) o;
        return Objects.equals(expectedDestination, other.destination);
    }

    @Override
    public void describeTo(Description description) {
        System.out.println("describeTo called!");
    }
}
