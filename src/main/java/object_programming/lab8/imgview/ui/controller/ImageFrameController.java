package object_programming.lab8.imgview.ui.controller;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import object_programming.lab8.imgview.ui.model.AvailableImagesExtensions;
import object_programming.lab8.imgview.ui.view.ImageFrame;
import object_programming.lab8.imgview.ui.view.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImageFrameController {

    private final Path dirPath;
    private final int imagePreviewInSec;
    private final int fontSize;

    private final ImageFrame imageFrame;

    public ImageFrameController(Path dirPath, int imagePreviewInSec, int fontSize) {
        this.dirPath = dirPath;
        this.imagePreviewInSec = imagePreviewInSec;
        this.fontSize = fontSize;

        this.imageFrame = new ImageFrame();
    }

    public void showFrame() {
        imageFrame.setVisible(true);
        findAndShowImages();
    }

    private void findAndShowImages() {
        try {
            ImagePanel imagePanel = imageFrame.getImagePanel();
            List<Path> images = findImages(dirPath);
            images.forEach(path -> {
                readImage(imagePanel, path);
                sleep();
            });
            imagePanel.setText("Koniec prezentacji", fontSize);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Wystąpił błąd podczas wczytywania obrazków",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    private void readImage(ImagePanel imagePanel, Path path) {
        try {
            BufferedImage image = ImageIO.read(new File(path.toString()));
            imagePanel.setText(null, fontSize);
            if (image == null) {
                imagePanel.setText("Brak obrazka", fontSize);
            } else {
                imagePanel.setImage(image);
                imageFrame.setSize(image.getWidth(), image.getHeight());
                imageFrame.setLocationRelativeTo(null);
            }
        } catch (IOException e) {
            imagePanel.setText("Brak obrazka", fontSize);
        }
    }

    private void sleep() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(imagePreviewInSec));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<Path> findImages(Path dirPath) throws IOException {
        final List<Path> imagesPaths = Lists.newArrayList();

        java.nio.file.Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (isImageFile(file)) {
                    imagesPaths.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        return imagesPaths;
    }

    private boolean isImageFile(Path file) {
        String ext = Files.getFileExtension(file.toString());
        List<String> availableExtensions = AvailableImagesExtensions.getAvailableExtensions();
        return availableExtensions.contains(ext);
    }
}
