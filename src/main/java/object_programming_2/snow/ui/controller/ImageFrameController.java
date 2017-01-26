package object_programming_2.snow.ui.controller;

import object_programming_2.snow.reader.PpmImageReader;
import object_programming_2.snow.ui.model.RGBImage;
import object_programming_2.snow.ui.view.ImageFrame;

import java.io.IOException;

public class ImageFrameController {

    private ImageFrame imageFrame;
    private PpmImageReader ppmImageReader;

    public ImageFrameController(String imagePath) throws IOException {
        ppmImageReader = new PpmImageReader();
        RGBImage image = ppmImageReader.readFile(imagePath);
        imageFrame = new ImageFrame(image);
    }

    public void showFrame() {
        imageFrame.setVisible(true);
    }
}
