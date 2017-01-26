package object_programming_2.snow.ui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import object_programming_2.snow.ui.model.RGBImage;

class ImagePanel extends JPanel {

    private final RGBImage rgbImage;
    private final Dimension dimension;

    public ImagePanel(RGBImage image) {
        int width = image.getDimension().getWidth();
        int height = image.getDimension().getHeignt();

        this.rgbImage = image;
        this.dimension = new Dimension(width, height);

        setPanelSize(image);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawImage(g);
        drawMirroredImage(g);
    }

    private void drawImage(Graphics g) {
        for (int i = 0; i < dimension.getWidth(); i++) {
            for (int j = 0; j < dimension.getHeight(); j++) {
                short red = rgbImage.getRed()[j][i];
                short green = rgbImage.getGreen()[j][i];
                short blue = rgbImage.getBlue()[j][i];
                Color color = new Color(red, green, blue);
                g.setColor(color);
                g.drawLine(i, j, i, j);
            }
        }
    }

    private void drawMirroredImage(Graphics g) {
        for (int i = 0; i < dimension.getWidth(); i++) {
            for (int j = 0; j < dimension.getHeight(); j++) {
                double mirroredHeight = dimension.getHeight() - j - 1;
                short red = rgbImage.getRed()[(int) mirroredHeight][i];
                short green = rgbImage.getGreen()[(int) mirroredHeight][i];
                short blue = rgbImage.getBlue()[(int) mirroredHeight][i];
                Color color = new Color(red, green, blue);
                g.setColor(color);
                int height = (int) (j + dimension.getHeight());
                g.drawLine(i, height, i, height);
            }
        }
    }

    private void setPanelSize(RGBImage image) {
        short[][] red = image.getRed();
        Dimension dimension = new Dimension(red[0].length, red.length * 2);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setPreferredSize(dimension);
    }

}
