package object_programming.lab5.collatz;


import java.util.Iterator;

public class Hailstone implements Iterable<Integer> {
    private int number;

    public Hailstone(int initialNumber) {
        this.number = initialNumber;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number != 1;
            }

            @Override
            public Integer next() {
                if (number % 2 == 0) {
                    number /= 2;
                    return number;
                } else {
                    number = 3 * number + 1;
                    return number;
                }
            }
        };
    }
}
