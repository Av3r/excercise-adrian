package object_programming.lab10.gui_comp.ui.controller;

import object_programming.lab10.gui_comp.ui.view.LabelsFrame;

public class LabelsController {

    private LabelsFrame labelsFrame;

    public LabelsController() {
        labelsFrame = new LabelsFrame();
    }

    public void showFrame() {
        labelsFrame.setVisible(true);
    }
}
