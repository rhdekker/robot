package application;

import robots.Robot;
import robots.SmartRobot;
import world.Point;
import world.World;
import world.WorldObject;
import world.WorldVector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class Application {

    public static void main(String args[]) {
        // setup world
        Application application = new Application();

        // setup test situation 1
        renderer.Renderer panel1 = getPanelForSituation1(application);

        // setup test situation 2
        renderer.Renderer panel2 = getPanelForSituation2(application);


        // setup main window
        JFrame f = new JFrame("Robot test chamber");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // setup tabbed pane and tabs
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("test situation 1", panel1);
        tabs.add("test situation 2", panel2);

        f.getContentPane().add("Center", tabs);
        f.pack();
        f.setSize(new Dimension(300, 300));
        f.setVisible(true);
    }


    private static renderer.Renderer getPanelForSituation1(Application application) {
        // situation 1
        World world = application.constructWorld();

        // add obstruction
        WorldObject obstruction = new WorldObject("obstruction", new WorldVector(new Point(2,7), new Point(17,7)));
        world.addObjects(obstruction);

        // setup robot
        Robot robot = new SmartRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 5));

        // TODO: delay!
        // let robot walk
        robot.goToGoal();

        // setup renderer
        return new renderer.Renderer(world, robot);
    }

    private static renderer.Renderer getPanelForSituation2(Application application) {
        // situation 2
        World world = application.constructWorld();

        WorldObject leftSidePanel = new WorldObject("obstruction", new WorldVector(new Point(2,6), new Point(6,2)));
        WorldObject leftSidePanel2 = new WorldObject("obstruction", new WorldVector(new Point(2,7), new Point(7,2)));
        WorldObject middlePanel = new WorldObject("obstruction", new WorldVector(new Point(8,2), new Point(12,2)));

        world.addObjects(leftSidePanel);
        world.addObjects(leftSidePanel2);
        world.addObjects(middlePanel);

        // setup robot
        Robot robot = new SmartRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 1));

        // TODO: delay!
        // let robot walk
        robot.goToGoal();

        // setup renderer
        return new renderer.Renderer(world, robot);
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

        return world;
    }
}