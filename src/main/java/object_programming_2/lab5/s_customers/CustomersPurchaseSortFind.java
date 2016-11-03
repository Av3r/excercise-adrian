package object_programming_2.lab5.s_customers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersPurchaseSortFind {

    private List<CustomerPurchase> customerPurchases;

    public void readFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            customerPurchases = lines.stream()
                    .map(this::mapLineToCustomerPurchase)
                    .collect(Collectors.toList());
            customerPurchases.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CustomerPurchase mapLineToCustomerPurchase(String line) {
        return new CustomerPurchase("123","aaa","123123","asdasd","adsadasd");
    }

    public void showSortedBy(String name) {

    }

    public void showPurchaseFor(String clientId) {

    }

}
