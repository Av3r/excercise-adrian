package object_programming.lab4.reversible;

public class Main {
    public static void main(String[] args) {
        Reversible[] revers = new Reversible[]{
                new ReversibleString("Kot"),
                new ReversibleDouble(2),
                new ReversibleDouble(3),
                new ReversibleString("Pies"),
                new ReversibleString("Ala ma kota i psa"),
                new ReversibleDouble(10),
        };

        System.out.println("Normalne:");
        for (Reversible r : revers) {
            System.out.println(r);
        }

        for (Reversible r : revers) {
            r.reverse();
        }

        System.out.println("Odwrocone:");
        for (Reversible r : revers) {
            System.out.println(r);
        }

        System.out.println("Przywrocone i zmienione:");
        for (Reversible r : revers) {
            r.reverse();
            r.changeValue();
            System.out.println(r);
        }
    }
}
