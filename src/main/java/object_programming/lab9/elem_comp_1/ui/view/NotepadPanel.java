package object_programming.lab9.elem_comp_1.ui.view;

import javax.swing.*;
import java.awt.*;

public class NotepadPanel extends JPanel {

    private JTextArea jTextArea;
    private ButtonsPanel buttonsPanel;

    public NotepadPanel() {
        setPanelUp();
        initializeComponents();
    }

    private void setPanelUp() {
        setLayout(new BorderLayout());
    }

    private void initializeComponents() {
        JScrollPane scrollArea = createTextArea();
        buttonsPanel = new ButtonsPanel();

        add(scrollArea, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private JScrollPane createTextArea() {
        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        jTextArea.setBackground(Color.BLUE);
        jTextArea.setForeground(Color.ORANGE);
        Font font = new Font("Dialog", Font.BOLD + Font.ITALIC, 28);
        jTextArea.setFont(font);
        return new JScrollPane(jTextArea);
    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public ButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }
}
