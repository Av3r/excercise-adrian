package object_programming.lab8.imgview.ui.view;

import com.google.common.base.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {

    private BufferedImage image;
    private String text;
    private int fontSize;

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }

    public void setText(String text, int fontSize) {
        this.text = text;
        this.fontSize = fontSize;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!Strings.isNullOrEmpty(text)) {
            drawStringMiddleOfPanel(g);
        } else if (image != null) {
            Image scaledImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
            g.drawImage(scaledImage, 0, 0, null);
        }
    }

    private void drawStringMiddleOfPanel(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, fontSize));
        FontMetrics fm = g.getFontMetrics();

        int stringWidth = fm.stringWidth(text);
        int stringAccent = fm.getAscent();
        int xCoordinate = getWidth() / 2 - stringWidth / 2;
        int yCoordinate = getHeight() / 2 + stringAccent / 2;

        g.drawString(text, xCoordinate, yCoordinate);
    }
}
