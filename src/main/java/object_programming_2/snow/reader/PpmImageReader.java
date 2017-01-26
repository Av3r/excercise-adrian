package object_programming_2.snow.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import object_programming_2.snow.ui.model.Dimension;
import object_programming_2.snow.ui.model.RGBImage;

public class PpmImageReader {

    private static final String REGEX = "\\s+";

    public RGBImage readFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filename)));

        readUnusedLines(reader);
        Dimension dimension = readDimension(reader);
        int rowsNumber = dimension.getHeignt();
        int columnsNumber = dimension.getWidth();

        return readImage(reader, rowsNumber, columnsNumber, dimension);
    }

    private RGBImage readImage(BufferedReader reader, int rowsNumber, int columnsNumber, Dimension dimension)
            throws IOException {
        short[][] r = new short[rowsNumber][columnsNumber];
        short[][] g = new short[rowsNumber][columnsNumber];
        short[][] b = new short[rowsNumber][columnsNumber];

        reader.readLine();
        String line;
        int loc = 0;
        while ((line = reader.readLine()) != null) {
            String[] numbers = line.split(REGEX);
            for (int i = 0; i < numbers.length; i++) {
                int rawLoc = loc / 3;
                int row = rawLoc / columnsNumber;
                int column = rawLoc % columnsNumber;
                int color = loc % 3;
                if (color == 0) {
                    r[row][column] = Short.parseShort(numbers[i]);
                } else if (color == 1) {
                    g[row][column] = Short.parseShort(numbers[i]);
                } else if (color == 2) {
                    b[row][column] = Short.parseShort(numbers[i]);
                }
                loc += 1;
            }
        }
        return new RGBImage(r, g, b, dimension);
    }

    private static Dimension readDimension(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        Scanner scanner = new Scanner(line);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        return new Dimension(width, height);
    }

    private static void readUnusedLines(BufferedReader reader) throws IOException {
        reader.readLine();
        reader.readLine();
    }
}
