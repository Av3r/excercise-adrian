package object_programming.lab9.simple_lay.ui.view;

import javax.swing.*;
import java.awt.*;

public class LayoutFrame extends JFrame {

    public LayoutFrame(LayoutManager layout) {
        setFrameUp(layout);
        initializeComponents();
    }

    private void setFrameUp(LayoutManager layout) {
        setTitle("Layouts");
        setLayout(layout);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        JButton button1 = new JButton("Przycisk 1");
        JButton button2 = new JButton("P 2");
        JButton button3 = new JButton("Wiekszy przycisk numer 3");
        JButton button4 = new JButton("Przycisk 4");
        JButton button5 = new JButton("P 5");

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
    }

}
