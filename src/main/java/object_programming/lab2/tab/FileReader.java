package object_programming.lab2.tab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReader {

    public ArrayList<Integer> readArrayFromFile(String filePath) throws FileNotFoundException {
        ArrayList<Integer> numbers = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNext()){
            numbers.add(scanner.nextInt());
        }

        return numbers;
    }

}
