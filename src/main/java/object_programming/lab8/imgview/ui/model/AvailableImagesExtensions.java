package object_programming.lab8.imgview.ui.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum AvailableImagesExtensions {

    JPG("jpg"),
    GIF("gif"),
    PNG("png");

    private String extension;

    AvailableImagesExtensions(String extension) {
        this.extension = extension;
    }

    public static List<String> getAvailableExtensions(){
        return Stream.of(values())
                .map(e -> e.extension)
                .collect(Collectors.toList());
    }
}
