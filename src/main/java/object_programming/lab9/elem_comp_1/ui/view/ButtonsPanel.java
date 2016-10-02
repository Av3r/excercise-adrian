package object_programming.lab9.elem_comp_1.ui.view;

import javax.swing.*;

public class ButtonsPanel extends JPanel {

    private JButton backgroundColorBtn;
    private JButton fontColorBtn;

    public ButtonsPanel() {
        initializeComponents();
    }

    private void initializeComponents() {
        backgroundColorBtn = new JButton("Wybierz kolor tła");
        fontColorBtn = new JButton("Wybierz kolor czcionki");

        add(backgroundColorBtn);
        add(fontColorBtn);
    }

    public JButton getBackgroundColorBtn() {
        return backgroundColorBtn;
    }

    public JButton getFontColorBtn() {
        return fontColorBtn;
    }
}
