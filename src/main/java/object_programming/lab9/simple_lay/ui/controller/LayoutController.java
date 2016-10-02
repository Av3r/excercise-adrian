package object_programming.lab9.simple_lay.ui.controller;

import object_programming.lab9.simple_lay.ui.view.LayoutFrame;

import java.awt.*;

public class LayoutController {

    private LayoutFrame layoutFrame;

    public LayoutController(LayoutManager layout) {
        layoutFrame = new LayoutFrame(layout);
    }

    public void showFrame() {
        layoutFrame.setVisible(true);
    }
}
