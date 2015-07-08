package renderer;

import robots.SmartRobot;
import world.*;
import world.Point;
import world.Robot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class Application {

    public static void main(String args[]) {
        // setup world
        Application application = new Application();
        World world = application.constructWorld();

        // setup robot
        Robot robot = new SmartRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 5));

        // let robot walk
        List<Point> path = robot.goToGoal();

        // setup renderer
        renderer.Renderer panel = new renderer.Renderer(world, path);

        // setup main window
        JFrame f = new JFrame("ShapesDemo2D");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.getContentPane().add("Center", panel);
        panel.init();
        f.pack();
        f.setSize(new Dimension(300, 300));
        f.show();
    }

    public World constructWorld() {
        // create world
        World world = new World();

        // create border objects
        WorldObject upperBorder = new WorldObject("upper", new WorldVector(new Point(0, 0), new Point(19, 0)));
        WorldObject leftBorder = new WorldObject("left", new WorldVector(new Point(0, 0), new Point(0, 19)));
        WorldObject rightBorder = new WorldObject("right", new WorldVector(new Point(19, 0), new Point(19, 19)));
        WorldObject lowerBorder = new WorldObject("lower", new WorldVector(new Point(0, 19), new Point(19, 19)));

        // add border objects to the world
        world.addObjects(upperBorder, leftBorder, rightBorder, lowerBorder);

        // add obstruction
        WorldObject obstruction = new WorldObject("obstruction", new WorldVector(new Point(2,7), new Point(17,7)));
        world.addObjects(obstruction);

        return world;
    }
}
