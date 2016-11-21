package object_programming_2.lab5.s_customers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomersPurchaseSortFind {

    private static final String ROW_DELIMITER = ";";
    private static final int CLIENT_ID_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int PRODUCT_NAME_INDEX = 2;
    private static final int PRICE_INDEX = 3;
    private static final int QUANTITY_INDEX = 4;

    private List<Purchase> purchases;

    private Map<String, Comparator<Purchase>> comparators = Comparators.getCustomerPurchasesComparators();

    public void readFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            purchases = lines.stream()
                    .map(this::mapLineToCustomerPurchase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Purchase mapLineToCustomerPurchase(String line) {
        String[] tokens = line.split(ROW_DELIMITER);
        String clientId = tokens[CLIENT_ID_INDEX];
        String name = tokens[NAME_INDEX];
        String productName = tokens[PRODUCT_NAME_INDEX];
        double price = Double.parseDouble(tokens[PRICE_INDEX]);
        double quantity = Double.parseDouble(tokens[QUANTITY_INDEX]);
        return new Purchase(clientId, name, productName, price, quantity);
    }

    public void showSortedBy(String name) {
        System.out.println(name);
        List<Purchase> sortedPurchases = purchases.stream()
                .sorted(comparators.get(name))
                .collect(Collectors.toList());

        if (Comparators.SORT_BY_NAME.equals(name)) {
            sortedPurchases.forEach(System.out::println);
        } else if (Comparators.SORT_BY_COSTS.equals(name)) {
            sortedPurchases.forEach(purchase ->
                    System.out.println(purchase.toStringWithTotalPrice()));
        }

        System.out.println();
    }

    public void showPurchaseFor(String clientId) {
        System.out.println("Klient " + clientId);
        purchases.stream()
                .filter(purchase -> purchase.getClientId().equals(clientId))
                .forEach(System.out::println);
        System.out.println();
    }

}
