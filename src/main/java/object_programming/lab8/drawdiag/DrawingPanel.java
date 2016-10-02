package object_programming.lab8.drawdiag;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        g.drawLine(0, 0, getWidth(), getHeight());
        g.drawLine(0, getHeight(), getWidth(), 0);
    }

}
