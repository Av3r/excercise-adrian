package object_programming.lab8.imgview.ui.view;

import javax.swing.*;

public class ImageFrame extends JFrame {

    private ImagePanel imagePanel;

    public ImageFrame() {
        setFrameUp();
        initializeComponents();
    }

    private void setFrameUp() {
        setTitle("Przegladarka obrazkow");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        imagePanel = new ImagePanel();
        add(imagePanel);
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }
}
