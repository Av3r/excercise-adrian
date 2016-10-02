package object_programming.lab10.gui_comp.ui.view;

import javax.swing.*;
import java.awt.*;

public class LabelsPanel extends JPanel {

    public LabelsPanel() {
        setPanelUp();
        initializeComponents();
    }

    private void setPanelUp() {
        setLayout(new BorderLayout());
    }

    private void initializeComponents() {
        JLabel label1 = createLabel1();
        JLabel label2 = createLabel2();
        JLabel label3 = createLabel3();
        JLabel label4 = createLabel4();
        JLabel label5 = createLabel5();

        add(label1, BorderLayout.NORTH);
        add(label2, BorderLayout.EAST);
        add(label3, BorderLayout.SOUTH);
        add(label4, BorderLayout.WEST);
        add(label5, BorderLayout.CENTER);
    }

    private JLabel createLabel1() {
        JLabel label = new JLabel("Label 1");
        label.setOpaque(true);
        label.setBackground(Color.green);
        label.setForeground(Color.pink);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setToolTipText("ToolTip 1");
        label.setBorder(BorderFactory.createLineBorder(Color.blue));
        return label;
    }

    private JLabel createLabel2() {
        JLabel label = new JLabel("Label 2");
        label.setOpaque(true);
        label.setBackground(Color.blue);
        label.setForeground(Color.red);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setToolTipText("ToolTip 2");
        label.setBorder(BorderFactory.createLineBorder(Color.red));
        return label;
    }

    private JLabel createLabel3() {
        JLabel label = new JLabel("Label 3");
        label.setOpaque(true);
        label.setBackground(Color.black);
        label.setForeground(Color.blue);
        label.setFont(new Font("Verdana", Font.ITALIC, 18));
        label.setToolTipText("ToolTip 3");
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        return label;
    }

    private JLabel createLabel4() {
        JLabel label = new JLabel("Label 4");
        label.setOpaque(true);
        label.setBackground(Color.pink);
        label.setForeground(Color.black);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setToolTipText("ToolTip 4");
        label.setBorder(BorderFactory.createLineBorder(Color.green));
        return label;
    }

    private JLabel createLabel5() {
        JLabel label = new JLabel("Label 5");
        label.setOpaque(true);
        label.setBackground(Color.yellow);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setToolTipText("ToolTip 5");
        label.setBorder(BorderFactory.createLineBorder(Color.yellow));
        return label;
    }
}
