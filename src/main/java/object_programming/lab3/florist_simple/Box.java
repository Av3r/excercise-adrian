package object_programming.lab3.florist_simple;

import object_programming.lab3.florist_simple.flowers.Flower;

import java.util.ArrayList;
import java.util.List;

public class Box {

    private List<Flower> flowers = new ArrayList<>();
    private Customer customer;

    public Box(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pudełko właścicel ");
        sb.append(customer.getName());
        flowers.forEach(flower -> sb.append("\n").append(flower.toString()));
        return sb.toString();
    }

    public void addFlowers(List<Flower> flowers) {
        flowers.forEach(flower -> this.flowers.add(flower));
    }

    public List<Flower> getFlowers() {
        return flowers;
    }
}
