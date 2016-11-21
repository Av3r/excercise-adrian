package object_programming_2.lab5.s_customers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Comparators {

    public static final String SORT_BY_NAME = "Nazwiska";
    public static final String SORT_BY_COSTS = "Koszty";

    public static Map<String, Comparator<Purchase>> getCustomerPurchasesComparators() {
        Map<String, Comparator<Purchase>> comparators = new HashMap<>();

        comparators.put(SORT_BY_NAME, (o1, o2) -> {
            if (o1.getName().equals(o2.getName())) {
                return o1.getClientId().compareTo(o2.getClientId());
            }
            return o1.getName().compareTo(o2.getName());
        });

        comparators.put(SORT_BY_COSTS, (o1, o2) -> {
            if (o1.calculateTotalPrice() == o2.calculateTotalPrice()) {
                return o1.getClientId().compareTo(o2.getClientId());
            }
            Double o1TotalPrice = o1.calculateTotalPrice();
            Double o2TotalPrice = o2.calculateTotalPrice();
            return o2TotalPrice.compareTo(o1TotalPrice);
        });

        return comparators;
    }
}
