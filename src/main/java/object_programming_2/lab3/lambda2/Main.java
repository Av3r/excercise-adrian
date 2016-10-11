package object_programming_2.lab3.lambda2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Lista destynacji: port_wylotu port_przylotu cena_EUR
        List<String> dest = Arrays.asList(
                "bleble bleble 2000",
                "WAW HAV 1200",
                "xxx yyy 789",
                "WAW DPS 2000",
                "WAW HKT 1000"
        );
        double ratePLNvsEUR = 4.30;
        List<String> result = dest.stream()
                .filter(s -> s.startsWith("WAW"))
                .map(s -> {
                    Scanner scanner = new Scanner(s);
                    String from = scanner.next();
                    String to = scanner.next();
                    int price = scanner.nextInt();
                    double priceInPln = price * ratePLNvsEUR;
                    return String.format("to %s - price in PLN:  %.0f", to, priceInPln);
                })
                .collect(Collectors.toList());

        for (String r : result) System.out.println(r);
    }

}
