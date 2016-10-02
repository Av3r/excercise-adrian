package object_programming.lab3.florist_simple;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
    private static PriceList ourInstance = new PriceList();

    public static PriceList getInstance() {
        return ourInstance;
    }

    private Map<String, Double> prices = new HashMap<>();

    private PriceList() {
    }

    public void put(String flowerName, double price) {
        prices.put(flowerName, price);
    }

    public double getPrice(String flowerName){
        if(!prices.containsKey(flowerName)) return -1.0;
        return prices.get(flowerName);
    }

    public boolean exists(String flowerName){
        return prices.containsKey(flowerName);
    }
}
