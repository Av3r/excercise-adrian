package object_programming.lab8.drawdiag;

import javax.swing.*;

public class DrawingFrame extends JFrame {

    public DrawingFrame() {
        setFrameUp();
        initializeComponents();
    }

    private void setFrameUp() {
        setTitle("Przekatne");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel);
    }
}
