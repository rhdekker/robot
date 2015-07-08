package renderer;

import world.*;
import world.Point;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class Renderer extends JPanel {

    private final World world;
    private List<Point> path;

    public Renderer(World world, List<Point> path) {
        this.world = world;
        this.path = path;
    }

    public void init() {
        setBackground(Color.white);
        setForeground(Color.white);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


        // draw objects in the world
        g2.setPaint(Color.gray);
        for (WorldObject object : world.objects) {
            for (WorldVector vector : object.vectors) {
                java.util.List<world.Point> points = vector.rasterize();
                for (world.Point point : points) {
                    g2.draw(new Rectangle(point.x*10, point.y*10, 10, 10));
                }
            }
        }

        // draw path of robot
        g2.setPaint(Color.black);

        for (world.Point point : path) {
            g2.draw(new Rectangle(point.x*10, point.y*10, 10, 10));
        }
   }
}
