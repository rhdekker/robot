package world;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class Robot {
    private final World world;
    private Point position;

    public Robot(World world, Point position) {
        this.world = world;
        this.position = position;
    }

    public boolean hasNotReachedGoal() {
        // check whether the position point of the robot is at the goal
        return !position.equals(world.getGoal());
    }

    public List<Move> getMoves() {
        List<Move> moves = new ArrayList<Move>();
        // add moves in all directions
        moves.add(new Move("upperleft", new Point(position.x-1, position.y-1)));
        moves.add(new Move("up", new Point(position.x, position.y-1)));
        moves.add(new Move("upperright", new Point(position.x+1, position.y-1)));
        // TODO: add more moves
        return moves;
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
            if (best == null || move.rate(world.getGoal()) < best.rate(world.getGoal())) {
                best = move;
            }
        }
        return best;
    }

}
