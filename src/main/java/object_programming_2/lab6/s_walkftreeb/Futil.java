package object_programming_2.lab6.s_walkftreeb;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Futil {

    private static final String TXT_EXTENSION = ".txt";
    private static final String UTF_8_ENCODING = "UTF-8";
    private static final String WINDOWS_1250_ENCODING = "windows-1250";

    public static void processDir(String dirPath, String resultFileName) {
        try {
            Path resultFilePath = Paths.get(resultFileName);
            List<Path> pathsToFiles = getPathsToTxtFilesRecursively(dirPath);

            List<String> resultLines = pathsToFiles.stream()
                    .map(Futil::getLinesFromFile)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

            Files.write(resultFilePath, resultLines, Charset.forName(UTF_8_ENCODING));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getLinesFromFile(Path path) {
        try {
            return Files.readAllLines(path, Charset.forName(WINDOWS_1250_ENCODING));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private static List<Path> getPathsToTxtFilesRecursively(String dirPath) throws IOException {
        List<Path> pathsToFiles = new ArrayList<>();
        Path pathToDir = Paths.get(dirPath);

        Files.walkFileTree(pathToDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(TXT_EXTENSION)) {
                    pathsToFiles.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        return pathsToFiles;
    }
}
