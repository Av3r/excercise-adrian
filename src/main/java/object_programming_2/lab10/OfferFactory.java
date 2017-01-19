package object_programming_2.lab10;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OfferFactory {

    private static final String DELIMITER = "\t";

    public Offer create(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(DELIMITER);
        return createOffer(scanner);
    }

    public List<Offer> create(List<String> lines) {
        return lines.stream()
                .map(this::create)
                .collect(Collectors.toList());
    }

    private Offer createOffer(Scanner scanner) {
        String locale = scanner.next();
        String country = scanner.next();
        String startDate = scanner.next();
        String endDate = scanner.next();
        String place = scanner.next();
        String price = scanner.next();
        String currency = scanner.next();

        return new Offer(locale, country, startDate, endDate, place, price, currency);
    }
}
