package object_programming.lab2.tab;

public class ArrayUtil {

    public void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public int countMax(int[] numbers) {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public void fidIndexes(int[] numbers, int searchingNumber) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchingNumber) {
                System.out.print(i + " ");
            }
        }
    }

}
