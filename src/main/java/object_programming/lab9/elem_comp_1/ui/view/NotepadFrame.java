package object_programming.lab9.elem_comp_1.ui.view;

import javax.swing.*;

public class NotepadFrame extends JFrame {

    private NotepadPanel notepadPanel;

    public NotepadFrame() {
        setFrameUp();
        initializeComponents();
    }

    private void setFrameUp() {
        setTitle("Notatnik");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        notepadPanel = new NotepadPanel();
        add(notepadPanel);
    }

    public NotepadPanel getNotepadPanel() {
        return notepadPanel;
    }
}
