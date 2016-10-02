package object_programming.lab2.tab;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String userHome = System.getProperty("user.home");

        FileReader fileReader = new FileReader();
        ArrayUtil arrayUtil = new ArrayUtil();

        try {
            ArrayList<Integer> numbersList = fileReader.readArrayFromFile(userHome + "/tab.txt");
            int[] numbersArray = numbersList.stream().mapToInt(i -> i).toArray();

            arrayUtil.printArray(numbersArray);

            int max = arrayUtil.countMax(numbersArray);
            System.out.println(max);

            arrayUtil.fidIndexes(numbersArray, max);
        } catch (Exception e) {
            System.out.println("***");
        }
    }
}
