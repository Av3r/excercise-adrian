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
                short red = rgbImage.getRed()[i][j];
                short green = rgbImage.getGreen()[i][j];
                short blue = rgbImage.getBlue()[i][j];
                Color color = new Color(red, green, blue);
                g.setColor(color);
                g.drawLine(i, j, i, j);
            }
        }
    }

    private void drawMirroredImage(Graphics g) {
        for (int i = (int) (dimension.getWidth()-1); i >= 0; i--) {
            for (int j = 0; j < dimension.getHeight(); j++) {
                short red = rgbImage.getRed()[i][j];
                short green = rgbImage.getGreen()[i][j];
                short blue = rgbImage.getBlue()[i][j];
                Color color = new Color(red, green, blue);
                g.setColor(color);
                g.drawLine(i, (int) (j + dimension.getHeight()), i, (int) (j + dimension.getHeight()));
            }
        }
    }

    private void setPanelSize(RGBImage image) {
        short[][] red = image.getRed();
        Dimension dimension = new Dimension(red.length, red[0].length * 2);

        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setPreferredSize(dimension);
    }

}
