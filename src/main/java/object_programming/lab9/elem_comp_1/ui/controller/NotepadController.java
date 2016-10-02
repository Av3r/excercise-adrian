package object_programming.lab9.elem_comp_1.ui.controller;

import object_programming.lab9.elem_comp_1.ui.view.ButtonsPanel;
import object_programming.lab9.elem_comp_1.ui.view.NotepadFrame;

import javax.swing.*;
import java.awt.*;

public class NotepadController {

    private NotepadFrame notepadFrame;

    public NotepadController() {
        notepadFrame = new NotepadFrame();
        setUpListeners();
    }

    public void showFrame() {
        notepadFrame.setVisible(true);
    }

    private void setUpListeners() {
        ButtonsPanel buttonsPanel = notepadFrame.getNotepadPanel().getButtonsPanel();
        buttonsPanel.getBackgroundColorBtn().addActionListener(e -> changeBackgroundColor());
        buttonsPanel.getFontColorBtn().addActionListener(e -> changeFontColor());
    }

    private void changeBackgroundColor() {
        Color newColor = JColorChooser.showDialog(null, "Wybierz kolor tła", Color.WHITE);
        JTextArea jTextArea = notepadFrame.getNotepadPanel().getjTextArea();
        jTextArea.setBackground(newColor);
    }

    private void changeFontColor() {
        Color newColor = JColorChooser.showDialog(null, "Wybierz kolor czcionki", Color.WHITE);
        JTextArea jTextArea = notepadFrame.getNotepadPanel().getjTextArea();
        jTextArea.setForeground(newColor);
    }

}
