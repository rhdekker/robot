package world;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class Robot {
    private final World world;
    private Point position;
    private Point goal;

    public Robot(World world, Point position) {
        this.world = world;
        this.position = position;
    }

    public Point getGoal() {
        return goal;
    }

    public void setGoal(Point goal) {
        this.goal = goal;
    }

    public boolean hasReachedGoal() {
        // check whether the position point of the robot is at the goal
        return position.equals(getGoal());
    }

    public Move move() {
        // select best move out of moves
        Move best = selectBestMove();
        // apply the best move
        this.position = best.destination;
        return best;
    }

    private Move selectBestMove() {
        List<Move> moves = getMoves();
        Move best = null;
        for (Move move : moves) {
            if (best == null || move.rate(getGoal()) < best.rate(getGoal())) {
                best = move;
            }
        }
        return best;
    }

    private List<Move> getMoves() {
        List<Move> moves = new ArrayList<>();
        // add moves in all directions
        moves.add(new Move("upperleft", new Point(position.x-1, position.y-1)));
        moves.add(new Move("up", new Point(position.x, position.y-1)));
        moves.add(new Move("upperright", new Point(position.x+1, position.y-1)));
        // TODO: add more moves
        return moves;
    }

}
