package application;

import renderer.Renderer;
import robots.DumbRobot;
import robots.Robot;
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
        // setup application
        Application application = new Application();

        // setup main window
        JFrame f = new JFrame("Robot test chamber");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // setup tabbed pane and tabs
        JTabbedPane tabs = new JTabbedPane();

        // setup test situation 0
        renderer.Renderer panel0 = getPanelForSituation0(application);
        tabs.add("test situation 0", panel0);

//        // setup test situation 1
//        renderer.Renderer panel1 = getPanelForSituation1(application);
//        tabs.add("test situation 1", panel1);

//        // setup test situation 2
//        renderer.Renderer panel2 = getPanelForSituation2(application);
//        tabs.add("test situation 2", panel2);

//        // setup test situation 3
//        renderer.Renderer panel3 = getPanelForSituation3(application);
//        tabs.add("test situation 3", panel3);

//        // setup test situation 4
//        renderer.Renderer panel4 = getPanelForSituation4(application);
//        tabs.add("test situation 4", panel4);

        f.getContentPane().add("Center", tabs);
        f.pack();
        f.setSize(new Dimension(300, 300));
        f.setVisible(true);
    }


    private static renderer.Renderer getPanelForSituation0(Application application) {
        // situation 0
        World world = application.constructWorld();

        // setup robot
        Robot robot = new DumbRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 5));

        // let robot walk
        System.out.println("Log test situation 0");
        robot.goToGoal();

        // setup renderer
        return new renderer.Renderer(world, robot);
    }

    private static renderer.Renderer getPanelForSituation1(Application application) {
        // situation 1
        World world = application.constructWorld();

        // add obstruction
        WorldObject obstruction = new WorldObject("obstruction", new WorldVector(new Point(3,7), new Point(16,7)));
        world.addObjects(obstruction);

        // setup robot
        Robot robot = new DumbRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 5));

        // let robot walk
        System.out.println("Log test situation 1");
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
        Robot robot = new DumbRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 1));

        // let robot walk
        System.out.println("Log test situation 2");
        robot.goToGoal();

        // setup renderer
        return new renderer.Renderer(world, robot);
    }


    private static Renderer getPanelForSituation3(Application application) {
        // situation 3
        World world = application.constructWorld();

        WorldObject leftPanel = new WorldObject("obstruction", new WorldVector(new Point(8, 5), new Point(8, 8)));
        WorldObject rightPanel = new WorldObject("obstruction", new WorldVector(new Point(12, 5), new Point(12, 8)));
        WorldObject topPanel = new WorldObject("obstruction", new WorldVector(new Point(8, 4), new Point(12, 4)));

        world.addObjects(leftPanel);
        world.addObjects(rightPanel);
        world.addObjects(topPanel);

        // setup robot
        Robot robot = new DumbRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 1));

        // let robot walk
        System.out.println("Log test situation 3");
        robot.goToGoal();

        return new renderer.Renderer(world, robot);
    }

    private static Renderer getPanelForSituation4(Application application) {
        // situation 3
        World world = application.constructWorld();

        WorldObject leftPanel = new WorldObject("obstruction", new WorldVector(new Point(9, 5), new Point(9, 8)));
        WorldObject rightPanel = new WorldObject("obstruction", new WorldVector(new Point(11, 5), new Point(11, 8)));
        WorldObject topPanel = new WorldObject("obstruction", new WorldVector(new Point(9, 4), new Point(11, 4)));

        world.addObjects(leftPanel);
        world.addObjects(rightPanel);
        world.addObjects(topPanel);

        // setup robot
        Robot robot = new DumbRobot(world, new Point(10, 10));
        robot.setGoal(new Point(10, 1));

        // let robot walk
        System.out.println("Log test situation 3");
        robot.goToGoal();

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
