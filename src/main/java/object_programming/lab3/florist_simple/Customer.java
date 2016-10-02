package object_programming.lab3.florist_simple;

import object_programming.lab3.florist_simple.flowers.Flower;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private int amount;

    private List<Flower> boughtFlowers = new ArrayList<>();

    public Customer(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public void get(Flower flower) {
        boughtFlowers.add(flower);
    }

    public ShoppingCart getShoppingCart() {
        return new ShoppingCart(this);
    }

    public void pay() {
        PriceList priceList = PriceList.getInstance();

        List<Flower> flowersToRemove = new ArrayList<>();
        boughtFlowers.forEach(flower -> {
            if (!priceList.exists(flower.getName())) {
                flowersToRemove.add(flower);
            }
        });

        flowersToRemove.forEach(flower -> boughtFlowers.remove(flower));

        flowersToRemove.clear();
        boughtFlowers.forEach(flower -> {
            double flowerCost = flower.getCount() * priceList.getPrice(flower.getName());
            if(this.amount >= flowerCost){
                this.amount -= flowerCost;
            } else {
                flowersToRemove.add(flower);
            }
        });

        flowersToRemove.forEach(flower -> boughtFlowers.remove(flower));
    }

    public double getCash() {
        return amount;
    }

    public void pack(Box box) {
        box.addFlowers(this.boughtFlowers);
        this.boughtFlowers.clear();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (boughtFlowers.isEmpty()) {
            sb.append(" -- pusto");
        } else {
            boughtFlowers.forEach(flower -> sb.append("\n").append(flower.toString()));
        }
        return sb.toString();
    }
}
