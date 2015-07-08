package renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;

/**
 * Created by ronalddekker on 08/07/15.
 */
public class Renderer extends JFrame {


    public Renderer() {
        super("ShapesDemo2D");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        init();
        pack();
        setSize(new Dimension(300, 300));
        show();
    }

    public void init() {
        setBackground(Color.white);
        setForeground(Color.white);
    }


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setPaint(Color.gray);
        int x = 5;
        int y = 7;

        g2.draw(new Line2D.Double(x, y, 200, 200));
        g2.drawString("Line2D", x, 250);

    }

    public static void main(String s[]) {
        Renderer renderer = new Renderer();
    }
}
