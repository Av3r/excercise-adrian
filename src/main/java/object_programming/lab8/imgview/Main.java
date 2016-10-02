package object_programming.lab8.imgview;

import object_programming.lab8.imgview.ui.controller.ImageFrameController;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path dirPath = Paths.get(args[0]);
        int imagePreviewInSec = Integer.parseInt(args[1]);
        int fontSize = Integer.parseInt(args[2]);

        ImageFrameController controller =
                new ImageFrameController(dirPath, imagePreviewInSec, fontSize);
        controller.showFrame();
    }
}
