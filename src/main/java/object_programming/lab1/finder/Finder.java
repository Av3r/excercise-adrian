package object_programming.lab1.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Finder {
    private String filePath;

    public Finder(String filePath) {
        this.filePath = filePath;
    }

    public int getIfCount() throws IOException {
        return getCount("if");
    }

    public int getStringCount(String text) throws IOException {
        return getCount(text);
    }

    private int getCount(String text) throws IOException {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        int counter = 0;
        for (String line : lines) {
            if (line.contains(text)) {
                counter++;
            }
        }
        return counter;
    }
}
