package object_programming.lab1.finder;

import java.io.IOException;

public class Main {
    public static void main(String ... args) throws IOException {
        String home = System.getProperty("user.home");
        Finder finder = new Finder(home + "/Test.java");
        int nif = finder.getIfCount();
        int nwar = finder.getStringCount("wariant");
        System.out.println("Liczba instrukcji if: " + nif);
        System.out.println("Liczba napisow wariant: " + nwar);
    }

}


