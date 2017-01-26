package object_programming_2.snow.ui.view;

import object_programming_2.snow.ui.model.RGBImage;

import javax.swing.*;

public class ImageFrame extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    private static final String FRAME_TITLE = "PPM Image";

    private ImagePanel imagePanel;

    public ImageFrame(RGBImage image) {
        setFrameUp();
        initComponents(image);
        pack();
        setLocationRelativeTo(null);
    }

    private void setFrameUp() {
        setTitle(FRAME_TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void initComponents(RGBImage image) {
        imagePanel = new ImagePanel(image);
        add(imagePanel);
    }

}
