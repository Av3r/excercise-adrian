package object_programming.lab10.gui_comp.ui.view;

import javax.swing.*;
import java.awt.*;

public class LabelsFrame extends JFrame {

    public LabelsFrame() {
        setFrameUp();
        initializeComponents();
    }

    private void setFrameUp() {
        setTitle("LabelsFrame");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        JLabel label1 = createLabel1();
        JLabel label2 = new JLabel("Label 2");
        JLabel label3 = new JLabel("Label 3");
        JLabel label4 = new JLabel("Label 4");
        JLabel label5 = new JLabel("Label 5");

        add(label1, BorderLayout.NORTH);
        add(label2, BorderLayout.EAST);
        add(label3, BorderLayout.SOUTH);
        add(label4, BorderLayout.WEST);
        add(label5, BorderLayout.CENTER);

    }

    private JLabel createLabel1() {
        JLabel label = new JLabel("Label 1");
        //TODO poprawic BACKGROUND
        label.setBackground(Color.green);
        label.setForeground(Color.red);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setToolTipText("ToolTip 1");
        label.setBorder(BorderFactory.createLineBorder(Color.blue));
        return label;
    }

}


