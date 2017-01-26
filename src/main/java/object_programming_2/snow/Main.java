package object_programming_2.snow;

import object_programming_2.snow.ui.controller.ImageFrameController;

import javax.swing.*;
import java.io.IOException;

public class Main {

    private static final String FILE_PATH = "data/Snow.ppm";

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> {
            try {
                ImageFrameController controller = new ImageFrameController(FILE_PATH);
                controller.showFrame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
