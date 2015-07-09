package robots;

import world.Collision;
import world.Point;
import world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronald Dekker on 08/07/15.
 *
 * Actual robots of Robot class.
 */
public class SmartRobot extends Robot {
    private Point previous;

    public SmartRobot(World world, Point position) {
        super(world, position);
    }

    protected Move determineNextMove() {
        List<Move> moves = filterIllegalMoves(filterMovesThatReturnToPreviousPosition(getMoves()));
        Move bestRatedMove = findBestRatedMove(moves);
        previous = position;
        return bestRatedMove;
    }

    private List<Move> filterMovesThatReturnToPreviousPosition(List<Move> moves) {
        List<Move> result = new ArrayList<>();
        for (Move move : moves) {
            if (!(move.destination.equals(previous))) {
                result.add(move);
            }
        }
        return result;
    }

    private Move findBestRatedMove(List<Move> moves) {
        Move best = null;
        for (Move move : moves) {
            if (best == null || rate(move) < rate(best)) {
                best = move;
            }
        }
        return best;
    }

    public double rate(Move move) {
        Point goal = getGoal();
        // calculate the remaining distance to the goal
        double rating = move.destination.distanceToPoint(goal);
        return rating;
    }



    // filter away moves that are not possible
    private List<Move> filterIllegalMoves(List<Move> moves) {
        List<Move> result = new ArrayList<>();
        for (Move move : moves) {
            Collision collision = world.collide(move.destination);
            if (collision == null) {
                result.add(move);
            }
        }
        return result;
    }

    private List<Move> getMoves() {
        List<Move> moves = new ArrayList<>();
        // add moves in all directions
        moves.add(new Move("upper left", new Point(position.x-1, position.y-1)));
        moves.add(new Move("up", new Point(position.x, position.y-1)));
        moves.add(new Move("upper right", new Point(position.x+1, position.y-1)));
        moves.add(new Move("left", new Point(position.x-1, position.y)));
        moves.add(new Move("right", new Point(position.x+1, position.y)));

        // TODO: add more moves
        return moves;
    }


}
