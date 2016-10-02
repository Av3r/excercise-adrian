package object_programming.lab10.gui_comp.ui.view;

import javax.swing.*;

public class LabelsFrame extends JFrame {

    public LabelsFrame() {
        setFrameUp();
        initializeComponents();
    }

    private void setFrameUp() {
        setTitle("LabelsFrame");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        LabelsPanel labelsPanel = new LabelsPanel();
        add(labelsPanel);
    }

}


